import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day21Test{


    @Test
    fun simple() {
        assertEquals("abdec", Day21.findPassword("abcde", ("swap position 4 with position 0\n" +
                "swap letter d with letter b\n" +
                "reverse positions 0 through 4\n" +
                "rotate left 1 step\n" +
                "move position 1 to position 4\n" +
                "move position 3 to position 0").split("\n")))
    }

    @Test
    fun simple2() {
        assertEquals("abcde", Day21.unscramble("abdec", ("swap position 4 with position 0\n" +
                "swap letter d with letter b\n" +
                "reverse positions 0 through 4\n" +
                "rotate left 1 step\n" +
                "move position 1 to position 4\n" +
                "move position 3 to position 0").split("\n")))
    }

    @Test
    fun provided() {
        assertEquals("decab", Day21.findPassword("abcde", ("swap position 4 with position 0\n" +
                "swap letter d with letter b\n" +
                "reverse positions 0 through 4\n" +
                "rotate left 1 step\n" +
                "move position 1 to position 4\n" +
                "move position 3 to position 0\n" +
                "rotate based on position of letter b\n" +
                "rotate based on position of letter d").split("\n")))
    }

    @Test
    fun provided2() {
        assertEquals("abcde", Day21.unscramble("decab", ("swap position 4 with position 0\n" +
                "swap letter d with letter b\n" +
                "reverse positions 0 through 4\n" +
                "rotate left 1 step\n" +
                "move position 1 to position 4\n" +
                "move position 3 to position 0\n" +
                "rotate based on position of letter b\n" +
                "rotate based on position of letter d").split("\n")))
    }

    @Test
    fun findBug() {
        val phrase = "abcdefgh"
        val s = StringBuilder("abcdefgh")
        File("input/day21.txt").readLines().forEach {
            Day21.doCommand(s, it)
            Day21.doCommandReversed(s, it)
            assertEquals(it, phrase, s.toString())
        }
    }


    @Test
    fun provided3() {
        assertEquals("abcdefgh", Day21.unscramble("dgfaehcb", File("input/day21.txt").readLines()))
    }

    @Test
    fun task() {
        assertEquals("dgfaehcb", Day21.findPassword("abcdefgh", File("input/day21.txt").readLines()))
    }

    @Test
    fun task2() {
        assertEquals("fdhgacbe", Day21.unscramble("fbgdceah", File("input/day21.txt").readLines()))
    }
}