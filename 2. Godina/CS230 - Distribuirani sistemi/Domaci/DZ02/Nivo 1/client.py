from socket  import *
HOST = '127.0.0.1'
PORT = 12345

s = socket(AF_INET, SOCK_STREAM)
s.connect((HOST, PORT))

msg = "Sindakvil"

s.send(msg.encode())

data = s.recv(1024)

print("Text in sha256: " + data.decode())

s.close() 
