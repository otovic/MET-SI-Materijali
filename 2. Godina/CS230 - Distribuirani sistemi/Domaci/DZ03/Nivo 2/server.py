# Razviti jednostavnu aplikaciju za čet koja radi unutar jednog sistema koristeći dva terminala: jedan 
# za slanje poruka (klijent) i drugi za prijem poruka (server). Implementirati interceptor na strani servera
# koji loguje sve dolazne poruke pre nego što ih prikaže na terminalu. Interceptor bi trebao takođe da dodaje 
# vremensku oznaku svakoj poruci.
# Koristiti socket modul za komunikaciju između klijenta i servera. 
# Interceptor može biti implementiran kao funkcija ili dekorator koji omotava funkciju za 
# obradu poruka na serveru.Za dodavanje vremenske oznake koristite Pythonov modul datetime.


import socket
import datetime

def interceptor(func):
    def wrapper(*args, **kwargs):
        time = datetime.datetime.now()
        print(f"{time}: {args[0]}")
        return func(f"{time}: {args[0]}", args[1], **kwargs)
    return wrapper

@interceptor
def send_message(msg, client_socket):
    client_socket.sendall(msg.encode('utf-8'))

HOST = '127.0.0.1'
PORT = 12345

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server_socket.bind((HOST, PORT))

server_socket.listen(5)

print(f"Server listening on {HOST}:{PORT}")

while True:
    client_socket, addr = server_socket.accept()

    data = client_socket.recv(1024).decode('utf-8')

    while data != "":
        send_message(data, client_socket)
        data = client_socket.recv(1024).decode('utf-8')

    if not data:
        break

server_socket.close()