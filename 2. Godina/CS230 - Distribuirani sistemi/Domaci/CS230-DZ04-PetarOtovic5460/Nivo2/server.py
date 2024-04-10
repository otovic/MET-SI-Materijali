import socket
import threading

URL_list = [
    "https://www.google.com",
    "https://www.facebook.com",
    "https://www.amazon.com",
    "https://www.youtube.com",
    "https://www.yahoo.com",
    "https://www.wikipedia.org",
    "https://www.twitter.com",
    "https://www.instagram.com",
    "https://www.linkedin.com",
    "https://www.reddit.com",
    "https://www.netflix.com",
    "https://www.microsoft.com",
    "https://www.apple.com",
    "https://www.ebay.com",
    "https://www.twitch.tv",
    "https://www.spotify.com",
    "https://www.pinterest.com",
    "https://www.imdb.com",
    "https://www.whatsapp.com",
    "https://www.dropbox.com",
    "https://www.imgur.com",
    "https://www.gitlab.com",
    "https://www.hulu.com",
    "https://www.stackoverflow.com",
    "https://www.github.com",
    "https://www.medium.com",
    "https://www.quora.com",
    "https://www.wordpress.com",
    "https://www.theguardian.com",
    "https://www.bbc.co.uk",
    "https://www.nytimes.com",
    "https://www.cnn.com",
    "https://www.aljazeera.com",
    "https://www.nationalgeographic.com",
    "https://www.bloomberg.com",
    "https://www.wsj.com",
    "https://www.forbes.com",
    "https://www.businessinsider.com",
    "https://www.cnet.com",
    "https://www.theverge.com",
    "https://www.techcrunch.com",
    "https://www.engadget.com",
    "https://www.wired.com",
    "https://www.reuters.com",
    "https://www.buzzfeed.com",
    "https://www.mashable.com",
    "https://www.vice.com",
    "https://www.buzzfeednews.com",
    "https://www.thedailybeast.com",
    "https://www.cnbc.com"
]

lock = threading.Lock()
connected_workers = []

def handle_worker(worker_socket, address):
    print(f"Novi radni cvor povezan: {address}")
    connected_workers.append({"socket": worker_socket, "busy": False})

def send_data_to_worker():
    while URL_list:
        for i in range(len(connected_workers)):
            if not connected_workers[i]["busy"]:
                with lock:
                    if URL_list:
                        url = URL_list.pop(0)
                    else:
                        break 
                connected_workers[i]["busy"] = True
                connected_workers[i]["socket"].sendall(f"{url}".encode())
                msg = connected_workers[i]["socket"].recv(1024).decode()
                print(f"Radni cvor {i} -> Status za {url} je: {msg}")
                connected_workers[i]["busy"] = False
            else:
                if i == len(connected_workers) - 1:
                    threading.Event().wait(3)
        
    for worker in connected_workers:
        worker["socket"].sendall("EXIT".encode())
        connected_workers.remove(worker)

    print("Svi URL-ovi su obradjeni")

def start_server(host, port):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    server_socket.bind((host, port))
    server_socket.listen(5)
    print(f"Centralni server je pokrenut {host}:{port}")

    threading.Thread(target=send_data_to_worker).start()

    while True:
        client_socket, address = server_socket.accept()
        threading.Thread(target=handle_worker, args=(client_socket, address)).start()

SERVER_HOST = '127.0.0.1'
SERVER_PORT = 12344

start_server(SERVER_HOST, SERVER_PORT)
