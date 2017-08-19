import org.junit.Assert.*
import org.junit.Test

class Day18Test {
    @Test
    fun provided() {
        assertEquals(38, Day18.generateRowsAndSafeTiles(".^^.^.^^^^", 10))
    }

    @Test
    fun task(){
        assertEquals(1913, Day18.generateRowsAndSafeTiles("^.^^^..^^...^.^..^^^^^.....^...^^^..^^^^.^^.^^^^^^^^.^^.^^^^...^^...^^^^.^.^..^^..^..^.^^.^.^.......", 40))
    }

    @Test
    fun task2(){
        assertEquals(19993564, Day18.generateRowsAndSafeTiles("^.^^^..^^...^.^..^^^^^.....^...^^^..^^^^.^^.^^^^^^^^.^^.^^^^...^^...^^^^.^.^..^^..^..^.^^.^.^.......", 400000))
    }
}