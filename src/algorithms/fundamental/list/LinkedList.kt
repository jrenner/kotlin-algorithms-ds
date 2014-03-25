package algorithms.fundamental.list

import java.util.HashSet

public open class LinkedList<T> : Iterable<T> {
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
                size--
                return true
            } else {
                if (prev != null) {
                    prev!!.next = head!!.next
                }
                head = head!!.next
            }
        }
        return false
    }

    fun removeFirst(): T {
        val result = first!!.cargo
        remove(first!!.cargo)
        return result
    }

    open fun clear() {
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

    /** Are there any loops in the linked list */
    fun hasCycle(): Boolean {
        val seen = HashSet<T>()
        for (item in this) {
            if (seen contains item) {
                return true
            }
            seen add item
        }
        return false
    }

    /** Is the list one complete cycle (loop) */
    fun isCompleteCycle(): Boolean {
        val seen = HashSet<T>()
        val iter = this.iterator()
        while (iter.hasNext()) {
            val item = iter.next()
            if (seen contains item) {
                if (iter.hasNext()) {
                    return false
                } else {
                    return true
                }
            }
            seen add item
        }
        return false
    }

    open fun details() {
        println("LinkedList, size: $size, first-cargo: ${first?.cargo}, last-cargo: ${last?.cargo}")
        var i = 0
        for (cargo in this) {
            println("\t[${i++}]: $cargo")
        }
    }
}

private open class Node<T>(val cargo: T) {
    var next: Node<T>? = null
}

private class DoubleNode<T>(cargo: T) : Node<T>(cargo) {
    var prev: DoubleNode<T>? = null
}