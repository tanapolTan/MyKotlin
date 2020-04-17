
fun main(args : Array<String>) {
    val t = object : Timer() {
        override var sec: Int = 10
        override fun onFinish() {

        }

        override fun onEverySec() {

        }
    }

    t.start()
}

abstract class Timer {
    abstract var sec: Int
    abstract fun onFinish()
    abstract fun onEverySec()

    private var remainSec: Int = 0

    fun start() {
        this.onFinish()
    }
}

