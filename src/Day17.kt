object Day17 {

    val range = 0 until 4

    val moves = listOf(Triple(0 , -1, 'U'),
            Triple(0 , 1, 'D'),
            Triple(-1 , 0, 'L'),
            Triple(1 , 0, 'R'))


    fun findWayOut(phrase : String) : String{
        var moves = makeMoves(0 to 0,"", phrase)
        while (moves.isNotEmpty() && solution(moves) == null){
            moves = moves.flatMap { makeMoves(it.first to it.second, it.third, phrase) }
        }

        return solution(moves)!!.third
    }

    fun longestPath(phrase : String) : Int{
        var moves = makeMoves(0 to 0,"", phrase)
        var lastSolutionLength = 0
        var step = 1
        while (moves.isNotEmpty()) {
            moves = moves.flatMap { makeMoves(it.first to it.second, it.third, phrase) }
            step++
            if (solution(moves) != null) {
                lastSolutionLength = step
                moves = moves.filterNot { it.first == 3 && it.second == 3 }
            }
        }
        println(step)
        return lastSolutionLength
    }

    private fun solution(moves: List<Triple<Int, Int, String>>) = moves.find { it.first == 3 && it.second == 3 }


    fun makeMoves(pos: Pair<Int, Int>, path: String, code: String): List<Triple<Int, Int, String>> {
        val hash = (code + path).md5().toList().take(4)
        return hash.zip(moves).filter {
            isOpen(it.first)
                    && (pos.first + it.second.first) in range
                    && (pos.second + it.second.second) in range
        }.map { Triple(pos.first + it.second.first,
                pos.second + it.second.second,
                path+it.second.third)}


    }

    private fun isOpen(c: Char): Boolean = c > 'a'


}