object Day14 {

    val groupOf3Regex = """.*([\d,a-f])\1{2}.*""".toRegex()

    fun getGroupOf5Regex(c: Char) = """.*([${c}])\1{4}.*""".toRegex()

    val simpleMd5: (String) -> String = { it.md5() }
    val strechedMd5: (String) -> String = { md5Times(it, 2017) }

    val hashesCache = ArrayList<String>()

    private fun md5Times(s: String, times: Int): String {
        return if (times > 0) {
            md5Times(s.md5(), times - 1)
        } else {
            s
        }
    }

    fun countMd5(salt: String, hash: (String) -> String): Int {
        hashesCache.clear()
        val iter = Md5Iterator(salt = salt, hash = hash, predicate = { i, s ->
            isValidKey(s, i, salt, hash)
        })
        iter.take(64).forEach { println(it) }
        return iter.geCurrentInt()
    }

    fun isValidKey(value: String, index: Int, salt: String, hash: (String) -> String): Boolean {
        val c = repeats3Times(value)
        return if (c != null) {
            Md5Iterator(index, index + 1000, hash, salt, { _, ss ->
                repeats5Times(ss, c)
            }).filter { it.first > -1 }.firstOrNull() != null
        } else {
            false
        }
    }

    private fun repeats5Times(s: String, c: Char): Boolean {
        var repeatedChar = c
        var seqLength = 0
        for (i in 0 until s.length) {
            if (s[i] == repeatedChar) {
                seqLength++
            } else {
                seqLength = 0
            }
            if (seqLength == 5) {
                return true
            }
        }
        return false
    }

    private fun repeats3Times(s: String): Char? {
        var repeatedChar = s[0]
        var seqLength = 1
        for (i in 1 until s.length) {
            if (s[i] == repeatedChar) {
                seqLength++
            } else {
                seqLength = 1
                repeatedChar = s[i]
            }
            if (seqLength == 3) {
                return repeatedChar
            }
        }
        return null
    }

    class Md5Iterator(start: Int = -1, val finish: Int = Int.MAX_VALUE,
                      val hash: (String) -> String,
                      val salt: String,
                      val predicate: (Int, String) -> Boolean) : Sequence<Pair<Int, String>> {
        private var currentInt = start

        override fun iterator() = object : Iterator<Pair<Int, String>> {

            override fun next(): Pair<Int, String> {
                while (hasNext()) {
                    currentInt++
                    var hashedValue = hashesCache.getOrNull(currentInt)
                    if (hashedValue == null) {
                        hashedValue = hash(salt + currentInt)
                        hashesCache.add(hashedValue)
                    }
                    if (predicate(currentInt, hashedValue)) {
                        return Pair(currentInt, hashedValue)
                    }
                }
                return Pair(-1, "")
            }


            override fun hasNext(): Boolean {
                return currentInt < finish
            }
        }

        fun geCurrentInt(): Int = currentInt
    }
}

