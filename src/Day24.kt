object Day24 {

    fun solve(list: Iterable<String>, shouldReturn: Boolean): Int {
        val points = mutableListOf<Pair<Int, Pair<Int, Int>>>()
        val input = list.mapIndexed({ i, s ->  s.mapIndexed{j, v->
            when (v) {
                '.' -> 0
                '#' -> -100
                else -> {
                    points.add(v.toString().toInt() to(i to j))
                    0
                }
            }
        }}
        ).map { it.toTypedArray() }.toTypedArray()

        val maze = Maze(input)

        val pointsPairs = mutableListOf<Pair<Pair<Int, Pair<Int, Int>>, Pair<Int, Pair<Int, Int>>>>()
        for (i in 0 until points.size-1){
            for (j in i+1 until points.size){
                pointsPairs.add(Pair(points[i], points[j]))
            }
        }

        var adjTable = Array(points.size, {Array(points.size, {-1})})

        pointsPairs.forEach{
           val path =  maze.path(it.first.second, it.second.second)
            //optimize if path crosses other point
            if (path.isNotEmpty()){
                adjTable[it.first.first][it.second.first] = path.size-1
                adjTable[it.second.first][it.first.first] = path.size-1
            }
        }

//        println(adjTable.joinToString( separator = "") { it.joinToString(postfix = "\n", separator = "  ")})
        var perm = permutations((0 until points.size).toMutableList(), 1)

        if (shouldReturn){
            perm = perm.map { it + 0 }
        }
        return perm.map { countLength(adjTable, it) }
                .filter { it > 0 }.min()!!
    }

    private fun countLength(adjTable: Array<Array<Int>>, path: List<Int>): Int {
        return (0 until path.size-1).sumBy {
            val nextLength = adjTable[path[it]][path[it+1]]
            if (nextLength == -1) {
                return -1
            }
            nextLength
        }
    }

    fun permutations(list : MutableList<Int>, from : Int): List<List<Int>>{
        val res = mutableListOf<List<Int>>()
        if (from == list.size){
            res.add(ArrayList(list))
        } else {
            for (i in from until list.size){
                swap(list, from, i)
                res.addAll(permutations(list, from +1))
            }
            for (i in from until list.size-1){
                swap(list, i, i+1)
            }
        }
        return res
    }

    private fun swap(list: MutableList<Int>, from: Int, i: Int) {
        val t = list[i]
        list[i] = list[from]
        list[from] = t
    }


    class Maze(val maze: Array<Array<Int>>) {

        val EMPTY = 0
        val WALL = -100

        val moves = listOf(0 to -1, 0 to 1, 1 to 0, -1 to 0)
        val rangeY = 0 until maze.size
        val rangeX = 0 until maze.first().size


        fun printMaze() {
            maze.forEach {
                it.forEach {
                    print(when (it) {
                        WALL -> '#'
                        EMPTY -> '.'
                        else -> it
                    })
                }
                println()
            }
            println()
        }

        fun clearSteps() {
            maze.forEachIndexed { i, it1 ->
                it1.forEachIndexed { j, it2 ->
                    if (it2 >= 0) {
                        maze[i][j] = EMPTY
                    }
                }
            }
        }


        fun path(from: Pair<Int, Int>, to: Pair<Int, Int>): List<Pair<Int, Int>> {
            paintPath(1, from, to)
            if (maze[to.first][to.second] == EMPTY)   throw IllegalStateException("path not fount")
            val res = recoverPath(from, to)
            clearSteps()
            return res
        }

        private fun recoverPath(from: Pair<Int, Int>, to: Pair<Int, Int>): List<Pair<Int, Int>> {
            val path = mutableListOf<Pair<Int, Int>>()
            var c = to
            path.add(c)
            var step = maze[to.first][to.second]
            while (c != from) {
                val validMoves = moves.map { (c.first + it.first) to (c.second + it.second) }
                        .filter { it.second in rangeX && it.first in rangeY }
                c = validMoves.find { it == from }?: validMoves.first{  maze[it.first][it.second] == step-1}
                step--
                path.add(0, c)
            }
            return path
        }

        private fun paintPath(step: Int, from: Pair<Int, Int>, to: Pair<Int, Int>) {
            val validMoves = moves.map { (from.first + it.first) to (from.second + it.second) }
                    .filter {
                        it.second in rangeX && it.first in rangeY
                                &&
                                (maze[it.first][it.second] == EMPTY || maze[it.first][it.second] > step)
                    }
            validMoves.forEach {
                maze[it.first][it.second] = step
            }
            if (!validMoves.contains(to)) {

                validMoves.forEach {
                    paintPath(step + 1, it, to)
                }
            }
        }


    }
}