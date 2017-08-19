import sun.security.provider.MD5
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object Day5 {

    fun findPassword1(roomCode: String): String {
        return Md5Generator1(roomCode).take(8).joinToString(separator = "")
    }

    fun findPassword2(roomCode: String): String {
        return Md5Generator2(roomCode).calculateCode()
    }



    class Md5Generator1(val code: String) : Sequence<Char> {
        override fun iterator(): Iterator<Char> = object : Iterator<Char> {
            var currentInt = 0

            override fun next(): Char {
                while (true) {
                    val md5 = (code + currentInt).md5()
                    currentInt++
                    if (md5.startsWith("00000")) {
                        return md5.elementAt(5)
                    }
                }
            }


            override fun hasNext(): Boolean {
                return true
            }
        }
    }

    class Md5Generator2(val code: String) {
        var currentInt = 0

        val result = arrayOf('q', 'q', 'q', 'q' ,'q', 'q', 'q', 'q')
        var itemsToGo = 8

        fun calculateCode(): String {
            while (itemsToGo > 0) {
                val md5 = (code + currentInt).md5()
                currentInt++
                if (md5.startsWith("00000")) {
                    val pos =  (md5.elementAt(5)).toString().toIntOrNull()
                    if (pos != null && pos < 8 && result[pos] == 'q'){
                        result[pos] = md5.elementAt(6)
                        println(result.joinToString())
                        itemsToGo--
                    }
                }
            }

            return result.joinToString(separator = "")
        }

    }

}
