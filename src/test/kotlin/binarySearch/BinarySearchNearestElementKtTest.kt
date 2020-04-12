package binarySearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BinarySearchNearestElementKtTest {

    @Test
    fun binarySearchNearestElement_validInputs_correctIndices() {
        val list = listOf(1, 4, 7, 10, 13)
        assertEquals(0, list.binarySearchNearestElement(-1))
        assertEquals(0, list.binarySearchNearestElement(1))
        assertEquals(0, list.binarySearchNearestElement(2))
        assertEquals(1, list.binarySearchNearestElement(3))
        assertEquals(1, list.binarySearchNearestElement(4))
        assertEquals(1, list.binarySearchNearestElement(5))
        assertEquals(2, list.binarySearchNearestElement(6))
        assertEquals(2, list.binarySearchNearestElement(7))
        assertEquals(2, list.binarySearchNearestElement(8))
        assertEquals(3, list.binarySearchNearestElement(9))
        assertEquals(3, list.binarySearchNearestElement(10))
        assertEquals(3, list.binarySearchNearestElement(11))
        assertEquals(4, list.binarySearchNearestElement(12))
        assertEquals(4, list.binarySearchNearestElement(13))
        assertEquals(4, list.binarySearchNearestElement(14))
        assertEquals(0, list.binarySearchNearestElement(Int.MIN_VALUE))
        assertEquals(list.lastIndex, list.binarySearchNearestElement(Int.MAX_VALUE))
    }

    @Test
    fun binarySearchNearestElement_emptyList_returnMinus1() {
        val list = emptyList<Int>()
        assertEquals(-1, list.binarySearchNearestElement(-1))
        assertEquals(-1, list.binarySearchNearestElement(0))
        assertEquals(-1, list.binarySearchNearestElement(1))
    }

    @Test
    fun binarySearchNearestElement_ambiguous_returnCorrectIndices() {
        val list = listOf(1, 3, 5)
        assertEquals(0, list.binarySearchNearestElement(2))
        assertEquals(1, list.binarySearchNearestElement(4))
    }

}