package binarySearch

/**
 * If there's a tie, the smallest element will be returned.
 */
fun List<Int>.binarySearchNearestElement(element: Int, start: Int = 0, end: Int = lastIndex): Int {
    if (isEmpty()) return -1

    return when (val firstGtIndex = binarySearchFirstGreaterThan(element, start, end)) {
        -1 -> this.lastIndex
        0 -> firstGtIndex
        else -> {
            val previousIndex = firstGtIndex - 1
            val diffPrevious = element - this[previousIndex]
            val diffFirstGt = this[firstGtIndex] - element
            if (diffFirstGt < diffPrevious) firstGtIndex else previousIndex
        }
    }
}