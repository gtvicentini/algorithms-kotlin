package graph.shortestPath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShortestPathUnitaryEdgeKtTest {

    @Test
    fun shortestPath_validInput_findsTheShortestPathCorrectly() {
        val graph = mapOf(
            "Min" to setOf("William", "Jayden", "Omar"),
            "William" to setOf("Min", "Noam"),
            "Jayden" to setOf("Min", "Amelia", "Ren", "Noam"),
            "Ren" to setOf("Jayden", "Omar"),
            "Amelia" to setOf("Jayden", "Adam", "Miguel"),
            "Adam" to setOf("Amelia", "Miguel", "Sofia", "Lucas"),
            "Miguel" to setOf("Amelia", "Adam", "Liam", "Nathan"),
            "Noam" to setOf("Nathan", "Jayden", "William"),
            "Omar" to setOf("Ren", "Min", "Scott")
        )
        val shortestPath = graph.shortestPath("Jayden", "Adam")
        assertEquals(listOf("Jayden", "Amelia", "Adam"), shortestPath)
    }

    @Test
    fun shortestPath_sameInputOtherPath_findsTheShortestPathCorrectly() {
        val graph = mapOf(
            "Min" to setOf("William", "Jayden", "Omar"),
            "William" to setOf("Min", "Noam"),
            "Jayden" to setOf("Min", "Amelia", "Ren", "Noam"),
            "Ren" to setOf("Jayden", "Omar"),
            "Amelia" to setOf("Jayden", "Adam", "Miguel"),
            "Adam" to setOf("Amelia", "Miguel", "Sofia", "Lucas"),
            "Miguel" to setOf("Amelia", "Adam", "Liam", "Nathan"),
            "Noam" to setOf("Nathan", "Jayden", "William"),
            "Omar" to setOf("Ren", "Min", "Scott")
        )
        val shortestPath = graph.shortestPath("Miguel", "Scott")
        assertEquals(listOf("Miguel", "Amelia", "Jayden", "Ren", "Omar", "Scott"), shortestPath)
    }

    @Test
    fun shortestPath_sourceEqualDest_findsTheShortestPathCorrectly() {
        val graph = mapOf(
            "Min" to setOf("William", "Jayden", "Omar"),
            "William" to setOf("Min", "Noam"),
            "Jayden" to setOf("Min", "Amelia", "Ren", "Noam")
        )
        val shortestPath = graph.shortestPath("William", "William")
        assertEquals(listOf("William"), shortestPath)
    }

    @Test
    fun shortestPath_pathNotExists_returnsEmptyMap() {
        val graph = mapOf(
            "Min" to setOf("William", "Jayden"),
            "William" to setOf("Chris", "Adam"),
            "Janet" to setOf("Winston")
        )
        val shortestPath = graph.shortestPath("Min", "Janet")
        assertEquals(emptyList<String>(), shortestPath)
    }
}