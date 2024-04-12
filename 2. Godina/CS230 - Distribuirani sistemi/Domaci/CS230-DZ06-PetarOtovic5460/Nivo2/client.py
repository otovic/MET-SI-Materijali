import socket

def main():
    server_address = '127.0.0.1'
    server_port = 8888

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    client_socket.connect((server_address, server_port))
    print(f"Connected to server at {server_address}:{server_port}")

    message = input("Enter a message: ")

    client_socket.sendall(message.encode())

    modified_message = client_socket.recv(1024).decode()

    print("Modified message from server:", modified_message)

    client_socket.close()

if __name__ == "__main__":
    main()
