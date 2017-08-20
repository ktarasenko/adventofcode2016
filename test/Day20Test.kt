import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day20Test{
    @Test
    fun provided() {
        assertEquals(3, Day20.findLowestNumberAllowed(("5-8\n" +
                "0-2\n" +
                "4-7").split("\n")))
    }

    @Test
    fun provided2() {
        assertEquals(2, Day20.countAllowed(("5-8\n" +
                "0-2\n" +
                "4-7").split("\n"), 9))
    }

    @Test
    fun task1() {
        assertEquals(19449262, Day20.findLowestNumberAllowed(File("input/day20.txt").readLines()))
    }

    @Test
    fun task2() {
        assertEquals(119, Day20.countAllowed(File("input/day20.txt").readLines(),
                4294967295L))
    }
}