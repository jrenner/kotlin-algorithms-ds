package datastructs.fundamental.stack

import datastructs.fundamental.list.LinkedList

/** FILO Stack backed by linked list */
public class LinkedStack<T> : Stack<T> {
    val items = LinkedList<T>()

    override fun push(item: T) {
        items.add(item)
    }

    override fun pop(): T {
        return items.removeLast()
    }

    override fun peek(): T {
        return items.last()
    }

    override fun size(): Int {
        return items.size
    }

    override fun iterator(): Iterator<T> {
        return items.iterator()
    }

    override fun clear() {
        items.clear()
    }
}