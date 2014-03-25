package test

import algorithms.fundamental.list.LinkedList

fun createLinkedListTests() {
    Test("(Single) LinkedList", {() ->
        val list = LinkedList<Int>()
        basicLinkedListText(list)
    })
}

val basicLinkedListText = {(list: LinkedList<Int>) ->
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

    //list.details()

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
}