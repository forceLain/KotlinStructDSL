class Struct {
    private val children = hashMapOf<String, Any>()

    operator fun get(s: String): Any? {
        return children[s]
    }

    operator fun (() -> Pair<String, Any>).unaryPlus() {
        val pair = this.invoke()
        children.put(pair.first, pair.second)
    }

    infix fun Struct.s(that: Pair<String, Any>): Unit {
        this.children.put(that.first, that.second)
    }

    operator fun set(first: String, value: Any) {
        this.children.put(first, value)
    }

}

fun struct(vararg data: Pair<String, Any>, init: (Struct.() -> Unit)? = null): Struct {
    val struct = Struct()
    for (pair in data) {
        struct[pair.first] = pair.second
    }
    if (init != null) {
        struct.init()
    }
    return struct
}