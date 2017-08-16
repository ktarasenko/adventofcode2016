import org.junit.Assert.*
import org.junit.Test

class Day5Test{


    @Test
    fun providedInput() {
        assertEquals("18f47a30", Day5.findPassword1("abc"))
    }


    @Test
    fun providedInput2() {
        assertEquals("05ace8e3", Day5.findPassword2("abc"))
    }


    @Test
    fun task1() {
        assertEquals("2414bc77", Day5.findPassword1("wtnhxymk"))
    }

    @Test
    fun task2() {
        assertEquals("437e60fc", Day5.findPassword2("wtnhxymk"))
    }
}