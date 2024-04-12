import asyncio
import json

async def handle_client(reader, writer):
    while True:
        data = await reader.read(1024)
        if not data:
            break

        request = json.loads(data.decode())
        operation = request.get('operation')
        a = request.get('a')
        b = request.get('b')

        if operation == '1':
            result = a + b
            writer.write(json.dumps({'result': result}).encode())
            writer.close()
        
        if operation == '2':
            result = a - b
            writer.write(json.dumps({'result': result}).encode())

        if operation == '3':
            result = a * b
            writer.write(json.dumps({'result': result}).encode())

        if operation == '4':
            result = a / b
            writer.write(json.dumps({'result': result}).encode())

        if operation == '5':
            result = a + b
            writer.write(json.dumps({'result': result}).encode())

async def main():
    server = await asyncio.start_server(handle_client, '127.0.0.1', 8888)
    address = server.sockets[0].getsockname()
    print(f'Serving on {address}')

    async with server:
        await server.serve_forever()

asyncio.run(main())