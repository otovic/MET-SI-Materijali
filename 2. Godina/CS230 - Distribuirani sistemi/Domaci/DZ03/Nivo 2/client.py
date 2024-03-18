from socket  import *
HOST = '127.0.0.1'
PORT = 12345

s = socket(AF_INET, SOCK_STREAM)
s.connect((HOST, PORT))

try:
    while True:
        msg = input("Enter message (empty message to quit): ")
        
        if msg == "":
            break
        
        s.send(msg.encode())
        data = s.recv(1024)
        print(data.decode())

except KeyboardInterrupt:
    print("Error, exiting...")

finally:
    s.close()
