package algorithms.fundamental.queue

public trait Queue<T> : Iterable<T> {

    override fun iterator(): Iterator<T>

    fun put(item: T)

    fun get(): T

    fun clear()

    fun isEmpty(): Boolean

    fun size(): Int

    fun details()

    fun toList() : List<out T>
}
