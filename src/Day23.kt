object Day23 {

    val registers = mutableMapOf("a" to 12, "b" to 0, "c" to 0, "d" to 0)


    fun solve(list: List<String>): Int {
        process(list.toMutableList())
        return registers["a"]!!
    }

    private fun process(list: MutableList<String>) {
        var i = 0
        while (i < list.size) {
            val cmd = list[i].split(" ")
            when (cmd[0]) {
                "cpy" -> {
                    if (cmd[2].toIntOrNull() == null) {
                        registers.put(cmd[2], registers.getOrElse(cmd[1], { cmd[1].toInt() }))
                    }
                    i++
                }
                "inc" -> {
                    registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) + 1); i++
                }
                "dec" -> {
                    registers.put(cmd[1], registers.getOrDefault(cmd[1], 0) - 1); i++
                }
                "jnz" -> if (registers.getOrElse(cmd[1], { cmd[1].toInt() }) != 0)
                    i += registers.getOrElse(cmd[2], { cmd[2].toInt() }) else i++
                "tgl" -> {
                    val pos = i + registers.getOrElse(cmd[1], { cmd[1].toInt() })
                    list.getOrNull(pos)?.let {
                        list.set(pos, toggle(it))
                    }
                    i++
                }
            }
        }
    }

    private fun toggle(cmdStr: String): String {
        val cmd = cmdStr.split(" ").toMutableList()
        when (cmd.size) {
            2 -> cmd[0] = when (cmd[0]) {
                "inc" -> "dec"
                else -> "inc"
            }
            3 -> cmd[0] = when (cmd[0]) {
                "jnz" -> "cpy"
                else -> "jnz"
            }
        }
        return cmd.joinToString(separator = " ")
    }

}