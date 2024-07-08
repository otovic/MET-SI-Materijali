from socket import *

HOST = "localhost"
PORT = 12345

client_socket = socket(AF_INET, SOCK_STREAM)
client_socket.connect((HOST, PORT))

message = "Ovo je poruka sa klijenta"

client_socket.send(message.encode("utf-8"))
response = client_socket.recv(1024)

print(f"Odgovor sa servera: {response}")

client_socket.close()