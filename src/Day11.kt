import java.util.*
import kotlin.properties.Delegates

object Day11 {

    fun findStepsCount(expectedMax: Int, list: Iterable<String>): Int {
        val previousStates = mutableMapOf<Int, Int>()

        var minimumResult : Int by Delegates.observable(expectedMax){prop, old, new ->println(new)}

        fun search (root : State) {
            val newMove = root.allPossibleMoves()
                    .filter { it.isValid() && (!previousStates.contains(it.snapshot()) || previousStates[it.snapshot()]!! > it.step)}
                    .sortedByDescending { it.score() }
            newMove.find { it.isFinal() }?.let { minimumResult = Math.min(minimumResult, it.step) }
            newMove.forEach{
                previousStates.put(it.snapshot(), it.step)
            }
            if (root.step < minimumResult) {
                newMove.forEach { search(it) }
            }
        }
        val first = parseInput(list)
        previousStates.put(first.snapshot(), first.step)
        search(first)
        return minimumResult
    }

    fun findStepsCount1(list: Iterable<String>): Int {
        val previousStates = mutableSetOf<Int>()
        var lastMove = listOf(parseInput(list))

        while (true) {
            previousStates.addAll(lastMove.map { it.snapshot() })

            lastMove = lastMove.flatMap { it.allPossibleMoves() }
                    .filter { it.isValid() && !previousStates.contains(it.snapshot()) }

            lastMove.find { it.isFinal() }?.let { return it.step }
            if (lastMove.isEmpty()){
                return -1
            } else {
                println(lastMove.first().step)
            }

        }
    }



    fun parseInput(list: Iterable<String>): State =
            State(0, 0, list.map { parseFloor(it) }.toTypedArray())


    fun parseFloor(f: String): SortedSet<Component> {
        val set = TreeSet<Component>()
        val words = f.replace("[,.]".toRegex(), "").split(" ")
        words.forEachIndexed { index, s ->
            when (s) {
                "generator" -> set.add(Component("G", words[index - 1]))
                "microchip" -> set.add(Component("M", words[index - 1].replace("-compatible", "")))
            }
        }
        return set
    }


    class State(val step: Int, val elevatorPos: Int, val floors: Array<SortedSet<Component>>) {
        fun score() : Int = floors.mapIndexed{i, it ->  it.size * Math.pow(10.0, i.toDouble()).toInt()}.sum()
        fun snapshot(): Int =
                (floors.joinToString(separator = "|") { it.joinToString(separator = ",") } + elevatorPos).hashCode()

        fun allPossibleMoves(): Iterable<State> {
            val moves = mutableListOf<State>()
            if (elevatorPos < floors.size - 1) {
                moves.addAll(createMoves(elevatorPos, elevatorPos + 1))
            }
            if (elevatorPos > 0) {
                moves.addAll(createMoves(elevatorPos, elevatorPos - 1))
            }
            return moves
        }

        private fun cloneFloors(): Array<SortedSet<Component>> = Array(floors.size, { pos -> TreeSet(floors[pos]) })

        private fun createMoves(from: Int, to: Int): Collection<State> {
            return makeMoves(floors[from], floors[to]).map {
                val newFloors = cloneFloors()
                newFloors[from] = it.first
                newFloors[to] = it.second
                State(step + 1, to, newFloors)
            }
        }

        fun makeMoves(from: SortedSet<Component>,
                      to: SortedSet<Component>): Iterable<Pair<SortedSet<Component>, SortedSet<Component>>> {
            val list = mutableListOf<Pair<SortedSet<Component>, SortedSet<Component>>>()
            from.forEach{
                val newFrom = TreeSet(from)
                val newTo = TreeSet(to)
                newFrom.remove(it)
                newTo.add(it)
                list.add(Pair(newFrom, newTo))
            }
            val fromList = from.toList()
            for (i in 0 until fromList.size -1){
                val c = fromList[i]
                for (j in i+1 until fromList.size) {
                    val newFrom = TreeSet(from)
                    val newTo = TreeSet(to)
                    newFrom.remove(c)
                    newFrom.remove(fromList[j])
                    newTo.add(c)
                    newTo.add(fromList[j])
                    list.add(Pair(newFrom, newTo))
                }
            }

            return list
        }

        fun isValid(): Boolean = floors.fold(true, { acc, it -> acc && isFloorValid(it) })

        fun isFloorValid(f: SortedSet<Component>): Boolean {
            val nonDeactivatedComponentTypes = f.groupBy { it.material }
                    .filter { it.value.size == 1 }
                    .map { it.value.first().type }
                    .partition { it == "M" }
            return nonDeactivatedComponentTypes.first.isEmpty() ||
                    f.find { it.type == "G" } == null
        }

        fun isFinal(): Boolean = floors[3].isNotEmpty() && floors[0].isEmpty() && floors[1].isEmpty() && floors[2].isEmpty()

        override fun toString(): String {
            return "State(step=$step, elevatorPos=$elevatorPos, floors=${Arrays.toString(floors)}, snapshot=${snapshot()})"
        }
    }

    class Component(val type: String, val material: String) : Comparable<Component> {
        override fun compareTo(other: Component): Int =
                if (type == other.type) material.compareTo(other.material) else type.compareTo(other.type)

        override fun toString(): String {
            return "Component(type='$type', material='$material')"
        }

    }
}