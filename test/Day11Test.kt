import org.junit.Assert.assertEquals
import org.junit.Test

class Day11Test{
    @Test
    fun parsingInput() {
       println(Day11.parseInput(("The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.\n" +
               "The second floor contains a hydrogen generator.\n" +
               "The third floor contains a lithium generator.\n" +
               "The fourth floor contains nothing relevant.").split("\n")))
    }

    @Test
    fun simple(){
        assertEquals(3, Day11.findStepsCount(10, ("The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.\n" +
                "The second floor contains nothing relevant.\n" +
                "The third floor contains nothing relevant.\n" +
                "The fourth floor contains nothing relevant.").split("\n")))
    }

    @Test
    fun simple2(){
        assertEquals(3, Day11.findStepsCount(10, ("The first floor contains a hydrogen-compatible microchip.\n" +
                "The second floor contains nothing relevant.\n" +
                "The third floor contains nothing relevant.\n" +
                "The fourth floor contains lithium-compatible microchip.").split("\n")))
    }

    @Test
    fun provided(){
        assertEquals(11, Day11.findStepsCount(20, ("The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.\n" +
                "The second floor contains a hydrogen generator.\n" +
                "The third floor contains a lithium generator.\n" +
                "The fourth floor contains nothing relevant.").split("\n")))
    }

    @Test
    fun sample2(){
        assertEquals(27, Day11.findStepsCount(30, ("The first floor contains a promethium generator and a promethium-compatible microchip, An elerium generator. " +
                "An elerium-compatible microchip. " +
                "A dilithium generator. " +
                "A dilithium-compatible microchip.\n" +
                "The second floor contains nothing relevant.\n" +
                "The third floor contains nothing relevant.\n" +
                "The fourth floor contains nothing relevant.").split("\n")))

    }

    @Test
    fun task(){
        assertEquals(33, Day11.findStepsCount(40, ("The first floor contains a promethium generator and a promethium-compatible microchip, .\n" +
                "The second floor contains a cobalt generator, a curium generator, a ruthenium generator, and a plutonium generator.\n" +
                "The third floor contains a cobalt-compatible microchip, a curium-compatible microchip, a ruthenium-compatible microchip, and a plutonium-compatible microchip.\n" +
                "The fourth floor contains nothing relevant.").split("\n")))
    }

    @Test
    fun task2(){
        assertEquals(57, Day11.findStepsCount(60, ("The first floor contains a promethium generator and a promethium-compatible microchip, An elerium generator. " +
                "An elerium-compatible microchip. " +
                "A dilithium generator. " +
                "A dilithium-compatible microchip.\n" +
                "The second floor contains a cobalt generator, a curium generator, a ruthenium generator, and a plutonium generator.\n" +
                "The third floor contains a cobalt-compatible microchip, a curium-compatible microchip, a ruthenium-compatible microchip, and a plutonium-compatible microchip.\n" +
                "The fourth floor contains nothing relevant.").split("\n")))
    }
}