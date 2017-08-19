import org.junit.Assert.*
import org.junit.Test

class Day13Test {

    @Test
    fun mazeCheck(){
        val maze = Day13.Maze(10, 10, 10)

        assertEquals(Int.MAX_VALUE, maze.maze[0][0])
        assertEquals(Int.MAX_VALUE, maze.maze[2][9])
        assertEquals(Int.MAX_VALUE, maze.maze[4][4])
        assertEquals(-1, maze.maze[0][1])
        assertEquals(-1, maze.maze[0][9])
        assertEquals(-1, maze.maze[3][0])
        assertEquals(-1, maze.maze[5][8])
    }

    @Test
    fun provided(){
        val maze = Day13.Maze(10, 10, 10)

        assertEquals(11, maze.wayFromTo(Pair(1,1), Pair(7,4)))
    }

    @Test
    fun task(){
        val maze = Day13.Maze(60, 60, 1352)

        assertEquals(90, maze.wayFromTo(Pair(1,1), Pair(31,39)))
    }

    @Test
    fun task2(){
        val maze = Day13.Maze(60, 60, 1352)

        assertEquals(11, maze.locationsAtMost(Pair(1,1), 50))
    }
}