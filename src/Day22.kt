object Day22 {

    fun solve(list: Iterable<String>): Int {
        val maze = parseMaze(list)
        maze.printMaze()
        return (maze.size - 2 downTo 0).sumBy { maze.moveNode(0 to it + 1, 0 to it) }
    }


    fun parseMaze(list: Iterable<String>): Maze {
        val nodes = list.map { parseRow(it) }
        return Maze(Math.sqrt(nodes.size.toDouble()).toInt(), nodes)
    }

    fun countViablePairs(list: Iterable<String>): Int {
        val nodes = list.map { parseRow(it) }

        return nodes.fold(0, { acc, node1 ->
            nodes.fold(acc, { acc, node2 ->
                if (node1.isViablePairWith(node2)) {
                    acc + 1
                } else {
                    acc
                }
            })
        })
    }


    fun parseRow(row: String): Node {
        val s = row.split("""\s+""".toRegex())
        val nodename = s[0].split("-")

        return Node(nodename[1].drop(1).toInt(), nodename[2].drop(1).toInt(),
                s[3].dropLast(1).toInt(), s[2].dropLast(1).toInt())
    }


    data class Node(val x: Int, val y: Int, val avail: Int, val used: Int) {
        fun isViablePairWith(node: Node): Boolean = this != node && used > 0 && used <= node.avail
        fun hasViablePairWith(nodes: List<Node>): Boolean = nodes.any { this.isViablePairWith(it) }
    }


    class Maze(val size: Int, nodes: List<Node>) {
        val DEAD = -5
        val TARGET = -3
        val INIT = 0
        val EMPTY = -1

        val maze = Array(size, { Array(size, { 0 }) })

        init {
            nodes.forEach {
                maze[it.y][it.x] = when {
                    it.used == 0 -> EMPTY
                    !it.hasViablePairWith(nodes) -> DEAD
                    else -> INIT
                }
            }
            maze[0][size - 1] = TARGET
        }

        fun printMaze() {
            maze.forEach {
                it.forEach {
                    print(when (it) {
                        DEAD -> '#'
                        TARGET -> 'G'
                        EMPTY -> '_'
                        else -> '.'
                    })
                }
                println()
            }
            println()
        }

        fun clearSteps() {
            maze.forEachIndexed { i, it1 ->
                it1.forEachIndexed { j, it2 ->
                    if (it2 > 0) {
                        maze[i][j] = INIT
                    }
                }
            }
        }


        fun moveNode(from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
            var steps = 0
            steps += emptyNode(to)
            steps += swap(from, to)
            return steps
        }

        fun emptyNode(node: Pair<Int, Int>): Int {
            var steps = 0
            if (maze[node.first][node.second] == EMPTY) {
                return steps
            } else {
                val path = path(from = findEmptyNode(), to = node)
                println(path)
                //could it be just counted? TODO
                for (i in 1 until path.size){ //path from empty node to current node, both inclusive
                    steps += swap(path[i-1], path[i])
                }
            }
            return steps
        }

        val moves = listOf(0 to -1, 0 to 1, 1 to 0, -1 to 0)
        val range = 0 until size


        fun path(from: Pair<Int, Int>, to: Pair<Int, Int>): List<Pair<Int, Int>> {
            paintPath(1, from, to)
            if (maze[to.first][to.second] == INIT)   throw IllegalStateException("path not fount")
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
                        .filter { it.second in range && it.first in range }
                c = validMoves.find { it == from }?: validMoves.first{  maze[it.first][it.second] == step-1}
                step--
                path.add(0, c)
            }
            return path
        }

        fun paintPath(step: Int, from: Pair<Int, Int>, to: Pair<Int, Int>) {
            val validMoves = moves.map { (from.first + it.first) to (from.second + it.second) }
                    .filter {
                        it.second in range
                                && it.first in range
                                &&
                                (maze[it.first][it.second] == INIT || maze[it.first][it.second] > step)
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

        private fun findEmptyNode(): Pair<Int, Int> {
            maze.forEachIndexed { i, it1 ->
                it1.forEachIndexed { j, it2 ->
                    if (it2 == EMPTY) {
                        return i to j
                    }
                }
            }
            throw IllegalStateException("empty node lost")
        }

        fun swap(from: Pair<Int, Int>, to: Pair<Int, Int>): Int {
            val t = maze[from.first][from.second]
            maze[from.first][from.second] = maze[to.first][to.second]
            maze[to.first][to.second] = t
            printMaze()
            return 1
        }
    }


}
