import socket
import threading
import os


file_list = ["file1.txt", "file2.txt", "file3.txt"]

file_processing_lock = threading.Lock()

def handle_worker(worker_socket):
    while True:
        request = worker_socket.recv(1024).decode()

        if request == "request_file":
            with file_processing_lock:
                if file_list:
                    filename = file_list.pop(0)
                else:
                    filename = None


            if filename:
                with open(filename, "rb") as file:
                    file_data = file.read()
                    worker_socket.sendall(file_data)
            else:
                worker_socket.sendall(b"No more files")
        elif request == "disconnect":
            break

    worker_socket.close()

def main():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(("127.0.0.1", 8888))
    server_socket.listen(5)

    print("Server listening on port 8888...")

    while True:
        worker_socket, address = server_socket.accept()
        print(f"Connection from {address} established.")


        worker_thread = threading.Thread(target=handle_worker, args=(worker_socket,))
        worker_thread.start()

if __name__ == "__main__":
    main()