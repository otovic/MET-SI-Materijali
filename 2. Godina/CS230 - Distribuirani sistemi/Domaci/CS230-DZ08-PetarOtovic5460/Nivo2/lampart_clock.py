class LampartClock:
    def __init__(self):
        self.time = 0

    def get_time(self):
        return self.time

    def update_time(self, event_time):
        self.time = max(self.time, event_time)

    def send_message(self, destination, message):
        self.time += 1
        destination.receive_message(self, message)

    def receive_message(self, sender, message):
        self.update_time(sender.get_time())
        print(f"Received message '{message}' from sender at logical time {sender.get_time()}.")

if __name__ == "__main__":
    process1 = LampartClock()
    process2 = LampartClock()

    process1.send_message(process2, "Hello!")
    process2.send_message(process1, "Hi!")

    print("Logical time of process 1:", process1.get_time())
    print("Logical time of process 2:", process2.get_time())
