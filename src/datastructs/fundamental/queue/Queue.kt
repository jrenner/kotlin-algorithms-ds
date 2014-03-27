package datastructs.fundamental.queue

/** FIFO Queue */
public trait Queue<T> : Iterable<T> {

    override fun iterator(): Iterator<T>

    fun push(item: T)

    fun pop(): T

    fun clear()

    fun isEmpty(): Boolean

    fun size(): Int

    fun details()

    fun toList() : List<out T>
}
