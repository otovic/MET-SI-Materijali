import threading
import time
from queue import Queue


data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Function for the "map" phase
def mapper(in_queue, out_queue):
    while True:
        item = in_queue.get()
        if item is None:
            break
        out_queue.put(item * 2)
        in_queue.task_done()


def reducer(in_queue):
    while True:
        item = in_queue.get()
        if item is None:
            in_queue.task_done()
            break
        print("Reduced value:", item)
        in_queue.task_done()


map_queue = Queue()
reduce_queue = Queue()


mapper_threads = []
for _ in range(4):
    t = threading.Thread(target=mapper, args=(map_queue, reduce_queue))
    t.start()
    mapper_threads.append(t)


reducer_thread = threading.Thread(target=reducer, args=(reduce_queue,))
reducer_thread.start()


for item in data:
    map_queue.put(item)

# Waiting for map_queue to be empty
map_queue.join()

# Stopping mapper threads
for _ in range(4):
    map_queue.put(None)
for t in mapper_threads:
    t.join()

# Stopping reducer thread
reduce_queue.put(None)
reducer_thread.join()

print("MapReduce simulation done.")