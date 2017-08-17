object Day9 {

    private val decompress = """\((?<a>\d+)x(?<b>\d+)\)""".toRegex()


    fun decode(input: String): CharSequence {
        val result = StringBuilder()
        val source = StringBuilder(input)

        var i = 0
        while (i < source.length) {
            val open = source.indexOf("(", i)
            val closing = source.indexOf(")", i)
            if (open > -1) {
                result.append(source.substring(i, open))
                i = closing + 1

                decompress.matchEntire(source.substring(open..closing))?.let {
                    val count = it.groups[1]!!.value.toInt()
                    val times = it.groups[2]!!.value.toInt()
                    result.append(source.substring(i, i + count).repeat(times))
                    i += count
                }
            } else {
                break
            }
        }
        result.append(source.substring(i))
        return result.toString()
    }


    fun decodeOnlyCount(input: String): Int {
        val source = StringBuilder(input)
        var l = 0

        var i = 0
        while (i < source.length) {
            val open = source.indexOf("(", i)
            val closing = source.indexOf(")", i)
            if (open > -1) {
                l += open - i
                i = closing + 1

                decompress.matchEntire(source.substring(open..closing))?.let {
                    val count = it.groups[1]!!.value.toInt()
                    val times = it.groups[2]!!.value.toInt()
                    l += count * times
                    i += count
                }
            } else {
                break
            }
        }
        l += source.length - i
        return l
    }

    fun decodeCountV2(input: String): Long {

        var l = 0L
        val source = StringBuilder(input)


        var i = 0
        while (i < source.length) {
            val open = source.indexOf("(", i)
            val closing = source.indexOf(")", i)
            if (open > -1) {
                l += open - i
                i = closing + 1

                decompress.matchEntire(source.substring(open..closing))?.let {
                    val count = it.groups[1]!!.value.toInt()
                    val times = it.groups[2]!!.value.toInt()
                    l += decodeCountV2(source.substring(i, i + count)) * times
                    i += count
                }
            } else {
                break
            }

        }
        l += source.length - i
        return l
    }


}