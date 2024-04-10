import socket
import requests

def check_url(url):
    try:
        response = requests.head(url, timeout=10)
        return str(response.status_code)
    except requests.ConnectionError:
        return "404"

def worker_node(server_host, server_port):
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((server_host, server_port))

    while True:
        url = client_socket.recv(1024).decode()
        print("URL received: ", url)

        if url == "EXIT":
            break

        url = check_url(url)

        client_socket.sendall(url.encode())

    client_socket.close()

SERVER_HOST = '127.0.0.1'
SERVER_PORT = 12344

worker_node(SERVER_HOST, SERVER_PORT)
