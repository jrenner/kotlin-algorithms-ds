package util

public class NonNullArrayIterator<T>(backingArray: Array<T?>) : Iterator<T> {
    var head = 0
    val items = backingArray
    override fun next(): T {
        return items[head++] as T
    }

    override fun hasNext(): Boolean {
        return items[head] != null
    }
}
