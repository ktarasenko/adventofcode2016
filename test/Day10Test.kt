import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day10Test{

    @Test
    fun provided() {
        Day10.process(("value 5 goes to bot 2\n" +
                "bot 2 gives low to bot 1 and high to bot 0\n" +
                "value 3 goes to bot 1\n" +
                "bot 1 gives low to output 1 and high to bot 0\n" +
                "bot 0 gives low to output 2 and high to output 0\n" +
                "value 2 goes to bot 2").split("\n"))
    }

    @Test
    fun task1() {
        Day10.process(File("input/day10.txt").readLines())
    }
}