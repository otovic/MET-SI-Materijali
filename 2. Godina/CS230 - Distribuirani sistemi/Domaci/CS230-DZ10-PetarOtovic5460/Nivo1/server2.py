import socket
import os

HOST = 'localhost'
PORT = 2222

def get_last_modified_time(folder):
    file_path = os.path.join(folder, 'data.txt')
    return os.path.getmtime(file_path)


with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    print("Server 2 is listening for connections...")
    conn, addr = s.accept()
    with conn:
        print(f"Connected by {addr}")

        request = conn.recv(1024).decode()
        if 'new_content:' in request:
            new_content = request.split('new_content:')[1]
            print("Received new content:", new_content)
            conn.sendall('Content received and saved.')
        else:
            print("Invalid request from Server 1")
            conn.sendall(b'Invalid request.')
