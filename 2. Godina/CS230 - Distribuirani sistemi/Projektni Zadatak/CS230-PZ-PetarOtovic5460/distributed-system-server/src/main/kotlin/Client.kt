import java.io.PrintWriter
import java.net.Socket

class Client(val username: String, val socket: Socket) {
    fun sendMessage(message: String) {
        val output = PrintWriter(socket.getOutputStream(), true)
        output.println(message)
    }
}