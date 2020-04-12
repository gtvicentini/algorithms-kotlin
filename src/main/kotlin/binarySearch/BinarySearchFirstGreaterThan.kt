package binarySearch

fun <T : Comparable<T>> List<T>.binarySearchFirstGreaterThan(element: T, start: Int = 0, end: Int = lastIndex): Int {
    if (isEmpty()) return -1

    var low = start
    var high = end

    while (low < high) {
        val  mid = (high + low).ushr(1)
        val candidate = get(mid)
        if (candidate <= element) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return if (get(low) > element) low else -1
}