import threading

def log_message(msg):
    print(msg)

messages = [
    "Prva poruka",
    "Druga poruka",
    "Treca poruka"
]

threads = []

for i, message in enumerate(messages):
    thread = threading.Thread(target=log_message, args=(message,))
    thread.start()
    threads.append(thread)

for thread in threads:
    thread.join()
    
print("Gotovo!")