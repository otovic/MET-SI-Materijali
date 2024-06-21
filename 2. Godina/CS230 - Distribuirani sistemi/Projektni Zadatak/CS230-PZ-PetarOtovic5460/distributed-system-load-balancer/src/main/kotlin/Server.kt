import java.io.PrintWriter
import java.net.Socket

class Server(val ip: String, val openSockets: MutableList<Int>, val socket: Socket) {
    var clients: Int = 0

    fun addClient() {
        clients++;
    }

    fun removeClient() {
        clients--;
    }

    fun sendMessage(message: String) {
        val output = PrintWriter(socket.getOutputStream().bufferedWriter(), true)
        output.println(message)
    }
}