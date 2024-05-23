import socket
import os

HOST = 'localhost'
PORT = 3333
S1_FOLDER = 'Nivo2/S1'

def get_last_modified_time(folder):
    file_path = os.path.join(folder, 'data.txt')
    return os.path.getmtime(file_path)

def set_new_content(folder, content):
    file_path = os.path.join(folder, 'data.txt')
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(content)


with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    try:
        s.connect((HOST, PORT))
        s.sendall(b'last_modified_time')
        remote_last_modified_time = float(s.recv(1024).decode())

        local_last_modified_time = get_last_modified_time(S1_FOLDER)
        if remote_last_modified_time > local_last_modified_time:
            print("File on Server 2 is newer. Data replication needed.")
            s.sendall(b'replicate')
            new_content = s.recv(1024).decode()
            set_new_content(S1_FOLDER, new_content)
        else:
            print("File on Server 1 is newer. No replication needed.")
    except ConnectionRefusedError:
        print("Connection to Server 2 was refused. Make sure the server is running and reachable.")
    except ConnectionAbortedError:
        print("Connection to Server 2 was aborted by the host machine.")
    except Exception as e:
        print("An error occurred:", e)
