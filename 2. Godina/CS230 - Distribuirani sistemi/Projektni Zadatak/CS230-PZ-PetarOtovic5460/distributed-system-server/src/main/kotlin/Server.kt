import java.io.BufferedReader
import java.io.PrintWriter
import java.net.Socket

class Server(val ip: String, val socket: MutableList<Int>) {
    fun sendMessage(message: String) {
        val client = Socket(ip, socket[0])
        val clientOutput = PrintWriter(client.getOutputStream(), true)

        clientOutput.println(message)

        client.close()
    }

    fun sendMessageWithResponse(message: String): String {
        val client = Socket(ip, socket[0])
        val clientOutput = PrintWriter(client.getOutputStream(), true)
        val clientInput = BufferedReader(client.getInputStream().reader())

        clientOutput.println(message)

        val response = clientInput.readLine()

        client.close()

        return response
    }
}