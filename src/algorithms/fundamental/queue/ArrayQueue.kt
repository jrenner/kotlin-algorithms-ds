package algorithms.fundamental.queue

import util.NonNullArrayIterator
import java.util.ArrayList

/** A Queue with a backing array */
public class ArrayQueue<T> : Queue<T> {
    val DEFAULT_INIT_CAPACITY = 8
    val RESIZE_MULTIPLE = 2f
    var items = Array<Any?>(DEFAULT_INIT_CAPACITY, { null } ) as Array<T?>
    var first = 0
    var last = 0
    var itemCount = 0

    override fun iterator(): Iterator<T> {
        return NonNullArrayIterator(items)
    }

    override fun put(item: T) {
        if (items[last] != null) last++
        if (last >= items.size) {
            resize((itemCount * RESIZE_MULTIPLE).toInt())
        }
        if (items[last] != null) last++
        items[last] = item
        itemCount++
    }

    val SHRINK_THRESHOLD = 0.25f

    override fun get(): T {
        val item = items[first]
        items[first] = null
        first++
        itemCount--
        val threshold = (items.size * SHRINK_THRESHOLD).toInt()
        if (itemCount < threshold && itemCount >= DEFAULT_INIT_CAPACITY) {
            resize((itemCount * RESIZE_MULTIPLE).toInt())
        }
        return item!!
    }

    override fun clear() {
        first = 0
        last = 0
        for (i in items.indices) {
            items[i] = null
        }
        itemCount = 0
    }

    override fun isEmpty(): Boolean {
        return itemCount == 0
    }

    override fun size(): Int {
        return itemCount
    }

    fun capacity(): Int {
        return items.size
    }

    private fun resize(newSize: Int) {
        assert(newSize > 0, "newSize must be greater than zero: $newSize")
        val newArray = Array<Any?>(newSize, { null } ) as Array<T?>
        var i = 0
        for (item in items) {
            if (item != null) newArray[i++] = item
        }
        items = newArray
        for (i in items.indices) {
            if (items[i] != null) {
                first = i
                break
            }
        }
        for (i in items.lastIndex downTo 0) {
            if (items[i] != null) {
                last = i
                break
            }
        }
    }

    override fun details() {
        println("ArrayQueue, size: ${size()}, capacity: ${capacity()}, first: $first, last: $last")
        var i = 0
        for (item in items) {
            println("\t[${i++}]: $item")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is Queue<*>) {
            val myList = this.toList()
            val otherList = other.toList()
            if (myList.size != otherList.size) return false
            for (i in myList.indices) {
                if (myList[i] != otherList[i]) {
                    return false
                }
            }
            return true
        }
        return false
    }

    override fun toList(): List<out T> {
        val list = ArrayList<T>()
        for (item in items) {
            if (item != null) {
                list.add(item)
            }
        }
        return list.toList()
    }

}
