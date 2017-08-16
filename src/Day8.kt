object Day8 {


    val rectRegex = """rect (?<a>\d+)x(?<b>\d+)""".toRegex()
    val rotateRowRgex = """rotate row y=(?<a>\d+) by (?<b>\d+)""".toRegex()
    val rotateColumnRegex = """rotate column x=(?<a>\d+) by (?<b>\d+)""".toRegex()

    val screen: Array<Array<Boolean>> = Array(6, { _ -> Array(50, { _ -> false }) })

    val rect: (a: Int, b: Int) -> Unit = {a,b ->
        for (j in 0..a - 1) {
            for (i in 0..b - 1) {
                screen[i][j] = true
            }
        }
    }

    val rotateRow: (a: Int, b: Int) -> Unit = {a, b ->
        val row = Array(50, { i -> screen[a][(50 + i - b) % 50] })
        screen[a] = row
    }

    val rotateColumn: (a: Int, b: Int) -> Unit = {a, b ->
        val column = Array<Boolean>(6, { i -> screen[(6 + i - b) % 6][a] })
        for (i in 0..5) {
            screen[i][a] = column[i]
        }
    }

    fun printScreen() {
        println(screen.joinToString(separator = "\n") { it.joinToString("") { b -> if (b) "*" else " " } })
    }

    fun countLitPixels(): Int {
        return screen.sumBy { it.sumBy { if (it) 1 else 0 } }
    }


    fun interpet(lines: List<String>) {
        lines.forEach {
            if (rectRegex.matches(it)) {
                process(rectRegex, it, rect)
            } else if (rotateRowRgex.matches(it)) {
                process(rotateRowRgex, it, rotateRow)
            } else if (rotateColumnRegex.matches(it)) {
                process(rotateColumnRegex, it, rotateColumn)
            }
        }
    }

    private fun process(regex: Regex, input: String, func: (a: Int, b: Int) -> Unit) {
        regex.matchEntire(input)?.let { func(it.groups[1]!!.value.toInt(), it.groups[2]!!.value.toInt()) }


    }
}

