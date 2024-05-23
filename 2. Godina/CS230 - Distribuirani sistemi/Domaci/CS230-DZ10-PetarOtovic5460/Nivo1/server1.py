import os
import shutil
import socket

HOST = 'localhost'
PORT = 2222

def load_subjects(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    return lines

def save_subjects(file_path, lines):
    with open(file_path, 'w', encoding='utf-8') as f:
        f.writelines(lines)

def remove_subject(lines, code):
    new_lines = []
    for line in lines:
        if code not in line.strip():
            new_lines.append(line)
    return new_lines

def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        try:
            while True:
                file_path = os.path.join('S1', 'preostali_predmeti.txt')
    
                code = input("Unesite šifru predmeta koji ste položili (ili 'exit' za izlaz): ")
                if code.lower() == 'exit':
                    break
                current = load_subjects(file_path)
                new = remove_subject(current, code)
                save_subjects(file_path, new)
                new_new = load_subjects(file_path)

                s.connect((HOST, PORT))
                s.sendall(b'new_content:' + str(new_new).encode())

                data = s.recv(1024)
                if not data:
                    break
                print('Received', repr(data))
                break
        except ConnectionRefusedError:
            print("Connection to Server 2 was refused. Make sure the server is running and reachable.")
        except ConnectionAbortedError:
            print("Connection to Server 2 was aborted by the host machine.")
        except Exception as e:
            print("An error occurred:", e)

if __name__ == "__main__":
    main()