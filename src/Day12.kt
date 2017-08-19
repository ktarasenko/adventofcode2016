object Day12 {

    val registers = mutableMapOf("a" to 0, "b" to 0, "c" to 1, "d" to 0)


    fun solve(list : List<String>) : Int{
        process(list)
        return registers["a"]!!
    }

    private fun process(list: List<String>) {
        var i = 0
        while (i < list.size){
            val cmd = list[i].split(" ")
            when (cmd[0]){
                "cpy"-> {registers.put(cmd[2], registers.getOrElse(cmd[1], {cmd[1].toInt()})); i++}
                "inc" -> {registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) + 1); i++}
                "dec" -> {registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) -1); i++}
                "jnz" -> if (registers.getOrElse(cmd[1], {cmd[1].toInt()}) != 0) i += cmd[2].toInt() else i++
            }
        }
    }


}