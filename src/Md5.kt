import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


private val DIGITS_LOWER = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')


private fun countMd5(input: String): String {
    return String(hex(getDigest().digest(input.toByteArray())))
}

private fun hex(data: ByteArray): CharArray {
    val l = data.size
    val out = CharArray(l shl 1)
    var i = 0
    var j = 0
    while (i < l) {
        out[j++] = DIGITS_LOWER[(240 and data[i].toInt()).ushr(4)]
        out[j++] = DIGITS_LOWER[15 and data[i].toInt()]
        i++
    }
    return out
}

private fun getDigest(): MessageDigest {
    try {
        return MessageDigest.getInstance("MD5")
    } catch (e: NoSuchAlgorithmException) {
        throw IllegalArgumentException(e)
    }
}

fun String.md5(): String = countMd5(this)
