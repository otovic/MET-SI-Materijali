import socket
import hashlib

HOST = '127.0.0.1'
PORT = 12345

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server_socket.bind((HOST, PORT))

server_socket.listen(5)

print(f"Server listening on {HOST}:{PORT}")

while True:
    client_socket, addr = server_socket.accept()

    print(f"Connection from {addr}")

    data = client_socket.recv(1024).decode('utf-8')

    if not data:
        break

    response = hashlib.sha256(data.encode('utf-8')).hexdigest()

    client_socket.sendall(response.encode('utf-8'))

    client_socket.close()

server_socket.close()