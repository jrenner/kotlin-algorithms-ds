package datastructs.fundamental.bag

import util.plus
import datastructs.fundamental.list.LinkedList

/** A Bag with a backing linked list */
public class LinkedBag<T> : Bag<T> {
    var items = LinkedList<T>()

    override fun add(item: T) {
        items.add(item)
    }

    override fun size(): Int {
        return items.size
    }

    override fun iterator(): Iterator<T> {
        return items.iterator()
    }

    override fun details() {
        var c = 0
        val sb = StringBuilder()
        sb + "LinkedBag, size: ${size()}\n"
        items.forEach { sb + "\t[$c]: $it\n";c++ }
        print(sb.toString())
    }

}
