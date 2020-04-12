package binarySearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import string.MIN_STRING

internal class BinarySearchLeftMostKtTest {

    @Test
    fun binarySearchLeftMostInt_noEqualElements_returnCorrectIndex() {
        val list = listOf(1, 2, 3, 4)
        assertEquals(0, list.binarySearchLeftMost(1))
        assertEquals(1, list.binarySearchLeftMost(2))
        assertEquals(2, list.binarySearchLeftMost(3))
        assertEquals(3, list.binarySearchLeftMost(4))
        assertEquals(-1, list.binarySearchLeftMost(5))
        assertEquals(-1, list.binarySearchLeftMost(0))
        assertEquals(-1, list.binarySearchLeftMost(-1))
    }

    @Test
    fun binarySearchLeftMostInt_equalElements_returnCorrectIndex() {
        val list = listOf(1, 1, 2, 2, 2, 4, 4, 4, 5, 5, 16, 16, 16)
        assertEquals(0, list.binarySearchLeftMost(1))
        assertEquals(-1, list.binarySearchLeftMost(0))
        assertEquals(2, list.binarySearchLeftMost(2))
        assertEquals(-1, list.binarySearchLeftMost(3))
        assertEquals(5, list.binarySearchLeftMost(4))
        assertEquals(8, list.binarySearchLeftMost(5))
        assertEquals(-1, list.binarySearchLeftMost(15))
        assertEquals(-1, list.binarySearchLeftMost(17))
        assertEquals(10, list.binarySearchLeftMost(16))
    }

    @Test
    fun binarySearchLeftMostInt_emptyList_returnMinus1() {
        val list = emptyList<Int>()
        assertEquals(-1, list.binarySearchLeftMost(-1))
        assertEquals(-1, list.binarySearchLeftMost(0))
        assertEquals(-1, list.binarySearchLeftMost(1))
    }

    @Test
    fun binarySearchLeftMostInt_minInt_returnCorrectIndex() {
        val list = listOf(Int.MIN_VALUE, 1, 2, 3)
        assertEquals(0, list.binarySearchLeftMost(Int.MIN_VALUE))
        assertEquals(-1, list.binarySearchLeftMost(-100))
    }

    @Test
    fun binarySearchLeftMostString_noEqualElements_returnCorrectIndex() {
        val list = listOf("a", "b", "c", "d")
        assertEquals(0, list.binarySearchLeftMost("a"))
        assertEquals(1, list.binarySearchLeftMost("b"))
        assertEquals(2, list.binarySearchLeftMost("c"))
        assertEquals(3, list.binarySearchLeftMost("d"))
        assertEquals(-1, list.binarySearchLeftMost("D"))
        assertEquals(-1, list.binarySearchLeftMost("0"))
    }

    @Test
    fun binarySearchLeftMostString_emptyList_returnMinus1() {
        val list = emptyList<String>()
        assertEquals(-1, list.binarySearchLeftMost(""))
        assertEquals(-1, list.binarySearchLeftMost(Char.MIN_VALUE.toString()))
    }

    @Test
    fun binarySearchLeftMostString_minString_returnCorrectIndex() {
        val list = listOf(Char.MIN_VALUE.toString(), "abc", "xpto")
        assertEquals(0, list.binarySearchLeftMost(MIN_STRING))
    }
}