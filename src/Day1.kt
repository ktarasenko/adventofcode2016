
object Day1 {

    fun distanceToHq(route: Iterable<String>) : Int {
        val bunny = Bunny()
        for (move in route){
            when {
                move.startsWith("L") -> bunny.step(-1, move.substring(1).toInt())
                move.startsWith("R") -> bunny.step(1, move.substring(1).toInt())
            }
        }

        return bunny.distanceToHq();
    }


    class Bunny{

        val positions = HashSet<Pair<Int, Int>>()

        val directions = listOf(Pair(0,1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

        var p : Int = 0

        var posX = 0
        var posY = 0

        fun step(direction : Int, steps : Int){
            rotate(direction)
            move(steps)
        }

        private fun rotate(direction: Int) {
            p = (p + direction + directions.size) % directions.size
        }

        private fun move(steps : Int){
            repeat(steps, {
                posX += directions.get(p).first
                posY += directions.get(p).second

                remember(Pair(posX, posY))
            })
        }

        private fun remember(pair: Pair<Int, Int>) {
          if (!positions.add(pair)){
            println(Math.abs(pair.first) + Math.abs(pair.second))
          }
        }

        fun distanceToHq(): Int {
            return Math.abs(posX) + Math.abs(posY)
        }
    }
}