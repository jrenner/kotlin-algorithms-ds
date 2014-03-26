package test

import algorithms.fundamental.queue.Queue
import algorithms.fundamental.queue.ArrayQueue
import java.util.ArrayList
import algorithms.fundamental.queue.LinkedQueue

fun createQueueTests() {
    val basicQueueTest = {(q : Queue<Int>) ->

        // basics
        assert(q.isEmpty())
        assert(q.size() == 0)
        q.put(1)
        assert(!q.isEmpty())
        assert(q.size() == 1)
        assert(q.get() == 1)
        assert(q.isEmpty())
        assert(q.size() == 0)
        q.put(1)
        assert(q.size() == 1)
        assert(!q.isEmpty())

        // clearing
        q.clear()
        assert(q.isEmpty())
        assert(q.size() == 0)

        // FIFO
        q.put(1)
        q.put(3)
        q.put(5)
        assert(q.get() == 1)
        q.put(2)
        q.put(4)
        assert(q.get() == 3)
        q.put(10)
        q.put(20)
        assert(q.get() == 5)
        assert(q.get() == 2)
        assert(q.get() == 4)
        assert(q.get() == 10)
        assert(q.get() == 20)
        assert(q.isEmpty())

        // iteration
        q.clear()
        val max = 10
        for (n in 1..max) {
            q.put(n)
        }

        var count = 0
        while (!q.isEmpty()) {
            q.get()
            count++
            assert(count <= max, "iteration failed to stay <= max: count: $count")
        }
        assert(count == max, "iteration failed to match max, count: $count, max $max")
    }

    BenchmarkTest("ArrayQueue", { () ->
        val q = ArrayQueue<Int>()
        basicQueueTest(q)
    }, BenchmarkTest.defaultLoopCount)

    BenchmarkTest("LinkedQueue", { () ->
        val q = LinkedQueue<Int>()
        basicQueueTest(q)
    }, BenchmarkTest.defaultLoopCount)
}

