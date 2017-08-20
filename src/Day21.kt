object Day21 {


    fun findPassword(phrase: String, list : Iterable<String>) : String{
        val s  = StringBuilder(phrase)
        list.forEach{
            doCommand(s, it)
            println("$it - $s")
        }
        return s.toString()
    }

    fun unscramble(pass: String, list : Iterable<String>) : String{
        val s  = StringBuilder(pass)
        list.reversed().forEach{
            println("$it - $s")
            doCommandReversed(s, it)
        }
        return s.toString()
    }

    fun doCommandReversed(s: StringBuilder, cmd: String) {
        val cmdSplit = cmd.split(" ")
        when (cmdSplit[0]){
            "swap" -> when (cmdSplit[1]){
                "position" -> s.swap(cmdSplit[2].toInt(), cmdSplit[5].toInt())
                "letter" -> s.swap(s.indexOf(cmdSplit[2]), s.indexOf(cmdSplit[5]))
            }
            "rotate"-> when (cmdSplit[1]){
                "based" -> s.rotate(false, rotateBasedCountRev(s.indexOf(cmdSplit[6]),s.length))
                else -> s.rotate(cmdSplit[1] == "left", cmdSplit[2].toInt())
            }
            "reverse" -> s.reverse(cmdSplit[2].toInt()..cmdSplit[4].toInt())
            "move" -> s.move(cmdSplit[5].toInt(), cmdSplit[2].toInt())

        }
    }

    fun doCommand(s : StringBuilder, cmd : String){
        val cmdSplit = cmd.split(" ")
        when (cmdSplit[0]){
            "swap" -> when (cmdSplit[1]){
                "position" -> s.swap(cmdSplit[2].toInt(), cmdSplit[5].toInt())
                "letter" -> s.swap(s.indexOf(cmdSplit[2]), s.indexOf(cmdSplit[5]))
            }
            "rotate"-> when (cmdSplit[1]){
                "based" -> s.rotate(true, rotateBasedCount(s.indexOf(cmdSplit[6])))
                else -> s.rotate(cmdSplit[1] == "right", cmdSplit[2].toInt())
            }
            "reverse" -> s.reverse(cmdSplit[2].toInt()..cmdSplit[4].toInt())
            "move" -> s.move(cmdSplit[2].toInt(), cmdSplit[5].toInt())

        }
    }

    private fun rotateBasedCount(ind: Int): Int = when {
                ind >= 4 -> ind + 2
                else -> ind + 1
            }

    private fun rotateBasedCountRev(ind: Int, size: Int): Int = when {
                ind % 2 == 1 -> ind/2 + 1
                else -> {
                    var a = ind -2
                    while (a < size) a += size
                    a/2 + 2
                }
            }


    private fun StringBuilder.swap(x: Int, y: Int){
        val c = this[y]
        this[y] = this[x]
        this[x] = c
    }

    private fun StringBuilder.rotate(right: Boolean, steps: Int) {
        val steps = steps % this.length
        if (right) {
            val s = this.subSequence(this.length - steps, this.length)
            this.delete(this.length - steps, this.length)
            this.insert(0, s)
        } else {
            val s = this.subSequence(0, steps)
            this.delete(0, steps)
            this.append(s)

        }
    }


    private fun StringBuilder.reverse(intRange: IntRange) {
       this.replace(intRange.start, intRange.endInclusive+1, this.subSequence(intRange).reversed().toString())
    }


    private fun StringBuilder.move(from: Int, to: Int) {
        val c = this[from]
        this.deleteCharAt(from)
        this.insert(to, c)
    }

}

