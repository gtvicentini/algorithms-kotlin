package graph.shortestPath

fun <T> Map<T, Set<T>>.shortestPath(source: T, dest: T): List<T> {
    if (source == dest) {
        return listOf(source)
    }
    val childToParent = mutableMapOf<T, T?>(source to null)
    val visited = HashSet<T>(listOf(source))
    var toVisit = this.getValue(source).toList()
    toVisit.forEach { childToParent[it] = source }
    while (toVisit.isNotEmpty()) {
        val nextToVisit = mutableListOf<T>()
        for (i in toVisit.indices) {
            val vertex = toVisit[i]
            if (vertex == dest) {
                return buildPathByJumpingThroughParents(vertex, childToParent)
            }
            visited.add(vertex)
        }
        toVisit.forEach { vertex ->
            this.getOrDefault(vertex, emptySet()).filter { it !in visited }.forEach {
                nextToVisit.add(it)
                childToParent[it] = vertex
            }
        }
        toVisit = nextToVisit
    }
    return emptyList() // no path exists
}

private fun <T> buildPathByJumpingThroughParents(
    vertex: T,
    childToParent: MutableMap<T, T?>
): List<T> {
    val shortestPath = mutableListOf<T>()
    var parent: T? = vertex
    while (parent != null) {
        shortestPath.add(parent)
        parent = childToParent[parent]
    }
    return shortestPath.reversed()
}