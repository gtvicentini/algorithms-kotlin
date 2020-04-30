package graph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AdjacencyListGraphKtTest {

    @Test
    fun adjacencyList_twoWayEdges_returnCorrectAdjacencyList() {
        val pairs = listOf((1 to 2), (3 to 4), (1 to 4))
        val adjacencyList = pairs.adjacencyList()
        assertEquals(4, adjacencyList.size)
        assertEquals(setOf(2, 4), adjacencyList[1])
        assertEquals(setOf(1), adjacencyList[2])
        assertEquals(setOf(4), adjacencyList[3])
        assertEquals(setOf(1, 3), adjacencyList[4])
    }

    @Test
    fun adjacencyList_oneWayEdges_returnCorrectAdjacencyList() {
        val pairs = listOf((1 to 2), (3 to 4), (1 to 4))
        val adjacencyList = pairs.adjacencyList(twoWayEdges = false)
        assertEquals(4, adjacencyList.size)
        assertEquals(setOf(2, 4), adjacencyList[1])
        assertEquals(emptySet<Int>(), adjacencyList[2])
        assertEquals(setOf(4), adjacencyList[3])
        assertEquals(emptySet<Int>(), adjacencyList[4])
    }

    @Test
    fun adjacencyList_emptyList_returnEmptyMap() {
        val pairs = emptyList<Pair<Int, Int>>()
        assertEquals(emptyMap<Int, Set<Int>>(), pairs.adjacencyList())
    }

    @Test
    fun adjacencyList_itAlsoWorksWithStrings_returnCorrectAdjacencyList() {
        val pairs = listOf(("a" to "b"), ("ab" to "ac"), ("b" to "c"), ("ac" to "a"))
        val adjacencyList = pairs.adjacencyList()
        assertEquals(5, adjacencyList.size)
        assertEquals(setOf("b", "ac"), adjacencyList["a"])
        assertEquals(setOf("a", "c"), adjacencyList["b"])
        assertEquals(setOf("ab", "a"), adjacencyList["ac"])
    }

}