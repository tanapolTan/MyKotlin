
fun main() {
    val magnitude100String = { input : Int, param2 : String ->
        val magnitude = input * 100
        magnitude.toString()
        println(param2)
    }

    println(magnitude100String(2, "cc"))
}