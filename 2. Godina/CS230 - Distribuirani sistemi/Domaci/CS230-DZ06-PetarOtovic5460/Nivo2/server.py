import socket

def handle_client(client_socket):
    while True:
        message = client_socket.recv(1024).decode()
        if not message:
            break

        modified_message = message.upper()

        client_socket.sendall(modified_message.encode())

    client_socket.close()

def main():
    host = '127.0.0.1'
    port = 8888

    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    server_socket.bind((host, port))

    server_socket.listen(5)
    print(f"Server listening on {host}:{port}")

    while True:
        client_socket, client_address = server_socket.accept()
        print(f"Connection from {client_address}")

        handle_client(client_socket)

if __name__ == "__main__":
    main()
