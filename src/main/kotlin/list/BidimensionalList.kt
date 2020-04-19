package list

fun <T> List<List<T>>.orthogonalAdjacency(position: Pair<Int, Int>): List<Pair<Int, Int>> {
    val (i, j) = position
    val neighborVectors = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
    return neighborVectors
            .map { vector -> (i + vector.first) to (j + vector.second) }
            .filter { neighborCandidate -> positionInBounds(neighborCandidate) }
}

fun <T> List<List<T>>.positionInBounds(position: Pair<Int, Int>): Boolean {
    val (i, j) = position
    return i >= 0 && j >= 0 && i < size && j < get(i).size
}

fun <T> List<List<T>>.getP(position: Pair<Int, Int>) = this[position.first][position.second]