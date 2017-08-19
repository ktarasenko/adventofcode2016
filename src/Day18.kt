object Day18 {



    fun generateRowsAndSafeTiles(firstRow : String, rows: Int): Long {
        var row =  firstRow.map {it == '^'}
        var safeTiles : Long = 0L + row.count { !it }
        for (i in 1 until rows){
            row = createNextRow(row)
            safeTiles += row.count{!it}
        }
        return safeTiles
    }


    fun createNextRow(prevRow: List<Boolean>): List<Boolean> =
        prevRow.mapIndexed { i, _ ->
            val left = prevRow.getOrElse(i - 1, { false })
            val right = prevRow.getOrElse(i + 1, { false })
            (left xor right)
        }
}