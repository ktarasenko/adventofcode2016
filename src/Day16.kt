object Day16 {


    fun fillDisk(inp : String, targetLength : Int): String {
        var seq = inp
        while (seq.length < targetLength) seq = generateSequence(seq)
        return checksum(seq.take(targetLength))
    }

    fun generateSequence(inp: String): String {
        val a = inp
        val b = a.reversed().map {
            when (it) {
                '1' -> '0'
                '0' -> '1'
                else -> it
            }
        }.joinToString(separator = "")
        return "${a}0${b}"
    }

    fun checksum(inp: String): String {
        println("inp length ${inp.length}")
        var sum = subChecksum(inp)
        while (sum.length % 2 == 0) {
            println("checksum length ${sum.length}")
            sum = subChecksum(sum)
        }
        return sum
    }

    private fun subChecksum(inp: String): String {
        return if (inp.length % 2 == 0) {
            var s = inp
            var res = StringBuilder()
            var i = 0
            while (i < s.length){
                res.append(if (s[i] == s[i+1]) "1" else "0")
                i += 2
            }
            res.toString()
        } else {
            inp
        }

    }
}