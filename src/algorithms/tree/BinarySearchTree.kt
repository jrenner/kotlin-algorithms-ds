package algorithms.tree

import java.util.ArrayList
import java.util.HashMap

public class BinarySearchTree<T: Comparable<T>> : Iterable<T> {
    var root: Node<T>? = null

    fun isEmpty(): Boolean {
        return root == null
    }

    fun size(): Int {
        return toList().size
    }

    override fun iterator(): Iterator<T> {
        return toList().iterator()
    }

    fun toList(): List<out T> {
        val list = ArrayList<T>()

        fun addToList(node: Node<T>?) {
            if (node == null) return
            list.add(node.cargo)
            addToList(node.left)
            addToList(node.right)
        }

        addToList(root)
        return list
    }

    /** Returns true if the item was added, false if it was already in the tree */
    fun add(item: T): Boolean {
        var result = true
        if (root == null) {
            root = Node<T>(item)
        } else {
            result = add(item, root!!)
        }
        return result
    }

    /** Returns true if the item was added, false if it was already in the tree */
    fun add(item: T, node: Node<T>): Boolean {
        var result = true
        if (item < node.cargo) {
            if (node.left == null) {
                node.left = Node<T>(item)
            } else {
                result = add(item, node.left!!)
            }
        } else if (item > node.cargo) {
            if (node.right == null) {
                node.right = Node<T>(item)
            } else {
                result = add(item, node.right!!)
            }
        } else {
            // item is equal, it is already in the tree
            result = false
        }
        return result
    }

    fun contains(item: T): Boolean {
        if (root == null) return false
        var node: Node<T>? = root
        while (node != null) {
            val n = node!!
            if (item == n.cargo) return true
            if (item < n.cargo) {
                node = n.left
            } else {
                node = n.right
            }
        }
        return false
    }

    fun remove(item: T): Boolean {
       return false
    }

    fun clear() {
        root = null
    }

    fun details() {
        println("BinarySearchTree, size: ${size()}")
        val depthCount = HashMap<Int, Int>()
        fun incDepth(depth: Int) {
            val current = depthCount.getOrElse(depth, { 0 })
            depthCount.put(depth, current + 1)
        }
        val sb = StringBuilder()
        fun processNode(node: Node<T>?, depth: Int, side: String) {
            if (node != null) {
                sb.append("    " * depth)
                sb.append("$side:${node.cargo}\n")
                incDepth(depth)
                processNode(node.left, depth + 1, "L")
                processNode(node.right, depth + 1, "R")
            }
        }
        processNode(root, 0, "*")
        println(sb.toString())
        for (level in depthCount.keySet()) {
            println("depth $level: ${depthCount.get(level)}")
        }
    }
}

private class Node<T>(val cargo: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null

    override fun equals(other: Any?): Boolean {
        if (other is Node<*>) {
            return this.cargo == other.cargo
        }
        return false
    }
}

/** Used in function details(), implementation */
fun String.times(num: Int): String{
    val sb = StringBuilder()
    for (n in 1..num) {
        sb.append(this)
    }
    return sb.toString()
}

