import socket
import os

HOST = 'localhost'
PORT = 3333
S2_FOLDER = 'S2'

def get_last_modified_time(folder):
    file_path = os.path.join(folder, 'data.txt')
    return os.path.getmtime(file_path)

def get_new_content(folder):
    file_path = os.path.join(folder, 'data.txt')
    with open(file_path, 'r', encoding='utf-8') as f:
        return f.read()


with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    print("Server 2 is listening for connections...")
    conn, addr = s.accept()
    with conn:
        print(f"Connected by {addr}")
        while True:
            request = conn.recv(1024).decode()
            if request == 'last_modified_time':
                last_modified_time = str(get_last_modified_time(S2_FOLDER))
                conn.sendall(last_modified_time.encode())
            elif request == 'replicate':
                new_content = get_new_content(S2_FOLDER)
                conn.sendall(new_content.encode())