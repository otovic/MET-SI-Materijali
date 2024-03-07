import socket

# kreiranje socketa i povezivanje sa serverom
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(('localhost', 12345))

# slanje poruke serveru
message = "Hello, server!"
client_socket.sendall(message.encode('utf-8'))

client_socket.close()