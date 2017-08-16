import java.util.regex.Pattern

object Day7 {

    fun hasAbba(arg: CharSequence): Boolean {
        return (0..arg.length - 4).any { isAbba(arg.subSequence(it, it + 4)) }
    }

    fun isAbba(arg: CharSequence): Boolean {
        if (arg.length == 4) {
            val ab = arg.substring(0, 2)
            val ba = arg.substring(2, 4)
            return ab != ba && ab == ba.reversed()
        }
        return false
    }

    fun countTls(lines: List<String>): Int {
        return lines.fold(0, { acc, s ->
            if (isTls(s)) acc + 1 else acc
        })
    }

    fun countSsl(lines: List<String>): Int {
        return lines.fold(0, { acc, s ->
            if (isSsl(s)) acc + 1 else acc
        })
    }
    fun isTls(ip: String): Boolean {
        var b = true
        var hadAbba = false
        ip.split(Pattern.compile("(\\[|\\])")).forEach({
            if (b){
                if (!hadAbba) {
                    hadAbba = hasAbba(it)
                }
            } else {
                if (hasAbba(it)) {
                    return false
                }
            }
            b = !b
        })
        return hadAbba
    }


    fun isSsl(ip: String): Boolean {
        var b = true
        val abas = mutableSetOf<String>()
        val babs = mutableSetOf<String>()
        ip.split(Pattern.compile("(\\[|\\])")).forEach({
            if (b){
               abas.addAll(getAllAbas(it))
            } else {
               babs.addAll(toBab(getAllAbas(it)))
            }
            b = !b
        })
        return abas.removeAll(babs)
    }

    private fun toBab(abas: Collection<String>): Collection<String> {
        return abas.map { it.drop(1) + it.drop(1).take(1)  }
    }

    private fun getAllAbas(s: String): Collection<String> {
        return (0..s.length - 3)
                .map { s.substring(it, it + 3) }
                .filter { isAba(it) }
    }

    private fun isAba(s: CharSequence): Boolean {
        return s[0] == s[2] && s[0] != s[1]
    }


}



