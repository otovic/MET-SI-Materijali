from socket import *

HOST = "localhost"
PORT = 12345

def worker_node():
    try:
        wsocket = socket(AF_INET, SOCK_STREAM)
        wsocket.connect((HOST, PORT))
        res = wsocket.recv(1024).decode("utf-8")

        while res != "EXIT":
            wsocket.sendall("done".encode("utf-8"))
            print(res)
            res = wsocket.recv(1024).decode("utf-8")
    except Exception as e:
        print("Zatvorena konekcija")

worker_node()