object Day2 {

    fun findCode(safe : Safe, code: Iterable<String>) : String {
        val result = StringBuilder()
        for (button in code){
            for (move in button.toCharArray()){
                safe.move(move)
            }
            result.append(safe.currentButton())
        }

        return result.toString()
    }


    fun defaultSafe(): Safe = Safe(arrayOf(arrayOf("1", "2", "3"), arrayOf("4", "5", "6"), arrayOf("7", "8", "9")), 1, 1)


    fun fancySafe(): Day2.Safe = Safe(arrayOf(arrayOf("-1", "-1", "1","-1", "-1"), arrayOf( "-1","2", "3", "4", "-1"),
            arrayOf("5", "6", "7", "8", "9"),arrayOf( "-1","A", "B", "C", "-1"), arrayOf( "-1", "-1","D", "-1", "-1")), 0, 2)

    class Safe(val keypad: Array<Array<String>>, var posX : Int, var posY: Int){

        val directions = listOf(Pair(0,-1), Pair(1, 0), Pair(0, 1), Pair(-1, 0))

        fun move(direction : Char){
            move(directions.get(when (direction){
                'U' -> 0
                'R' -> 1
                'D' -> 2
                else -> 3
            }))
        }

        fun currentButton(): String = keypad[posY][posX]

        private fun move(direction: Pair<Int, Int>) {
            if (movePossible(direction)){
                posX += direction.first
                posY += direction.second
            }
        }

        private fun movePossible(direction: Pair<Int, Int>): Boolean {
            return inBounds(posY + direction.second, keypad) && inBounds(posX + direction.first, keypad[posY+ direction.second])
            && keypad[posY+ direction.second][posX + direction.first] != "-1"
        }

        private fun inBounds(pos: Int, array: Array<*>): Boolean {
            return pos in 0..array.size-1
        }



    }

}