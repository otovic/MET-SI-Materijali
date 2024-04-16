import asyncio

import asyncio
import json
 
class Middleware:
    def __init__(self):
        self.data = {}
 
    async def handle_client(self, reader, writer):
        while True:
            data = await reader.read(1024)
            if not data:
                break
 
            request = json.loads(data.decode())
            message = request.get('message')
            
            s_reader, s_writer = await asyncio.open_connection('127.0.0.1', 8889)
            await s_writer.write(json.dumps({'message': message}).encode())

            writer.write(json.dumps({'message': 'Message sent to server'}).encode())
            await writer.drain()
            s_writer.close()
 
        writer.close()
 
async def main():
    middleware = Middleware()
    server = await asyncio.start_server(
        middleware.handle_client, '127.0.0.1', 8888)
 
    addr = server.sockets[0].getsockname()
    print(f'Middleware serving on {addr}')
 
    async with server:
        await server.serve_forever()
 
asyncio.run(main())