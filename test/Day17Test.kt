import org.junit.Assert.*
import org.junit.Test

class Day17Test {

    @Test
    fun provided1() {
        assertEquals("DDRRRD", Day17.findWayOut("ihgpwlah"))
    }

    @Test
    fun provided2() {
        assertEquals("DDUDRLRRUDRD", Day17.findWayOut("kglvqrro"))
    }

    @Test
    fun provided3() {
        assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", Day17.findWayOut("ulqzkmiv"))
    }


    @Test
    fun provided4() {
        assertEquals(370, Day17.longestPath("ihgpwlah"))
    }


    @Test
    fun provided5() {
        assertEquals(492, Day17.longestPath("kglvqrro"))
    }


    @Test
    fun provided6() {
        assertEquals(830, Day17.longestPath("ulqzkmiv"))
    }

    @Test
    fun task1() {
        assertEquals("RDRRULDDDR", Day17.findWayOut("vkjiggvb"))
    }

    @Test
    fun task2() {
        assertEquals(300, Day17.longestPath("vkjiggvb"))
    }
}