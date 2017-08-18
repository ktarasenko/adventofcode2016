object Day10 {

    val botRegex = """bot (\d+) gives low to (bot|output) (\d+) and high to (bot|output) (\d+)""".toRegex()
    val valueRegex = """value (\d+) goes to bot (\d+)""".toRegex()


    fun process(list: Iterable<String>) {

        val botsMap = mutableMapOf<Int, Bot>()
        val outputMap = mutableMapOf<Int, Output>()
        fun createFun(type: String, number: Int): () -> Receiver = if (type == "bot") {
            { botsMap[number]!! }
        } else {
//            outputMap.put(number, Output(number))
//            { outputMap[number]!! }
            {Output(number)}
        }

        val lists = list.partition { it.startsWith("bot") }
        lists.first.forEach {
            botRegex.matchEntire(it)?.let {
                val botNumber = it.groupValues[1].toInt()
                val r1 = it.groupValues[2]
                val r1n = it.groupValues[3].toInt()
                val r2 = it.groupValues[4]
                val r2n = it.groupValues[5].toInt()
                botsMap.put(botNumber, Bot(botNumber, createFun(r1, r1n), createFun(r2, r2n)))
            }
        }
        lists.second.forEach({
            valueRegex.matchEntire(it)?.let {
                val botNumber = it.groupValues[2].toInt()
                val value = it.groupValues[1].toInt()
                botsMap[botNumber]!!.take(value)
            }
        })
    }


    class Bot(val num: Int ,val lowToFun: () -> Receiver, val highToNumb: () -> Receiver) : Receiver {

        val lowTo: Receiver by lazy { lowToFun.invoke() }
        val highTo: Receiver by lazy { highToNumb.invoke() }
        var low: Int = -1
        var high: Int = -1

        override fun take(value: Int) {
            if (low != -1) {
                val l = low
                low = Math.min(l, value)
                high = Math.max(l, value)
                give()
            } else {
                low = value
            }
        }

        private fun give() {
            println("bot ${num} processing ${low} and ${high}")
            lowTo.take(low)
            highTo.take(high)
        }
    }

    class Output(val num: Int) : Receiver {
        var v: Int = -1
        override fun take(value: Int) {
            println("output ${num} takes ${value}")
            v = value
        }

    }

    interface Receiver {
        fun take(value: Int)
    }


}
