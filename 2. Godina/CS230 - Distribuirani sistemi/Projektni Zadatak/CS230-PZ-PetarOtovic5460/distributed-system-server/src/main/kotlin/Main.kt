import java.io.BufferedReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket
import kotlin.coroutines.*

fun main(args: Array<String>) {
    val sockets = intArrayOf(1337, 1338, 1339, 1340, 1341, 1342).toMutableList()
    lateinit var balancer: Socket
    val balancerIP = "192.168.0.107"
    val balancerPort = 12347
    val serverLock = Any()
    var servers = mutableListOf<Server>()
    var clients = mutableListOf<Client>()
    val clientLock = Any()
    var chosen = intArrayOf().toMutableList()

    try {
        for (i in 0..2) {
            val random = (0 until sockets.size).random()
            chosen.add(sockets[random])
            sockets.removeAt(random)

            Thread {
                try {
                    val server = ServerSocket(chosen[i])
                    println("Server started on port ${chosen[i]}")

                    while (true) {
                        val client = server.accept()
                        println("Client connected: ${client.inetAddress.hostAddress}")

                        Thread {
                            handleClient(client, clients, clientLock, servers, serverLock)
                        }.start()
                    }
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }.start()
        }

        if (chosen.size != 3) {
            println("Failed to start servers")
            return
        }

        val balancer = Socket(balancerIP, balancerPort)
        println("Connecting to balancer")

        val input = BufferedReader(balancer.getInputStream().reader())
        val output = PrintWriter(balancer.getOutputStream(), true)

        output.println("cf//socket:${chosen[0]}:${chosen[1]}:${chosen[2]}")

        var response = input.readLine()

        if (response.equals("rs//connected:success")) {
            println("Connected to balancer")
        } else {
            println("Failed to connect to balancer")
        }

        response = input.readLine()

        while (response != null) {
            if (response == "exit") {
                break
            }

            if (response.startsWith("cf//new_server")) {
                val splits = response.split(":")
                val server = Server(splits[1], intArrayOf(splits[2].toInt(), splits[3].toInt(), splits[4].toInt()).toMutableList())
                synchronized(serverLock) {
                    servers.add(server)
                }
            }
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        balancer.close()
        println("Closing server")
    }
}

fun handleClient(client: Socket, clients: MutableList<Client>, clientLock: Any, servers: MutableList<Server>, serverLock: Any) {
    try {
        val clientInput = BufferedReader(client.getInputStream().reader())
        val clientOutput = PrintWriter(client.getOutputStream(), true)

        var message = clientInput.readLine()

        println("Message before: $message")

        if (message.startsWith("cf//username")) {
            val splits = message.split(":")
            val username = splits[1]

            val client = Client(username, client)
            synchronized(clientLock) {
                clients.forEach {
                    println("Sending message to ${it.username}")
                    it.sendMessage("cf//user_joined:${username}:")
                }
                clients.add(client)
            }
            println("Registered client: $username")
        } else if (message.startsWith("scf//chat")) {
            val splits = message.split(":")
            val from = splits[1]
            val to = splits[2]
            val message = splits[3]

            synchronized(clientLock) {
                clients.forEach {
                    if (it.username == to) {
                        it.sendMessage("cf//chat_receive:$from:$message:")
                    }
                }
            }

            client.close()
        } else {
            throw Exception("Invalid message")
        }

        message = clientInput.readLine()

        while (message != null) {
            print("Message: $message")
            if (message == "exit") {
                break
            }

            if (message == "end") {
                throw Exception("Client disconnected")
                break
            }

            if (message.startsWith("cf//chat")) {
                val splits = message.split(":")
                val from = splits[1]
                val to = splits[2]
                val message = splits[3]

                var found = false

                synchronized(clientLock) {
                    clients.forEach {
                        if (it.username == to) {
                            it.sendMessage("cf//chat_receive:$from:$message:")
                            found = true
                        }
                    }
                }

                if (!found) {
                    synchronized(serverLock) {
                        servers.forEach {
                            it.sendMessage("scf//chat:$from:$to:$message:")
                        }
                    }
                }
            }

            if (message.startsWith("sm//send_message")) {
                val splits = message.split(":")
                val username = splits[1]
                val message = splits[2]

                var found = false
                synchronized(clientLock) {
                    clients.forEach {
                        if (it.username == username) {
                            it.sendMessage(message)
                            found = true
                        }
                    }
                }
                if (!found) {
                    synchronized(serverLock) {
                        servers.forEach {
                            it.sendMessage("s" + message)
                        }
                    }
                }
            }

            if (message.startsWith("ssm//send_message")) {
                val splits = message.split(":")
                val username = splits[1]
                val message = splits[2]

                synchronized(clientLock) {
                    clients.forEach {
                        if (it.username.equals(username)) {
                            it.sendMessage(message)
                        }
                    }
                }

                client.close()
            }

            if (message.startsWith("rq//available_people")) {
                var available = ""
                synchronized(clientLock) {
                    clients.forEach {
                        if (it.socket != client) {
                            available += it.username + ":"
                        }
                    }
                }
                println("Available people: $available")
                for (i in 0 until servers.size) {
                    val res = servers[i].sendMessageWithResponse("srq//available_people")
                    println("Available from another server: $res")
                    available += res
                }

                if (available.equals("")) {
                    available = "none:"
                }

                clientOutput.println("rs//available_people:" + available)
            }

            if (message.startsWith("srq//available_people")) {
                var available = ""
                synchronized(clientLock) {
                    clients.forEach {
                        available += it.username + ":"
                    }
                }
                clientOutput.println(available)
                client.close()
            }

            println("Waiting for message")
            message = clientInput.readLine()
        }
    } catch (e: Exception) {
        synchronized(clientLock) {
            val clientInfo = clients.find { it.socket == client }
            val username = clientInfo?.username ?: ""
            clients.removeIf { it.socket == client }
            clients.forEach { it.sendMessage("cf//user_left:$username:") }
        }
        client.close()
        println("Error: ${e.message}")
    } finally {
        client.close()
    }
}