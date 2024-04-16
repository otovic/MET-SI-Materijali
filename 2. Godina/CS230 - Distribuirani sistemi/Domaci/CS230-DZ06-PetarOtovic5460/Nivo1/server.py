import asyncio

async def handle_client(reader, writer, index):
    data = await reader.read(100)
    message = data.decode()
    addr = writer.get_extra_info('peername')
    print(f"Received {message} from {addr} on {index}")

    print("Send: %r" % message)
    writer.write(f"Hello from endpoint {index}".encode())
    await writer.drain()

    print("Closing the connection")
    writer.close()

async def start_server(host, port, index):
    server = await asyncio.start_server(
        lambda reader, writer: handle_client(reader, writer, index), host, port)
    async with server:
        await server.serve_forever()

async def main():
    ports = [8000, 8001, 8002]
    servers = []
    index = 0

    for port in ports:
        print(f"Starting server on port {port}")
        servers.append(start_server('127.0.0.1', port, index))
        index += 1
    
    await asyncio.gather(*servers)

asyncio.run(main())