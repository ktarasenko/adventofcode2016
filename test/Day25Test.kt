import org.junit.Assert.*
import org.junit.Test

class Day25Test{

    @Test
    fun task(){
        assertEquals(158, Day25.solve(("cpy a d\n" +
                "cpy 4 c\n" +
                "cpy 643 b\n" +
                "inc d\n" +
                "dec b\n" +
                "jnz b -2\n" +
                "dec c\n" +
                "jnz c -5\n" +
                "cpy d a\n" +
                "jnz 0 0\n" +
                "cpy a b\n" +
                "cpy 0 a\n" +
                "cpy 2 c\n" +
                "jnz b 2\n" +
                "jnz 1 6\n" +
                "dec b\n" +
                "dec c\n" +
                "jnz c -4\n" +
                "inc a\n" +
                "jnz 1 -7\n" +
                "cpy 2 b\n" +
                "jnz c 2\n" +
                "jnz 1 4\n" +
                "dec b\n" +
                "dec c\n" +
                "jnz 1 -4\n" +
                "jnz 0 0\n" +
                "out b\n" +
                "jnz a -19\n" +
                "jnz 1 -21").split("\n")))
    }
}