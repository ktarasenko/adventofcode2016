object Day13 {



    class Maze(height: Int, width: Int, val n : Int){

        val xR = 0 until width
        val yR = 0 until height


        val maze: Array<Array<Int>> = Array(height, {y -> Array(width, {x -> countCell(x,y)})})

        fun countCell(x: Int, y: Int): Int {
            val a = x*x + 3*x + 2*x*y + y + y*y + n
            val isWall = a.toString(2).count { it == '1'} %2 == 1
            return if (isWall) -1 else Int.MAX_VALUE
        }

        fun wayFromTo(from : Pair<Int, Int>, to: Pair<Int, Int>): Int {
            maze[from.second][from.first] = 0
            findWay(1, Int.MAX_VALUE, from.first, from.second)
            return maze[to.second][to.first]
        }

        fun findWay(step: Int, maxStep: Int, x: Int, y: Int) {
            if (step <= maxStep) {
                moves(step, x, y).forEach {
                    findWay(step + 1, maxStep, it.first, it.second)
                }
            }
        }

        fun locationsAtMost(from : Pair<Int, Int>, atMost: Int): Int {
            maze[from.second][from.first] = 0
            findWay(1, atMost, from.first, from.second)
            return maze.flatMap { it.filter { it in 0..atMost } }.size
        }


        private fun moves(step: Int, x: Int, y: Int): Iterable<Pair<Int, Int>> {
            val list = listOf(Pair(x+1, y), Pair(x-1, y), Pair(x, y+1), Pair(x, y-1))
                    .filter { it.first in xR && it.second in yR && maze[it.second][it.first] > step}
            list.forEach{
                maze[it.second][it.first] = step
            }
            return list

        }


    }
}