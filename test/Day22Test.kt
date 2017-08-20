import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day22Test{

    @Test
    fun parseRow(){
        assertEquals(Day22.Node(0, 0,21, 73), Day22.parseRow("/dev/grid/node-x0-y0     94T   73T    21T   77%"))
    }

   @Test
    fun provided(){
        assertEquals(7, Day22.solve(("/dev/grid/node-x0-y0   10T    8T     2T   80%\n" +
                "/dev/grid/node-x0-y1   11T    6T     5T   54%\n" +
                "/dev/grid/node-x0-y2   32T   28T     4T   87%\n" +
                "/dev/grid/node-x1-y0    9T    7T     2T   77%\n" +
                "/dev/grid/node-x1-y1    8T    0T     8T    0%\n" +
                "/dev/grid/node-x1-y2   11T    7T     4T   63%\n" +
                "/dev/grid/node-x2-y0   10T    6T     4T   60%\n" +
                "/dev/grid/node-x2-y1    9T    8T     1T   88%\n" +
                "/dev/grid/node-x2-y2    9T    6T     3T   66%").split("\n")))
    }

    @Test
    fun test(){
         val maze = Day22.parseMaze(("/dev/grid/node-x0-y0   10T    8T     2T   80%\n" +
                "/dev/grid/node-x0-y1   11T    6T     5T   54%\n" +
                "/dev/grid/node-x0-y2   32T   28T     4T   87%\n" +
                "/dev/grid/node-x1-y0    9T    7T     2T   77%\n" +
                "/dev/grid/node-x1-y1    8T    1T     8T    0%\n" +
                "/dev/grid/node-x1-y2   11T    7T     4T   63%\n" +
                "/dev/grid/node-x2-y0   10T    6T     4T   60%\n" +
                "/dev/grid/node-x2-y1    9T    8T     1T   88%\n" +
                "/dev/grid/node-x2-y2    9T    6T     3T   66%").split("\n"))
        maze.printMaze()
//        println(maze.path(from =0 to 0, to = 1 to 1))
        println(maze.path(from =0 to 0, to = 1 to 1))
    }


    @Test
    fun task(){
        assertEquals(934, Day22.countViablePairs(File("input/day22.txt").readLines().drop(2)))
    }

    @Test
    fun task2(){
        assertEquals(207, Day22.solve(File("input/day22.txt").readLines().drop(2)))
    }


}