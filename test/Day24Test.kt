import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day24Test{

    @Test
    fun provided(){
        assertEquals(14, Day24.solve(("###########\n" +
                "#0.1.....2#\n" +
                "#.#######.#\n" +
                "#4.......3#\n" +
                "###########").split("\n"),false))
    }

    @Test
    fun test(){
        assertEquals(498, Day24.solve(File("input/day24.txt").readLines(), false))
    }

    @Test
    fun test1(){
        assertEquals(804, Day24.solve(File("input/day24.txt").readLines(), true))
    }

}