package test

import java.util.ArrayList
import algorithms.fundamental.bag.ArrayBag
import algorithms.fundamental.bag.Bag

val tests = ArrayList<Test>()

public class Test(val name: String, testFunc: () -> Unit) {
    val runTest = testFunc
    {
        tests.add(this)
    }
}

fun main(args: Array<String>) {

    createBagTests()
    createQueueTests()

    for (test in tests) {
        println("Running test: ${test.name}")
        test.runTest()
    }
}


