package test

import java.util.ArrayList
import algorithms.fundamental.bag.ArrayBag
import algorithms.fundamental.bag.Bag

val tests = ArrayList<Test>()

public open class Test(val name: String, testFunc: () -> Unit) {
    open val runTest = testFunc
    {
        tests.add(this)
    }
}

fun main(args: Array<String>) {

    createBagTests()
    createQueueTests()
    createLinkedListTests()

    for (test in tests) {
        println("Running test: ${test.name}")
        test.runTest()
    }
}

public class BenchmarkTest(name: String, testFunc: () -> Unit, val loopCount: Int) : Test(name, testFunc) {
    class object {
        val defaultLoopCount = 1000
    }

    override val runTest = {
        val start = System.currentTimeMillis()
        for (n in 1..loopCount) {
            testFunc()
        }
        val timeTaken = System.currentTimeMillis() - start
        println("\ttime: ${timeTaken} ms")
    }
}




