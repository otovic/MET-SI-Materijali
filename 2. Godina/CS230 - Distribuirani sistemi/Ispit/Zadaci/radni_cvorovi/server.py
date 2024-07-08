from socket import *
import threading

workers = []
lock = threading.Lock()

queue = [
    "poruka1",
    "poruka2",
    "poruka3"
]

def handle_worker(socket, address):
    print(f"Radni cvor povezan: {address}")
    workers.append({"socket": socket, "address": address, "busy": False})

def handle_data():
    while queue:
        if (len(workers) > 0):
            for i in range(len(workers)):
                if not workers[i]["busy"]:
                    with lock:
                        if queue:
                            current = queue.pop(0)
                            workers[i]["busy"] = True
                            workers[i]["socket"].sendall(current.encode("utf-8"))
                            response = workers[i]["socket"].recv(1024).decode()
                            print(f"Odgovor sa radnog svora: {response}")
                            workers[i]["busy"] = False
                elif i == len(workers) - 1:
                    threading.Event().wait(3)
        else:
            print("NEMA")
            threading.Event().wait(2)
    
    for worker in workers:
        worker["socket"].close()
        workers.remove(worker)

def start_server():
    HOST = "localhost"
    PORT = 12345

    server_socket = socket(AF_INET, SOCK_STREAM)
    server_socket.bind((HOST, PORT))
    server_socket.listen(10)

    threading.Thread(target=handle_data).start()

    while True:
        client_socket, adress = server_socket.accept()
        threading.Thread(target=handle_worker, args=(client_socket, adress)).start()

start_server()