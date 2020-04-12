package binarySearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BinarySearchFirstGreaterThanKtTest {

    @Test
    fun binarySearchFirstGreaterThan_noEqualElements_returnCorrectIndex() {
        val list = listOf(1, 2 ,3 ,4)
        assertEquals(0, list.binarySearchFirstGreaterThan(-1))
        assertEquals(0, list.binarySearchFirstGreaterThan(0))
        assertEquals(1, list.binarySearchFirstGreaterThan(1))
        assertEquals(2, list.binarySearchFirstGreaterThan(2))
        assertEquals(3, list.binarySearchFirstGreaterThan(3))
        assertEquals(-1, list.binarySearchFirstGreaterThan(4))
    }

    @Test
    fun binarySearchFirstGreaterThan_equalElements_returnCorrectIndex() {
        val list = listOf(1, 1, 2, 2, 2, 4, 4, 4, 5, 5, 16, 16, 16)
        assertEquals(0, list.binarySearchFirstGreaterThan(0))
        assertEquals(0, list.binarySearchFirstGreaterThan(-1))
        assertEquals(2, list.binarySearchFirstGreaterThan(1))
        assertEquals(5, list.binarySearchFirstGreaterThan(3))
        assertEquals(8, list.binarySearchFirstGreaterThan(4))
        assertEquals(10, list.binarySearchFirstGreaterThan(14))
        assertEquals(-1, list.binarySearchFirstGreaterThan(16))
    }

    @Test
    fun binarySearchFirstGreaterThan_emptyList_returnMinus1() {
        val list = emptyList<Int>()
        assertEquals(-1, list.binarySearchFirstGreaterThan(Int.MAX_VALUE))
        assertEquals(-1, list.binarySearchFirstGreaterThan(Int.MIN_VALUE))
    }

}