package graph

fun <T> List<Pair<T, T>>.adjacencyList(twoWayEdges: Boolean = true): Map<T, Set<T>> {
    val adjacencyList = HashMap<T, MutableSet<T>>()
    forEach { (vertex1, vertex2) ->
        if (vertex1 !in adjacencyList) {
            adjacencyList[vertex1] = HashSet()
        }
        if (vertex2 !in adjacencyList) {
            adjacencyList[vertex2] = HashSet()
        }
    }
    forEach { (vertex1, vertex2) ->
        adjacencyList[vertex1]!!.add(vertex2)
        if (twoWayEdges) {
            adjacencyList[vertex2]!!.add(vertex1)
        }
    }
    return adjacencyList
}
