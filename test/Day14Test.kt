import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

class Day14Test {

    @Test
    @Ignore
    fun simple(){
        assertTrue(isValidKey("abc", 39))
        assertTrue(isValidKey("abc", 92))
        assertFalse(isValidKey("abc", 18))
        assertTrue(isValidKey("abc", 22728))
    }

    @Test
    fun strechedMd5(){
        assertEquals("a107ff634856bb300138cac6568c0f24", Day14.strechedMd5("abc0"))
    }

    private fun isValidKey(s: String, i: Int): Boolean = Day14.isValidKey((s+i).md5(), i, s, Day14.simpleMd5)

    @Test
    fun provided() {
        assertEquals(22728, Day14.countMd5("abc", Day14.simpleMd5))
    }

    @Test
    fun provided2() {
        assertEquals(22551, Day14.countMd5("abc", Day14.strechedMd5))
    }

    @Test
    fun task() {
        assertEquals(15035, Day14.countMd5("ihaygndm", Day14.simpleMd5))
    }

    @Test
    fun task2() {
        assertEquals(19968, Day14.countMd5("ihaygndm", Day14.strechedMd5))
    }
}