import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day3Test{
    @Test
    fun simpleTriangle() {
        assertEquals(1, Day3.countTriangles(listOf("1 2 2")))
    }

    @Test
    fun simpleTriangle2() {
        assertEquals(0, Day3.countTriangles(listOf("1 2 3")))
    }

    @Test
    fun simpleTriangle3() {
        assertEquals(3, Day3.countTrianglesColumns("1 1 1\n2 2 2\n2 2 2".split("\n")))
    }

    @Test
    fun simpleTriangle4() {
        assertEquals(0, Day3.countTrianglesColumns("1\n2\n3".split("\n")))
    }

    @Test
    fun testInput() {
        assertEquals(862, Day3.countTriangles(File("input/day3.txt").readLines()))
    }

    @Test
    fun testInput2() {
        assertEquals(1577, Day3.countTrianglesColumns(File("input/day3.txt").readLines()))
    }

}
