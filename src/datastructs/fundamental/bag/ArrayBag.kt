package datastructs.fundamental.bag

import java.util.ArrayList
import util.plus
import util.NonNullArrayIterator

/** A Bag with a backing array */
public class ArrayBag<T> : Bag<T> {

    private val DEFAULT_INIT_CAPACITY = 8
    private val EXPAND_MULTIPLE = 1.5f

    private var items = Array<Any?>(DEFAULT_INIT_CAPACITY, { null }) as Array<T?>

    override fun iterator(): Iterator<T> {
        return NonNullArrayIterator<T>(items)
    }

    private inner class BagIterator<T> : Iterator<T> {
        var head = 0
        val lastNull = items.lastIndexOf(null)
        override fun next(): T {
            return items[head++] as T;
        }
        override fun hasNext(): Boolean {
            return items[head] != null
        }
    }

    override fun add(item: T) {
        for (i in items.indices) {
            if (items[i] == null) {
                items[i] = item
                return
            }
        }
        // array out of space, expand it
        items = items.copyOf((items.size * EXPAND_MULTIPLE).toInt()) as Array<T?>
        add(item)
    }

    override fun size(): Int {
        var result = items.indexOf(null)
        if (result == -1) {
            result = capacity()
        }
        return result
    }

    fun capacity(): Int {
        return items.size
    }

    val capacity: Int
        get() = capacity()

    fun toList() : List<T> {
        val arrayList = ArrayList<T>()
        for (item in items) {
            if (item != null) arrayList.add(item)
        }
        return arrayList
    }

    override fun details() {
        var c = 0
        val sb = StringBuilder()
        sb + "ArrayBag, size: ${size()}, capacity: ${capacity()}\n"
        items.forEach { sb + "\t[$c]: $it\n";c++ }
        print(sb.toString())
    }
}