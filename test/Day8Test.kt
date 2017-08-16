import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.util.*

class Day8Test{

    @Test
    fun demo() {
        Day8.rect(2, 2)
        Day8.printScreen()
        assertEquals(4, Day8.countLitPixels())
        Day8.rotateRow(0,1)
        Day8.printScreen()
        Day8.rotateRow(0,49)
        Day8.printScreen()
        Day8.rotateColumn(0, 1)
        Day8.printScreen()
        Day8.rotateColumn(0, 5)
        Day8.printScreen()
    }

    @Test
    fun task(){
        Day8.interpet(File("input/day8.txt").readLines())
        assertEquals(110, Day8.countLitPixels())
        Day8.printScreen()
    }
}