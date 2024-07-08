import random
import asyncio

async def send_request():
    ports = [8000, 8001, 8002]

    random_port = random.choice(ports)

    HOST = "localhost"

    reader, writer = await asyncio.open_connection(HOST, random_port)
    data = await reader.read(100)
    message = data.decode()

    print(f"Received message: {message}")
    writer.close()
    await writer.wait_closed()

async def main():
    await send_request()

asyncio.run(main())


