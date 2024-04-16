import socket

SERVER_PORT = 12345

def main():
  server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

  server_address = ("", SERVER_PORT)
  print(f"Server listening on port {SERVER_PORT}")
  server_socket.bind(server_address)

  server_socket.listen()

  while True:
    print("Waiting for connection...")
    client_socket, client_address = server_socket.accept()
    print(f"Client connected from {client_address}")

    data = client_socket.recv(1024).decode()
    print(f"Received message: {data}")

    uppercase_data = data.upper()

    client_socket.sendall(uppercase_data.encode())
    print(f"Sent message: {uppercase_data}")

    client_socket.close()
    print("Connection closed.")

if __name__ == "__main__":
  main()