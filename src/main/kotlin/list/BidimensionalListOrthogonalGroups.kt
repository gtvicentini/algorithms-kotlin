package list

/**
 * Two positions (i1, j1) and (i2, j2) of a matrix `M` belong to the same orthogonal group if:
 * - M[i1][j1] == M[i2][j2] and
 * - (i1 == i2 and j1 == j2 ± 1) or (i1 == i2 ± 1 and j1 == j2)
 **/

@ExperimentalStdlibApi
fun <T: Comparable<T>> List<List<T>>.orthogonalGroups(): List<List<Pair<Int, Int>>> {
    val visited = HashSet<Pair<Int, Int>>()
    val groups = ArrayList<List<Pair<Int, Int>>>()

    for (row in indices) {
        for (col in get(row).indices) {
            val firstVertexInGroup = row to col
            if (visited.contains(firstVertexInGroup)) {
                continue
            }
            val currentGroup = ArrayList<Pair<Int, Int>>()
            val toExplore = mutableListOf(firstVertexInGroup)
            while (toExplore.isNotEmpty()) {
                val vertex = toExplore.removeLast()
                visited.add(vertex)
                currentGroup.add(vertex)
                orthogonalAdjacency(vertex)
                        .filter { neighbor -> this.getP(neighbor) == this.getP(vertex) }
                        .filter { neighbor -> !visited.contains(neighbor) }
                        .map { neighbor -> toExplore.add(neighbor) }
            }
            groups.add(currentGroup)
        }
    }
    return groups
}
