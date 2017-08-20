import java.util.*

object Day19 {


    fun elvesProblem(amount : Int): Int{
        var elves = (1..amount).toList()
        while (elves.size > 1){
            val s = elves.size
            elves = elves.filterIndexed({ i, _ -> i % 2 == 0 })
            if (s % 2 == 1){
                elves = elves.drop(1)
            }
        }
        return elves.first()
    }

    fun elvesProblem2(amount: Int): Int {
        val elves = (1..amount).toMutableList()
        var pos = 0
        while (elves.size > 1){
            val s = elves.size
            val k = (pos + s/2)% s
            if (s % 10000 == 0) println(s)
            elves.removeAt(k)
            pos = (if (k > pos) pos +1 else pos)%elves.size
        }
        return elves.first()
    }
}