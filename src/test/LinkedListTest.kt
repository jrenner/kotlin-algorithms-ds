package test

import algorithms.fundamental.list.LinkedList
import algorithms.fundamental.list.DoubleLinkedList

fun createLinkedListTests() {
    Test("(Single) LinkedList", { () ->
        val list = LinkedList<Int>()
        singleTest(list)
    })

    Test("DoubleLinkedList", {() ->
        val list = DoubleLinkedList<Int>()
        doubleTest(list)
    })
}

val singleTest = {(list: LinkedList<Int>) ->
    assert(list.isEmpty())
    assert(list.size == 0)

    var c = 0
    for (item in list) {
        // do nothing, check iterator
    }
    assert(c == 0)

    list.add(1)
    assert(list.size == 1)
    list.add(2)
    assert(list.size == 2)
    list.add(3)
    assert(list.size == 3)

    // iteration
    c = 0
    for (item in list) c++
    assert(c == 3)

    assert(!list.isEmpty())
    assert(list.remove(1))
    assert(list.size == 2)
    assert(list.remove(9999) == false)
    assert(list.size == 2)
    assert(list.remove(2))
    assert(list.remove(3))

    // remove all
    for (item in list) {
        val removedOK = list.remove(item)
        assert(removedOK)
    }
    assert(list.isEmpty())
    assert(list.size == 0)

    for (n in 1..20) {
        list.add(n)
    }
    assert(list.size == 20)
    list.clear()
    for (n in 1..3) list add n
    for (n in 1..3) {
        assert(list.removeFirst() == n)
        assert(list.size == 3 - n)

    }

    // test last variable
    for (n in 1..3) list add n
    assert(list.remove(3))
    list.add(4)
    for (n in 10..15) list add n
    assert(list.remove(12))
    assert(!list.contains(12))
    assert(list.remove(14))
    assert(!list.contains(14))
    assert(list.remove(2))
    assert(!list.contains(2))
    assert(list.size == 6)
    val expectedItems = intArray(1, 4, 10, 11, 13, 15)
    for (item in expectedItems) {
        assert(item == list.removeFirst())
    }
}

val doubleTest = { (list: DoubleLinkedList<Int>) ->
    assert(list.isEmpty())
    assert(list.size == 0)

    var c = 0
    for (item in list) {
        // do nothing, check iterator
    }
    assert(c == 0)

    list.add(1)
    assert(list.size == 1)
    list.add(2)
    assert(list.size == 2)
    list.add(3)
    assert(list.size == 3)

    // iteration
    c = 0
    for (item in list) c++
    assert(c == 3)

    assert(!list.isEmpty())
    assert(list.remove(1))
    assert(list.size == 2)
    assert(list.remove(9999) == false)
    assert(list.size == 2)
    assert(list.remove(2))
    assert(list.remove(3))

    // remove all
    for (item in list) {
        val removedOK = list.remove(item)
        assert(removedOK)
    }
    assert(list.isEmpty())
    assert(list.size == 0)

    for (n in 1..20) {
        list.add(n)
    }
    assert(list.size == 20)
    list.clear()
    for (n in 1..3) list add n
    for (n in 1..3) {
        assert(list.removeFirst() == n)
        assert(list.size == 3 - n)
    }

    // test last variable
    for (n in 1..3) list add n
    assert(list.remove(3))
    list.add(4)
    for (n in 10..15) list add n
    assert(list.remove(12))
    assert(!list.contains(12))
    assert(list.remove(14))
    assert(!list.contains(14))
    assert(list.remove(2))
    assert(!list.contains(2))
    assert(list.size == 6)
    val expectedItems = intArray(1, 4, 10, 11, 13, 15)
    for (item in expectedItems) {
        assert(item == list.removeFirst())
    }

    // Double specific tests
    list.clear()
    for (n in 5..25 step 5) list add n
    assert(list.remove(10))

    c = 0
    for (item in list.reverseIterator()) {
        c++
        assert(item != 10)
    }
    assert(c == 4)

    list.add(43)
    list.add(72)
    list.add(101)
    list.add(139)
    list.add(180)
    list.remove(101)
    list.remove(15)

    val expectedReversedItems = intArray(180, 139, 72, 43, 25, 20, 5)
    var i = 0
    for (item in list.reverseIterator()) {
        assert(item == expectedReversedItems[i++])
    }

    list.clear()
    for (n in 1..5) list add n
    for (n in 5..1) assert(list.removeLast() == n)
}
