import java.net.InetSocketAddress
import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args : Array<String>) {
    val handler = HttpHandler { p0 ->
        val hx = p0!!
        val reader: BufferedReader = BufferedReader(InputStreamReader(p0.requestBody))
        reader.forEachLine {
            println(it)
        }

        val headers = hx.getResponseHeaders()!!
        headers.add("Content-Type", "text/plain")
        hx.sendResponseHeaders(200, 0)

        val out = hx.getResponseBody()!!.writer()
        out.write("Hello, World!\n")
        out.close()

        println("Handled!")
    }

    val server = HttpServer.create(InetSocketAddress(8000), 0)!!

    server.createContext("/", handler)

    server.start()
    println("Serving HTTP on port 8000 ...")
}