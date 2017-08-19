import org.junit.Assert.*
import org.junit.Test

class Day15Test{

    @Test
    fun provided(){
        assertEquals(5, Day15.findGoodTime(listOf(Triple(1, 4,5), Triple(2, 1,2))))
    }

    @Test
    fun task(){
        assertEquals(376777, Day15.findGoodTime(listOf(Triple(1, 1, 13), Triple(2, 10, 19),
                Triple(3, 2, 3), Triple(4, 1, 7),
                Triple(5, 3, 5),
                Triple(6, 5, 17)
                )))
    }

    @Test
    fun task2(){
        assertEquals(5, Day15.findGoodTime(listOf(Triple(1, 1, 13), Triple(2, 10, 19),
                Triple(3, 2, 3), Triple(4, 1, 7),
                Triple(5, 3, 5),
                Triple(6, 5, 17),
                Triple(7, 0, 11)
                )))
    }

    @Test
    fun fallingThrough() {
        assertTrue(Day15.isFallingThrough(Triple(1, 4,5), 0))
        assertTrue(Day15.isFallingThrough(Triple(1, 4,5), 5))
        assertTrue(Day15.isFallingThrough(Triple(2, 1,2), 5))
        assertFalse(Day15.isFallingThrough(Triple(2,1,2), 0))
    }
}