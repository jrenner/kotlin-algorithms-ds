package datastructs.fundamental.stack

/** FILO Stack */
public trait Stack<T> : Iterable<T> {

    fun push(item: T)

    fun pop(): T

    fun peek(): T

    fun isEmpty(): Boolean {
        return size() == 0
    }

    fun size(): Int

    fun clear()
}
