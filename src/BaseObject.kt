import java.lang.reflect.Method

open class BaseObject {
    var indent = 1
    override fun toString(): String {
        val result = StringBuilder()
        val methods: Array<Method> = this.javaClass.declaredMethods
        result.append(this.javaClass.name)
        result.append(" : { \r\n")
        for (met in methods) {
            if (met.name.startsWith("get")) {
                if (met.invoke(this) != null) {
                    result.append("  ".repeat(indent))
                    if (met.invoke(this) !is BaseObject) {
                        result.append(met.name.substring(3))
                        result.append(" : ")
                        result.append(met.invoke(this).toString())
                    } else {
                        (met.invoke(this) as BaseObject).indent = this.indent + 1
                        result.append(met.invoke(this).toString())
                    }
                    result.append(", \r\n")
                }
            }
        }
        result.append("  ".repeat(indent - 1))
        result.append("}")
        return result.toString()
    }
}