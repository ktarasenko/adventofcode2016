import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day4Test {
    @Test
    fun provided1() {
       assertEquals(123, Day4.countRoomCodes(listOf("aaaaa-bbb-z-y-x-123[abxyz]")))
    }

    @Test
    fun provided2() {
        assertEquals(987, Day4.countRoomCodes(listOf("a-b-c-d-e-f-g-h-987[abcde]")))
    }

    @Test
    fun provided3() {
        assertEquals(404, Day4.countRoomCodes(listOf("not-a-real-room-404[oarel]")))
    }


    @Test
    fun provided4() {
        assertEquals(0, Day4.countRoomCodes(listOf("qzmt-zixmtkozy-ivhz-343[zimth]")))
    }



    @Test
    fun provided5() {
        Day4.decryptRealRooms(listOf("qzmt-zixmtkozy-ivhz-343[zimth]"))
    }



    @Test
    fun simple1() {
        assertEquals(1, Day4.countRoomCodes(listOf("a-001[a]")))
    }


    @Test
    fun simple2() {
        assertEquals(1, Day4.countRoomCodes(listOf("aaaaaaa-001[a]")))
    }

    @Test
    fun task() {
        assertEquals(245102, Day4.countRoomCodes(File("input/day4.txt").readLines()))
    }


    @Test
    fun task1() {
        Day4.decryptRealRooms(File("input/day4.txt").readLines())
    }



}
