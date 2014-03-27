package test

import algorithms.fundamental.stack.Stack
import algorithms.fundamental.stack.LinkedStack

fun createStackTests() {
    val basicStackTest = {(stack: Stack<Int>) ->
        assert(stack.isEmpty())
        assert(stack.size() == 0)
        stack.push(1)
        assert(!stack.isEmpty())
        assert(stack.size() == 1)
        assert(stack.pop() == 1)
        assert(stack.isEmpty())

        stack.push(2)
        stack.clear()
        assert(stack.isEmpty())

        stack.clear()
        for (n in 1..10) {
            stack.push(n)
        }
        assert(stack.size() == 10)
        for (n in 10..1) {
            assert(stack.pop() == n)
        }
    }

    Test("LinkedStack", { () ->
        val stack = LinkedStack<Int>()
        basicStackTest(stack)
    })
}
