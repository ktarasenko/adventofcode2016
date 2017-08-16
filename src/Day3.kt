import java.util.regex.Pattern

object Day3 {

    fun countTriangles(list: Iterable<String>) : Int {
        var count = 0
        for (values in list){
            //language=RegExp
            if (isTriangle( values.trim().split(Pattern.compile("\\s+")).map { it.toInt() })){
                count++
            }
        }

        return count
    }


    fun countTrianglesColumns(list: Iterable<String>) : Int {
        var count = 0
        var rows = 0
        var array : Array<IntArray> = emptyArray()
        for (values in list){
            array = array.plus(values.trim().split(Pattern.compile("\\s+")).map { it.toInt() }.toIntArray())
            rows++
            if (rows == 3){
                rows = 0
                count = triangleInColumns(array, count)
                array = emptyArray()
            }
        }

        return count
    }

    private fun triangleInColumns(array: Array<IntArray>, count: Int): Int {
        var count1 = count
        for (i in 0..2) {
            if (isTriangle(listOf(array[0][i], array[1][i], array[2][i]))) {
                count1++
            }
        }
        return count1
    }

    private fun isTriangle(v : List<Int>): Boolean {
        return (v.size == 3)
                && (v.get(0) + v.get(1) > v.get(2))
                    && (v.get(0) + v.get(2) > v.get(1))
                    && (v.get(1) + v.get(2) > v.get(0))

    }

}