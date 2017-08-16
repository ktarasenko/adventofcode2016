import org.junit.Assert.*
import org.junit.Test
import java.io.File

class Day6Test{
    @Test
    fun provided() {
        assertEquals("easter", Day6.decode(("eedadn\n" +
                "drvtee\n" +
                "eandsr\n" +
                "raavrd\n" +
                "atevrs\n" +
                "tsrnev\n" +
                "sdttsa\n" +
                "rasrtv\n" +
                "nssdts\n" +
                "ntnada\n" +
                "svetve\n" +
                "tesnvt\n" +
                "vntsnd\n" +
                "vrdear\n" +
                "dvrsen\n" +
                "enarar").split("\n")))
    }

   @Test
    fun provided2() {
        assertEquals("advent", Day6.decode2(("eedadn\n" +
                "drvtee\n" +
                "eandsr\n" +
                "raavrd\n" +
                "atevrs\n" +
                "tsrnev\n" +
                "sdttsa\n" +
                "rasrtv\n" +
                "nssdts\n" +
                "ntnada\n" +
                "svetve\n" +
                "tesnvt\n" +
                "vntsnd\n" +
                "vrdear\n" +
                "dvrsen\n" +
                "enarar").split("\n")))
    }

    @Test
    fun task() {
        assertEquals("mshjnduc", Day6.decode(File("input/day6.txt").readLines()))
    }

    @Test
    fun task2() {
        assertEquals("apfeeebz", Day6.decode2(File("input/day6.txt").readLines()))
    }
}