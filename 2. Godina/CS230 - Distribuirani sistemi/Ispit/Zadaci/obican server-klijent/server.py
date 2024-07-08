import socket
import hashlib

HOST = "localhost"
PORT = 12345

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((HOST, PORT))
server_socket.listen(5)

while True:
    client_socket, addr = server_socket.accept()
    data = client_socket.recv(1024).decode('utf-8')

    if not data:
        break

    print(f"Primljena poruka od klijenta: {data}")

    message = "Odgovor sa servera"
    response = hashlib.sha256(message.encode('utf-8')).hexdigest()

    client_socket.sendall(response.encode('utf-8'))
    client_socket.close()

server_socket.close()