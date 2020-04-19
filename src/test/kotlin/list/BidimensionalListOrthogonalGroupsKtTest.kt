package list

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalStdlibApi
internal class BidimensionalListOrthogonalGroupsKtTest {

    @Test
    fun orthogonalGroups_squareGrid_returnCorrectGroups() {
        val grid = listOf(
                listOf(1, 1, 2),
                listOf(1, 1, 2),
                listOf(2, 2, 2)
        )
        val og = grid.orthogonalGroups()
        assertEquals(2, og.size)
        assertEquals(setOf((0 to 0), (0 to 1), (1 to 0), (1 to 1)), og[0].toSet())
        assertEquals(setOf((0 to 2), (1 to 2), (2 to 0), (2 to 1), (2 to 2)), og[1].toSet())
    }

    @Test
    fun orthogonalGroups_rectangularGrid_returnCorrectGroups() {
        val grid = listOf(
                listOf(1, 1, 1, 2),
                listOf(1, 1, 3, 3),
                listOf(1, 1, 3, 3)
        )
        val og = grid.orthogonalGroups()
        assertEquals(3, og.size)
        assertEquals(setOf((0 to 0), (0 to 1), (0 to 2), (1 to 0), (1 to 1), (2 to 0), (2 to 1)), og[0].toSet())
        assertEquals(listOf(0 to 3), og[1])
        assertEquals(setOf((1 to 2), (1 to 3), (2 to 2), (2 to 3)), og[2].toSet())
    }

    @Test
    fun orthogonalGroups_innerBoxGrid_returnCorrectGroups() {
        val grid = listOf(
                listOf(1, 1, 1, 1),
                listOf(1, 2, 2, 1),
                listOf(1, 2, 2, 1),
                listOf(1, 1, 1, 1)
        )
        val og = grid.orthogonalGroups()
        assertEquals(2, og.size)
        val outerBox = listOf(
                (0 to 0), (0 to 1), (0 to 2), (0 to 3),
                (1 to 0), /*...............*/ (1 to 3),
                (2 to 0), /*...............*/ (2 to 3),
                (3 to 0), (3 to 1), (3 to 2), (3 to 3)
        )
        val innerBox = listOf(
                (1 to 1), (1 to 2),
                (2 to 1), (2 to 2)
        )
        assertEquals(outerBox.toSet(), og[0].toSet())
        assertEquals(innerBox.toSet(), og[1].toSet())
    }

    @Test
    fun orthogonalGroups_emptyGrid_returnEmptyList() {
        val grid = emptyList<List<Int>>()
        val og =  grid.orthogonalGroups()
        assertEquals(emptyList<List<Pair<Int, Int>>>(), og)
    }

    @Test
    fun orthogonalGroups_itAlsoWorkWithStrings_returnCorrectGroups() {
        val grid = listOf(
                listOf("ab", "ab"),
                listOf("cd", "cd")
        )
        val og = grid.orthogonalGroups()
        assertEquals(2, og.size)
        assertEquals(setOf((0 to 0), (0 to 1)), og[0].toSet())
        assertEquals(setOf((1 to 0), (1 to 1)), og[1].toSet())
    }
}