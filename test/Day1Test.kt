import org.junit.Assert.*
import org.junit.Test

class Day1Test{

    @Test
    fun providedInput1(){
        assertEquals(5, Day1.distanceToHq(input("R2, L3")))
    }
    @Test
    fun providedInput2(){
        assertEquals(2, Day1.distanceToHq(input("R2, R2, R2")))
    }
    @Test
    fun providedInput3(){
        assertEquals(12, Day1.distanceToHq(input("R5, L5, R5, R3")))
    }
    @Test
    fun simpleInput1(){
        assertEquals(0, Day1.distanceToHq(input("")))
    }

    @Test
    fun simpleInput2(){
        assertEquals(5, Day1.distanceToHq(input("L5")))
    }

    @Test
    fun simpleInput3(){
        assertEquals(5, Day1.distanceToHq(input("R5")))
    }

    @Test
    fun simpleInput4(){
        assertEquals(0, Day1.distanceToHq(input("R1, L0, L1")))
    }

   @Test
    fun taskInput(){
        assertEquals(236, Day1.distanceToHq(input("R3, L5, R1, R2, L5, R2, R3, L2, L5, R5, L4, L3, R5, L1, R3," +
                " R4, R1, L3, R3, L2, L5, L2, R4, R5, R5, L4, L3, L3, R4, R4, R5, L5, L3, R2, R2, L3, L4, L5, R1, R3, L3," +
                " R2, L3, R5, L194, L2, L5, R2, R1, R1, L1, L5, L4, R4, R2, R2, L4, L1, R2, R53, R3, L5, R72, R2, L5, R3," +
                " L4, R187, L4, L5, L2, R1, R3, R5, L4, L4, R2, R5, L5, L4, L3, R5, L2, R1, R1, R4, L1, R2, L3, R5, L4, R2," +
                " L3, R1, L4, R4, L1, L2, R3, L1, L1, R4, R3, L4, R2, R5, L2, L3, L3, L1, R3, R5, R2, R3, R1, R2, L1, L4, L5, " +
                "L2, R4, R5, L2, R4, R4, L3, R2, R1, L4, R3, L3, L4, L3, L1, R3, L2, R2, L4, L4, L5, R3, R5, R3, L2, R5, L2, L1," +
                " L5, L1, R2, R4, L5, R2, L4, L5, L4, L5, L2, L5, L4, R5, R3, R2, R2, L3, R3, L2, L5")))
    }


    private fun input(s: String): Iterable<String> = s.split(", ")
}