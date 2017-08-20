object Day25 {
    val registers = mutableMapOf("a" to 0, "b" to 0, "c" to 1, "d" to 0)


    fun solve(list : List<String>) : Int{
        (0..1000).forEach {
            if (solveA(it, list)) return it
        }
        return -1
    }

    fun solveA(a : Int , list : List<String>) : Boolean{
        registers["a"] = a
        return process(list)
    }

    private val LIMIT = 1000000

    private fun process(list: List<String>) : Boolean {
        var i = 0
        var step = 0
        var prev = 1
        while (i < list.size && step < LIMIT) {
            step++
            val cmd = list[i].split(" ")
            when (cmd[0]) {
                "cpy" -> {
                    registers.put(cmd[2], registers.getOrElse(cmd[1], { cmd[1].toInt() })); i++
                }
                "inc" -> {
                    registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) + 1); i++
                }
                "dec" -> {
                    registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) - 1); i++
                }
                "jnz" -> if (registers.getOrElse(cmd[1], { cmd[1].toInt() }) != 0) i += cmd[2].toInt() else i++
                "out" -> {
                    val curr = registers.getOrElse(cmd[1], { cmd[1].toInt() })
                    if (curr == prev) {
                        return false
                    } else {
                        prev = curr
                    }
                    i++
                }
            }
        }
        return true
    }

}