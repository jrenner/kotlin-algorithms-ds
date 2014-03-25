package algorithms.fundamental.queue

public trait Queue<T> : Iterable<T> {

    override fun iterator(): Iterator<T>

    fun put(item: T)

    fun get(): T

    fun isEmpty(): Boolean

    fun size(): Int
}
