

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

    val testObjAbs = object : Test() {
        override fun absFunc(hit: Int) {
            println(">>>>> $hit")
        }
    }

    testObjAbs.absFunc(3)
    testObjAbs.getData()
}

fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
    return lambda(4.329)
}

interface Foo {
    fun receive(myStr: String)
}

abstract class Test {
    abstract fun absFunc(hit: Int)
    fun getData() {
        println("Test Get")
    }
}