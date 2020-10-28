import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
//    val myQ: MyQueue = InstanceUtils.getSingelton(MyQueue::class.java)
//    myQ.playQueue.add("Test")
//
//    val myQ2: MyQueue = InstanceUtils.getSingelton(MyQueue::class.java)
//    println(myQ2.playQueue.poll())
//
//    val myDog: MyDog = InstantUtilsJava.newInstance(MyDog::class.java, "ABC", 20, MyCat("DEF", 50))
//    println(myDog.toString())

//    val newDog: NewDog2 = InstanceUtils.newInstance(NewDog2::class.java, "AAA", 13)
//    println(newDog)
}

object InstanceUtils {
    private val maps: HashMap<String, Any?> = HashMap()

    @Synchronized
    fun <T> getSingelton(clazz: Class<T>, vararg args: Any) : T {
        val obj: Any? = maps[clazz.name]
        return if (obj != null) {
            obj as T
        } else {
            val result: T = this.newInstance(clazz, *args)
            maps[clazz.name] = result as Any
            result
        }
    }

    fun <T> newInstance(clazz: Class<T>, vararg args: Any) : T {
        return when (args.size) {
            0 -> clazz.getDeclaredConstructor().newInstance()
            else -> {
                val arr = Array(args.size) { args[0]::class.java }
                for ((index, arg) in args.withIndex()) {
                    arr[index] = arg::class.java
                }
                clazz.getDeclaredConstructor(*arr).newInstance(*args)
            }
        }
    }
}

class MyQueue {
    val playQueue : Queue<String> = LinkedList()
}

class MyDog(
    var name: String? = null,
    var height: Int? = null,
    var myCat: MyCat? = null
) : BaseObject()

class MyCat(
    var name: String? = null,
    var height: Int? = null
) : BaseObject()

class NewDog() : BaseObject() {
    constructor(name: String, weigth: Int) : this() {
        this.name = name
        this.weigth = weigth
    }

    var name: String? = null
    var weigth: Int? = null
}