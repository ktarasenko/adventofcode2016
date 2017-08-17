import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day9Test{

    @Test
    fun provided() {
        assertEquals("ADVENT", Day9.decode("ADVENT"))
        assertEquals("ABBBBBC", Day9.decode("A(1x5)BC"))
        assertEquals("XYZXYZXYZ", Day9.decode("(3x3)XYZ"))
        assertEquals("ABCBCDEFEFG", Day9.decode("A(2x2)BCD(2x2)EFG"))
        assertEquals("(1x3)A", Day9.decode("(6x1)(1x3)A"))
        assertEquals("X(3x3)ABC(3x3)ABCY", Day9.decode("X(8x2)(3x3)ABCY"))
    }

    @Test
    fun provided1() {
        assertEquals(6, Day9.decodeOnlyCount("ADVENT"))
        assertEquals(7, Day9.decodeOnlyCount("A(1x5)BC"))
        assertEquals(9, Day9.decodeOnlyCount("(3x3)XYZ"))
        assertEquals(11, Day9.decodeOnlyCount("A(2x2)BCD(2x2)EFG"))
        assertEquals(6, Day9.decodeOnlyCount("(6x1)(1x3)A"))
        assertEquals(18, Day9.decodeOnlyCount("X(8x2)(3x3)ABCY"))
    }

    @Test
    fun provided2() {
        assertEquals(6, Day9.decodeCountV2("ADVENT"))
        assertEquals(9, Day9.decodeCountV2("(3x3)XYZ"))
        assertEquals(20, Day9.decodeCountV2("X(8x2)(3x3)ABCY"))
        assertEquals(241920, Day9.decodeCountV2("(27x12)(20x12)(13x14)(7x10)(1x12)A"))
        assertEquals(445, Day9.decodeCountV2("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"))
    }

    @Test
    fun task(){
        assertEquals(110346, Day9.decodeOnlyCount(File("input/day9.txt").readText()))
    }

    @Test
    fun task2(){
        assertEquals(110346, Day9.decodeCountV2(File("input/day9.txt").readText()))
    }
}