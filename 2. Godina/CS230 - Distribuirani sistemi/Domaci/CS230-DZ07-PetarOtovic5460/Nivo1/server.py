import asyncio
import json
 
async def handle_request(reader, writer):
    data = await reader.read(1024)
    request = json.loads(data.decode())
    message = request.get('message')
    print(f"Received message: {message}")
    writer.close()
 
async def main():
    server = await asyncio.start_server(
        handle_request, '127.0.0.1', 8889)
    address = server.sockets[0].getsockname()
    print(f'Serving on {address}')

    async with server:
        await server.serve_forever()
 
asyncio.run(main())