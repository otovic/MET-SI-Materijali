import asyncio
import random

async def send_request(message):
    ports = [{"port": 8000, "index": 0}, {"port": 8001, "index": 1}, {"port": 8002, "index": 2}]
    
    port = random.choice(ports)
    
    reader, writer = await asyncio.open_connection('127.0.0.1', port["port"])
    
    message = f'Hello endpoint {port["index"]}'
    writer.write(message.encode())
    await writer.drain()
    
    data = await reader.read(100)
    response = data.decode()
    print(f'{response}')
    
    writer.close()
    await writer.wait_closed()

async def main():
    await send_request("Hello")

asyncio.run(main())