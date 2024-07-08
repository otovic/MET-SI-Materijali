from socket import *

req = socket(AF_INET, SOCK_STREAM)
req.connect(("localhost", 1234))

req.sendall("Message".encode("utf-8"))
msg = req.recv(1024).decode("utf_8")
print(msg)