import asyncio
import json

obj = {
    "message": "sign_in",
    "x": 2,
    "y": 5
}

async def send_request():
    reader, writer = await asyncio.open_connection("localhost", 1234)
    email = input("Email: ")
    password = input("Password: ")
    writer.write(json.dumps({
        "message": "sign_in",
        "email": email,
        "password": password
    }).encode("utf-8"))
    writer.drain()
    
    try:
        while True:
            data = await reader.read(100)
            if not data:
                break
            message = json.loads(data.decode("utf-8"))
            print("Message:", message["message"])
    except asyncio.CancelledError:
        pass
    finally:
        writer.close()
        await writer.wait_closed()

asyncio.run(send_request())