object Day20 {


    fun findLowestNumberAllowed(list : Iterable<String>): Long {
        var min = 0L
        list.map { parseRange(it) }.sortedBy { it.first }.forEach({
            if (it.first > min){
                return min
            } else {
                min = it.last+1
            }
        })
        return -1
    }

    fun countAllowed(list : Iterable<String>, max : Long): Long {
        var ip = 0L
        var count = 0L
        list.map { parseRange(it) }.sortedBy { it.first }.forEach({
            if (it.first > ip){
                count += (it.first - ip)
            }
            if (it.last >= ip) {
                ip = it.last + 1
            }
        })
        return count + (max - ip + 1)
    }

    private fun parseRange(r: String): LongRange {
        val a = r.split("-")
        return a[0].toLong()..a[1].toLong()
    }




}