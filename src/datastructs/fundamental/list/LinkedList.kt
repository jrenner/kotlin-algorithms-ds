package datastructs.fundamental.list

import java.util.HashSet

public class LinkedList<T> : Iterable<T> {
    var first: Node<T>? = null
    var last: Node<T>? = null
    var size = 0

    override fun iterator(): Iterator<T> {
        return LinkedListIterator<T>(first)
    }

    private inner class LinkedListIterator<T>(startHead: Node<T>?) : Iterator<T> {
        var head: Node<T>? = startHead
        override fun next(): T {
            val result = head!!.cargo
            head = head!!.next
            return result
        }

        override fun hasNext(): Boolean {
            return head != null
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun add(item: T) {
        val node = Node<T>(item)
        // check for empty state
        if (first == null) {
            first = node
        }
        // last should not be null if first is confirmed not null
        if (last != null) last!!.next = node
        last = node
        size++
    }

    /** Returns true if the item was removed */
    fun remove(item: T): Boolean {
        if (first == null) return false
        var prev: Node<T>? = null
        var head = first
        while (head != null) {
            if (head!!.cargo == item) {
                // found item
                if (prev == null) {
                    first = head!!.next
                } else {
                    prev!!.next = head!!.next
                }
                if (head == last) {
                    last = prev
                }
                size--
                return true
            }
            prev = head
            head = head!!.next
        }
        return false
    }

    fun removeFirst(): T {
        val result = first!!.cargo
        remove(first!!.cargo)
        return result
    }

    fun removeLast(): T {
        val result = last!!.cargo
        remove(last!!.cargo)
        return result
    }

    fun clear() {
        var head = first
        first = null
        last = null
        while (head != null) {
            val nextNode = head!!.next
            head!!.next = null
            head = nextNode
        }
        size = 0
    }

    fun details() {
        println("LinkedList, size: $size, first-cargo: ${first?.cargo}, last-cargo: ${last?.cargo}")
        var i = 0
        for (cargo in this) {
            println("\t[${i++}]: $cargo")
        }
    }
}

private class Node<T>(val cargo: T) {
    var next: Node<T>? = null
}