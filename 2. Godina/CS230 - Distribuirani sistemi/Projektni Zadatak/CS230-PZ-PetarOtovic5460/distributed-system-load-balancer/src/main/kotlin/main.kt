import java.io.BufferedReader
import java.io.PrintWriter
import java.net.ServerSocket

public fun main(args: Array<String>) {
        val clientPort = 12344
        val serverPort = 12347

        val servers = mutableListOf<Server>()
        val serverLock = Any()

        Thread {
            try {
                val serverSocket = ServerSocket(serverPort)
                println("\u001B[36mServer serving started on port: $serverPort")

                while (true) {
                    try {
                        val serverSocket = serverSocket.accept()
                        println("\u001B[36mServer connected: ${serverSocket.inetAddress.hostAddress}")

                        Thread {
                            handleServer(serverSocket, servers, serverLock)
                        }.start()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()

        Thread {
            try {
                val clientSocket = ServerSocket(clientPort)
                println("\u001B[32mClient serving started on port $clientPort")

                while (true) {
                    val clientSocket = clientSocket.accept()
                    println("\u001B[32mClient connected: ${clientSocket.inetAddress.hostAddress}")

                    Thread {
                        handleClient(clientSocket, servers, serverLock)
                    }.start()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
}

fun handleClient(clientSocket: java.net.Socket, servers: MutableList<Server>, serverLock: Any) {
    val input = BufferedReader(clientSocket.getInputStream().bufferedReader())
    val output = PrintWriter(clientSocket.getOutputStream().bufferedWriter(), true)

    try {
        var message = input.readLine()
        while (message != null) {
            println("\u001B[32mReceived from client: $message")

            if (message == "exit") {
                break
            }

            when (message) {
                "rq//request_connection" -> {
                    if (servers.isEmpty()) {
                        output.println("rs//request_connection_error:no_servers")
                        break
                    }

                    var min = servers[0].clients
                    var index = 0

                    synchronized(serverLock) {
                        for (server in servers) {
                            if (server.clients < min) {
                                min = server.clients
                                index = servers.indexOf(server)
                            }
                        }
                    }

                    output.println("rs//request_connection_success:${servers[index].ip}:${servers[index].openSockets[0]}:${servers[index].openSockets[1]}:${servers[index].openSockets[2]}")
                    break
                }

                "exit" -> {
                    break
                }

                else -> {
                    output.println("rs//unknown_command:$message")
                    message = input.readLine()
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        clientSocket.close()
        println("\u001B[32mClient disconnected: ${clientSocket.inetAddress.hostAddress}")
    }
}

fun handleServer(serverSocket: java.net.Socket, servers: MutableList<Server>, serverLock: Any) {
    val input = BufferedReader(serverSocket.getInputStream().bufferedReader())
    val output = PrintWriter(serverSocket.getOutputStream().bufferedWriter(), true)

    try {
        var message = input.readLine()
        while (message != null) {
            println("\u001B[36mReceived from server: $message")

            if (message == "exit") {
                break
            }

            if (message.startsWith("cf//socket")) {
                val parts = message.split(":")
                val sockets = intArrayOf().toMutableList()
                for (i in 1 until parts.size) {
                    sockets.add(parts[i].toInt())
                }
                val server = Server(serverSocket.inetAddress.hostAddress, sockets, serverSocket)

                synchronized(serverLock) {
                    servers.add(server)
                }

                output.println("rs//connected:success")

                if (servers.size > 1) {

                    for (s in servers) {
                        if (s != servers.last()) {
                            println("\u001B[36mSending new server to ${s.ip}")
                            s.sendMessage("cf//new_server:${server.ip}:${server.openSockets[0]}:${server.openSockets[1]}:${server.openSockets[2]}")
                        }
                    }
                }
            }

            message = input.readLine()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        synchronized(serverLock) {
            servers.removeIf { it.socket == serverSocket }
        }
        serverSocket.close()
        println("\u001B[36mServer disconnected: ${serverSocket.inetAddress.hostAddress}")
    }
}