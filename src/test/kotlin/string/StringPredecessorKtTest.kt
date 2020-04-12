package string

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class StringPredecessorKtTest {

    @Test
    fun predecessor_validInputs_validResults() {
        assertEquals("a", "b".predecessor())
        assertEquals("abc", "abd".predecessor())
        assertEquals(
                listOf(Char.MAX_VALUE).joinToString(""),
                listOf(Char.MIN_VALUE, Char.MIN_VALUE).joinToString("").predecessor()
        )
    }

    @Test
    fun predecessor_invalidInput_throwException() {
        assertThrows<IllegalArgumentException> {
            listOf(Char.MIN_VALUE).joinToString("").predecessor()
        }
    }

}
