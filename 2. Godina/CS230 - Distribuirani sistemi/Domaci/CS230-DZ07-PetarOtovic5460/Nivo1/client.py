import asyncio
import json
 
async def rpc_call(params):
    reader, writer = await asyncio.open_connection('127.0.0.1', 8888)
 
    request = json.dumps({'message': params}).encode()
    writer.write(request)
    await writer.drain()
 
    data = await reader.read(1024)
    response = json.loads(data.decode())
    
    writer.close()
    await writer.wait_closed()
 
    return response
 
async def main():
    response = await rpc_call('Hello, Middleware!')
    print(response)
 
asyncio.run(main())