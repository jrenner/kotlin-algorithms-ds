package test

import datastructs.fundamental.bag.ArrayBag
import datastructs.fundamental.bag.LinkedBag
import datastructs.fundamental.bag.Bag

fun createBagTests() {
    val basicBagTest = { (bag: Bag<Int>) ->
        val max = 20
        for (n in 1..max) {
            bag.add(n)
        }
        //bag.details()
        assert(bag.size == max)
        var count = 0
        for (item in bag) {
            assert (item != null)
            count++
        }
        assert (count == bag.size)
        //bag.details()
    }

    BenchmarkTest("ArrayBag", {() ->
        val bag = ArrayBag<Int>()
        basicBagTest(bag)
    }, BenchmarkTest.defaultLoopCount)

    BenchmarkTest("LinkedBag", {() ->
        val bag = LinkedBag<Int>()
        basicBagTest(bag)
    }, BenchmarkTest.defaultLoopCount)

    Test("ArrayBagSize", {() ->
        val bag = ArrayBag<Int>()
        while (bag.size != bag.capacity) {
            bag.add(1)
        }
        //bag.details()
        assert(bag.size == bag.capacity)
        bag.add(2)
        while (bag.size != bag.capacity) {
            bag.add(2)
        }
        //bag.details()
        assert(bag.size == bag.capacity)
    })
}
