import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

class Day19Test{

    @Test
    fun provided() {
        assertEquals(3, Day19.elvesProblem(5))
    }

    @Test
    fun provided2() {
        assertEquals(2, Day19.elvesProblem2(5))
    }

    @Test
    fun simple() {
        assertEquals(1, Day19.elvesProblem2(2))
        assertEquals(1, Day19.elvesProblem2(4))
        assertEquals(3, Day19.elvesProblem2(6))
    }

    @Test
    fun task() {
        assertEquals(1830117, Day19.elvesProblem(3012210))
    }

    @Test
    fun task2() {
        assertEquals(31682, Day19.elvesProblem2(3012210))
    }
}