import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val myQ: MyQueue = InstanceUtils.getSingelton(MyQueue::class.java)
    myQ.playQueue.add("Test")

    val myQ2: MyQueue = InstanceUtils.getSingelton(MyQueue::class.java)
    println(myQ2.playQueue.poll())

    val myDog: MyDog = InstanceUtils.newInstance(MyDog::class.java, "ABC", 20, MyCat("DEF", 50))
    println(myDog.toString())

    InstanceUtils.newInstance(XXX::class.java)
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
        val arr = Array(args.size) { args[0].javaClass }
        for ((index, arg) in args.withIndex()) {
            arr[index] = arg.javaClass
        }
        return clazz.getDeclaredConstructor(*arr).newInstance(*args)
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

class XXX()