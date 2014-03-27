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
        q.push(1)
        assert(!q.isEmpty())
        assert(q.size() == 1)
        assert(q.pop() == 1)
        assert(q.isEmpty())
        assert(q.size() == 0)
        q.push(1)
        assert(q.size() == 1)
        assert(!q.isEmpty())

        // clearing
        q.clear()
        assert(q.isEmpty())
        assert(q.size() == 0)

        // FIFO
        q.push(1)
        q.push(3)
        q.push(5)
        assert(q.pop() == 1)
        q.push(2)
        q.push(4)
        assert(q.pop() == 3)
        q.push(10)
        q.push(20)
        assert(q.pop() == 5)
        assert(q.pop() == 2)
        assert(q.pop() == 4)
        assert(q.pop() == 10)
        assert(q.pop() == 20)
        assert(q.isEmpty())

        // iteration
        q.clear()
        val max = 10
        for (n in 1..max) {
            q.push(n)
        }

        var count = 0
        while (!q.isEmpty()) {
            q.pop()
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

