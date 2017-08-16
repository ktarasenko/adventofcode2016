import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day7Test{
    @Test
    fun abbaPositive() {
        assertTrue(Day7.isAbba("abba"))
    }

    @Test
    fun abbaNegative() {
        assertFalse(Day7.isAbba("abab"))
        assertFalse(Day7.isAbba("aaaa"))
    }

    @Test
    fun hasAbbaPos() {
       assertTrue(Day7.hasAbba("abba"))
       assertTrue(Day7.hasAbba("abcerreooo"))
       assertTrue(Day7.hasAbba("adkjdkfniin"))
    }

    @Test
    fun hasAbbaNeg(){
        assertFalse(Day7.hasAbba("abab"))
        assertFalse(Day7.hasAbba("dsdjsdkdfkjdf"))
        assertFalse(Day7.hasAbba("aaaaaaaaa"))
        assertFalse(Day7.hasAbba("aaaaaaabfa"))
    }

    @Test
    fun isTls() {
        assertTrue(Day7.isTls("abba[mnop]qrst"))
        assertFalse(Day7.isTls("abcd[bddb]xyyx"))
        assertFalse(Day7.isTls("aaaa[qwer]tyui"))
        assertTrue(Day7.isTls("ioxxoj[asdfgh]zxcvbn"))
        assertFalse(Day7.isTls("ioxxoj[asdfgh]zxcvbn[abba]"))
    }

    @Test
    fun isSsl() {
        assertTrue(Day7.isSsl("aba[bab]xyz"))
        assertFalse(Day7.isSsl("xyx[xyx]xyx"))
        assertTrue(Day7.isSsl("aaa[kek]eke"))
        assertTrue(Day7.isSsl("zazbz[bzb]cdb"))

    }

    @Test
    fun task(){
        assertEquals(0, Day7.countTls(File("input/day7.txt").readLines()))
    }
    @Test
    fun task2(){
        assertEquals(0, Day7.countSsl(File("input/day7.txt").readLines()))
    }
}