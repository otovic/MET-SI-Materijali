#Socket programiranje u Python-u je vrsta programiranja koja omogucava konekciju izmedju klijenta i servera. Klijent i server
#komuniciraju preko mreze putem socketa. Sockets su endpointi za komunikaciju izmedju dva programa. Socket je jedinstveni
#identifikator koji se koristi za komunikaciju izmedju dva programa. Socket se moze koristiti za komunikaciju izmedju dva
#procesa na istom racunaru ili izmedju dva racunara na mrezi. Socket se moze koristiti za komunikaciju izmedju dva racunara
#na mrezi putem IP adrese i port broja. IP adresa je jedinstveni identifikator racunara na mrezi, dok je port broj jedinstveni
#identifikator procesa na racunaru.

#Izvor: https://www.geeksforgeeks.org/socket-programming-python/

import socket

HOST = 'localhost' #adresa na kojoj ce se pokrenuti server
PORT = 12345 #port na kojem ce se pokrenuti server, moze da se desi da je izabrani port zauzet pa treba izabrati drugi

#kreiranje socketa i pokretanje servera
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((HOST, PORT))
server_socket.listen(5)

print("Server slusa na portu" + PORT)

#prihvatanje konekcije od strane klijenta
client_socket, addr = server_socket.accept()
print("Ostvarena konekcija sa klijentom: " + addr)

#obrada podataka koji su poslati od strane klijenta
data = client_socket.recv(1024)
print("Primljeni podaci od strane klijenta:" + data.decode('utf-8'))

#zatvaranje konekcije sa klijentom
client_socket.close()
server_socket.close()