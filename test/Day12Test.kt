import org.junit.Assert.*
import org.junit.Test

class Day12Test{
    @Test
    fun provided() {
       assertEquals(42, Day12.solve(("cpy 41 a\n" +
               "inc a\n" +
               "inc a\n" +
               "dec a\n" +
               "jnz a 2\n" +
               "dec a").split("\n")))
    }

    @Test
    fun task1() {
        assertEquals(42, Day12.solve(("cpy 1 a\n" +
                "cpy 1 b\n" +
                "cpy 26 d\n" +
                "jnz c 2\n" +
                "jnz 1 5\n" +
                "cpy 7 c\n" +
                "inc d\n" +
                "dec c\n" +
                "jnz c -2\n" +
                "cpy a c\n" +
                "inc a\n" +
                "dec b\n" +
                "jnz b -2\n" +
                "cpy c b\n" +
                "dec d\n" +
                "jnz d -6\n" +
                "cpy 17 c\n" +
                "cpy 18 d\n" +
                "inc a\n" +
                "dec d\n" +
                "jnz d -2\n" +
                "dec c\n" +
                "jnz c -5").split("\n")))
    }
}