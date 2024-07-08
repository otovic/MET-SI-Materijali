import asyncio
import json

def handle_message(message, users):
    if message["message"] == "sign_in":
        for user in users:
            if user["email"] == message["email"] and user["password"] == message["password"]:
                return {
                    "message": "logged_in"
                }
        return {
            "message": "not_found"
        }

async def handle_request(reader, writer, users):
    data = await reader.read(100)
    message = json.loads(data.decode("utf-8"))
    print(f"Received message {message}")
    while message["message"] != "EXIT":
        response = handle_message(message, users)
        print(response)
        writer.write(json.dumps(response).encode("utf-8"))
        await writer.drain()
        data = await reader.read(100)
        message = json.loads(data.decode("utf-8"))
    
    writer.close()

async def start_server():
    users = []
    with open("vezba/data.txt", "r") as file:
        for line in file:
            data = line.strip().split("|")
            users.append({
                "email": data[0],
                "password": data[1]
            })
    server = await asyncio.start_server(lambda reader, writer: handle_request(reader, writer, users), "localhost", 1234)
    async with server:
        print("Server serving")
        await server.serve_forever()

asyncio.run(start_server())