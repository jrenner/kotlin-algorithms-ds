package algorithms.fundamental.queue

import algorithms.fundamental.list.LinkedList

/** FIFO Queue with a backing linked list */
public class LinkedQueue<T> : Queue<T> {
    val items = LinkedList<T>()

    override fun iterator(): Iterator<T> {
        return items.iterator()
    }

    override fun push(item: T) {
        items.add(item)
    }

    override fun pop(): T {
        return items.removeFirst()
    }

    override fun clear() {
        items.clear()
    }

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }
    override fun size(): Int {
        return items.size
    }
    override fun details() {
        println("LinkedQueue - size: ${size()}")
        var c = 0
        for (item in this) {
            println("\t[${c++}]: $item")
        }
    }
    override fun toList(): List<T> {
        return items.toList()
    }
}
