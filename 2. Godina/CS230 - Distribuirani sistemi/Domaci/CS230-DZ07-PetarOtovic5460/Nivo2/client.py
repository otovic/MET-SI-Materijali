import asyncio
import json

print("RPC client menu:")
print("1 - Add integers")
print("2 - Subtract integers")
print("3 - Multiply floats")
print("4 - Divide floats")
print("5 - Concatenate strings\n")

async def rpc_call(params):
    reader, writer = await asyncio.open_connection('127.0.0.1', 8888)
    writer.write(json.dumps({'operation': params["operation"], 'a': params["a"], 'b': params["b"]}).encode())
    await writer.drain()
    data = await reader.read(1024)
    response = json.loads(data.decode())["result"]
    writer.close()
    print(f"Rezult: {response}")

async def main():
    operation = input("Enter your choice (1-5): ")

    if operation not in ['1', '2', '3', '4', '5']:
        print("Invalid choice. Egziting.")
        exit()

    if operation in ['1', '2']:
        a = int(input("Enter first integer: "))
        b = int(input("Enter second integer: "))
        await rpc_call({'operation': operation, 'a': a, 'b': b})

    if operation in ['3', '4']:
        a = float(input("Enter first float: "))
        b = float(input("Enter second float: "))
        await rpc_call({'operation': operation, 'a': a, 'b': b})

    if operation == '5':
        a = input("Enter first string: ")
        b = input("Enter second string: ")
        await rpc_call({'operation': operation, 'a': a, 'b': b})

asyncio.run(main())
