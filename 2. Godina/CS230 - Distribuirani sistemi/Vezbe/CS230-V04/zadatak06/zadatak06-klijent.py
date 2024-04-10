import socket
import threading

def process_file(worker_id, server_address):
    worker_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    worker_socket.connect(server_address)

    while True:

        worker_socket.sendall(b"request_file")
        file_data = worker_socket.recv(1024)

        if file_data == b"No more files":
            print(f"Worker {worker_id}: No more files to process.")
            break


        print(f"Worker {worker_id}: File contents:")
        print(file_data.decode())

    worker_socket.sendall(b"disconnect")
    worker_socket.close()

def main():
    server_address = ("127.0.0.1", 8888)


    worker_threads = []
    for i in range(3):
        t = threading.Thread(target=process_file, args=(i+1, server_address))
        t.start()
        worker_threads.append(t)


    for t in worker_threads:
        t.join()

if __name__ == "__main__":
    main()