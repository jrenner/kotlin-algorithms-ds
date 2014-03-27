package test

import datastructs.tree.BinarySearchTree
import java.util.ArrayList
import java.util.Random

fun createBinarySearchTreeTests() {
    Test("BinarySearchTree", { () ->
        val tree = BinarySearchTree<Int>()
        assert(tree.isEmpty())
        assert(tree.size() == 0)
        val testVals = intArray(10,5,18,12,19,34,2,7,3,4,6,68)
        for (num in testVals) tree add num
        tree.details()
        assert(tree.size() == testVals.size)
        for (num in testVals) {
            assert(tree.contains(num))
        }

        tree.clear()
        val randomNums = ArrayList<Int>()
        var c = 0
        val rand = Random()
        while (c < 1000) {
            c++
            val num = rand.nextInt(10000)
            randomNums.add(num)
        }
        for (num in randomNums) tree add num
        tree.details()
    })
}