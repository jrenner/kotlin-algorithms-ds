package algorithms.fundamental.list

public class DoubleLinkedList<T> : Iterable<T> {
    var first: DoubleNode<T>? = null
    var last: DoubleNode<T>? = null
    var size = 0

    override fun iterator(): Iterator<T> {
        return DoubleLinkedListIterator<T>(first)
    }

    fun reverseIterator(): Iterator<T> {
        return DoubleLinkedListReverseIterator<T>(last)
    }

    private inner class DoubleLinkedListIterator<T>(startHead: DoubleNode<T>?) : Iterator<T> {
        var head: DoubleNode<T>? = startHead
        override fun next(): T {
            val result = head!!.cargo
            head = head!!.next
            return result
        }

        override fun hasNext(): Boolean {
            return head != null
        }
    }

    private inner class DoubleLinkedListReverseIterator<T>(startHead: DoubleNode<T>?) : Iterator<T> {
        var head: DoubleNode<T>? = startHead
        override fun next(): T {
            val result = head!!.cargo
            head = head!!.prev
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
        val node = DoubleNode<T>(item)
        if (first == null) {
            first = node
        }
        if (last != null) {
            last!!.next = node
            node.prev = last
        }
        last = node
        size++
    }

    /** Returns true if the item was removed */
    fun remove(item: T): Boolean {
        if (first == null) return false
        var head = first
        while (head != null) {
            if (head!!.cargo == item) {
                // found item
                if (head == first) {
                    first = head!!.next
                } else {
                    head!!.prev!!.next = head!!.next
                }
                if (head == last) {
                    last = head!!.prev
                } else {
                    head!!.next!!.prev = head!!.prev
                }
                size--
                return true
            }
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
            head!!.prev = null
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


private class DoubleNode<T>(val cargo: T) {
    var prev: DoubleNode<T>? = null
    var next: DoubleNode<T>? = null
}
