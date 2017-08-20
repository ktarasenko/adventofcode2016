import org.junit.Assert.*
import org.junit.Test

class Day23Test{


    @Test
    fun provided(){
        assertEquals(3, Day23.solve(("cpy 2 a\n" +
                "tgl a\n" +
                "tgl a\n" +
                "tgl a\n" +
                "cpy 1 a\n" +
                "dec a\n" +
                "dec a").split("\n")))
    }

    @Test
    fun task(){
        assertEquals(11975, Day23.solve(("cpy a b\n" +
                "dec b\n" +
                "cpy a d\n" +
                "cpy 0 a\n" +
                "cpy b c\n" +
                "inc a\n" +
                "dec c\n" +
                "jnz c -2\n" +
                "dec d\n" +
                "jnz d -5\n" +
                "dec b\n" +
                "cpy b c\n" +
                "cpy c d\n" +
                "dec d\n" +
                "inc c\n" +
                "jnz d -2\n" +
                "tgl c\n" +
                "cpy -16 c\n" +
                "jnz 1 c\n" +
                "cpy 95 c\n" +
                "jnz 73 d\n" +
                "inc a\n" +
                "inc d\n" +
                "jnz d -2\n" +
                "inc c\n" +
                "jnz c -5").split("\n")))
    }
}