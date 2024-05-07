from lampart_clock import LampartClock

process1 = LampartClock()
process2 = LampartClock()

process1.send_message(process2, "Test message")
process2.send_message(process1, "Test message")
process1.send_message(process2, "Test message")
process2.send_message(process1, "Test message")

print("Logicko vreme procesa 1:", process1.get_time())
print("Logicko vreme procesa 2:", process2.get_time())