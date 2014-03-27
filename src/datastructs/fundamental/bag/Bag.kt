package datastructs.fundamental.bag

import util.plus

public trait Bag<T> : Collection<T> {

    fun add(item: T)

    override fun size(): Int

    override fun isEmpty(): Boolean {
        return size() == 0
    }

    override fun contains(o: Any?): Boolean {
        for (item in this) {
            if (o == item) return true
        }
        return false
    }
    override fun iterator(): Iterator<T>

    override fun containsAll(c: Collection<Any?>): Boolean {
        for (item in c) {
            if (!contains(item)) return false
        }
        return true
    }

    fun details()
}
