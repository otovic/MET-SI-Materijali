from socket import *
import threading

HOST = "localhost"
PORT = 1234

def handle_client_request(client, address):
    message = client.recv(1024).decode("utf-8")
    client.sendall("received".encode("utf-8"))
    print(f"received message: {message}")

    while message != "":
        message = client.recv(1024).decode("utf-8")
        print(f"received message: {message}")

def start_server():
    server = socket(AF_INET, SOCK_STREAM)
    server.bind((HOST, PORT))
    server.listen(10)
    print("Server started")

    while True:
        client, address = server.accept()
        print("Connection from client")
        threading.Thread(target=handle_client_request, args=(client, address)).start()

start_server()