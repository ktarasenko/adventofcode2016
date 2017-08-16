import java.util.regex.Pattern

object Day6 {

    fun decode(list: Iterable<String>) : String {

        val allLetters = list.flatMap { it.toList().mapIndexed { index, c ->  Pair(index, c)}}
        val lettersOnPositions =  allLetters.groupBy({it.first}, {it.second}).map { it.value }
        val mostOftenLetters = lettersOnPositions.map { it.groupingBy { it }.eachCount().maxBy { it.value } }
        val result = mostOftenLetters.joinToString(separator = ""){it?.key.toString()}
        return result
    }

    fun decode2(list: Iterable<String>) : String {

        val allLetters = list.flatMap { it.toList().mapIndexed { index, c ->  Pair(index, c)}}
        val lettersOnPositions =  allLetters.groupBy({it.first}, {it.second}).map { it.value }
        val leastOftenLetters = lettersOnPositions.map { it.groupingBy { it }.eachCount().minBy { it.value } }
        val result = leastOftenLetters.joinToString(separator = ""){it?.key.toString()}
        return result
    }


}