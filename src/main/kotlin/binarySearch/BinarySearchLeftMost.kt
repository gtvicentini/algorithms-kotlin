package binarySearch

import string.MIN_STRING
import string.predecessor

/**
 * These functions don't work for the smallest Int and String.
 */

fun List<Int>.binarySearchLeftMost(element: Int, start: Int = 0, end: Int = lastIndex): Int {
    if (isEmpty()) return -1

    if (element == Int.MIN_VALUE) {
        return if (get(0) == element) 0 else -1
    }

    val predecessor = element - 1
    val index = binarySearchFirstGreaterThan(predecessor, start, end)
    return if (index >= 0 && get(index) != element) -1 else index
}

fun List<String>.binarySearchLeftMost(element: String, start: Int = 0, end: Int = lastIndex): Int {
    if (isEmpty()) return  -1

    if (element == MIN_STRING) {
        return if (get(0) == element) 0 else -1
    }

    val predecessor = element.predecessor()
    val index = binarySearchFirstGreaterThan(predecessor, start, end)
    return if (index >= 0 && get(index) != element) -1 else index
}