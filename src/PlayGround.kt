

fun main() {
    val array: ArrayList<String> = ArrayList()
    array.add("1")
    array.add("2")
    array.add("3")

    array.forEach {
        println(it)
    }

    val test = invokeLambda {
        it == 4.3
    }

    println(test)

    val f = object : Foo {
        override fun receive(myStr: String) {

        }
    }
}

fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
    return lambda(4.329)
}

interface Foo {
    fun receive(myStr: String)
}