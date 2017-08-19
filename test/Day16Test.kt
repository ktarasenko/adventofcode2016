import org.junit.Assert.*
import org.junit.Test

class Day16Test{

    @Test
    fun generate(){
        assertEquals("001", Day16.generateSequence("0"))
        assertEquals("100", Day16.generateSequence("1"))
        assertEquals("11111000000", Day16.generateSequence("11111"))
        assertEquals("1111000010100101011110000", Day16.generateSequence("111100001010"))
    }

    @Test
    fun checksum(){
        assertEquals("000", Day16.checksum("010101"))
        assertEquals("1", Day16.checksum("1"))
        assertEquals("0", Day16.checksum("0"))
        assertEquals("1", Day16.checksum("00"))
        assertEquals("0", Day16.checksum("01"))
        assertEquals("100", Day16.checksum("110010110100"))
        assertEquals("01100", Day16.checksum("10000011110010000111"))
    }

    @Test
    fun provided(){
        assertEquals("01100", Day16.fillDisk("10000", 20))
    }

    @Test
    fun task1(){
        assertEquals("11111000111110000", Day16.fillDisk("01111001100111011", 272))
    }

    @Test
    fun task2(){
        assertEquals("10111100110110100", Day16.fillDisk("01111001100111011", 35651584))
    }
}