from multiprocessing import Process
from time import *
from random import *


def sleeper(name):
    t = gmtime()
    s = randint(1, 20)
    txt = str(t.tm_min) + ':' + str(t.tm_sec) + ' ' + name + ' is going to sleep for ' + str(s) + ' seconds'
    print(txt)
    sleep(s)
    t = gmtime()
    txt = str(t.tm_min) + ':' + str(t.tm_sec) + ' ' + name + ' has woken up'
    print(txt)


if __name__ == '__main__':
    p = Process(target=sleeper, args=('primer',))
    q = Process(target=sleeper, args=('primercic',))
    p.start();
    q.start()
    p.join();
    q.join()