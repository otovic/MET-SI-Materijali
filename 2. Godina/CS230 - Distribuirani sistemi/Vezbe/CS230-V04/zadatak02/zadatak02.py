import threading
import time


print_lock = threading.Lock()

def print_numbers():
    for i in range(1, 6):
        # Zaključavamo ispis kako bi se osiguralo da samo jedna nit može pristupiti terminalu u jednom trenutku
        with print_lock:
            print(f"Thread {threading.current_thread().name}: {i}")
        time.sleep(1)

thread1 = threading.Thread(target=print_numbers, name="Thread 1")
thread2 = threading.Thread(target=print_numbers, name="Thread 2")

thread1.start()
thread2.start()

thread1.join()
thread2.join()

print("Multithreading example is done!")
