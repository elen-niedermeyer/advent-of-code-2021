import io.mockk.every
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleTest {

    @Test
    fun testPuzzle01() {
        val puzzleSolver = puzzle01.Puzzle()

        assertEquals(7, puzzleSolver.solvePart1())
        assertEquals(5, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle02() {
        val puzzleSolver = puzzle02.Puzzle()

        assertEquals(150, puzzleSolver.solvePart1())
        assertEquals(900, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle03() {
        val puzzleSolver = puzzle03.Puzzle()

        assertEquals(198, puzzleSolver.solvePart1())
        assertEquals(230, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle04() {
        val puzzleSolver = puzzle04.Puzzle()

        assertEquals(4512, puzzleSolver.solvePart1())
        assertEquals(1924, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle05() {
        val puzzleSolver = puzzle05.Puzzle()

        assertEquals(5, puzzleSolver.solvePart1())
        assertEquals(12, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle06() {
        val puzzleSolver = puzzle06.Puzzle()

        assertEquals(5934, puzzleSolver.solvePart1())
        assertEquals(26984457539, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle07() {
        val puzzleSolver = puzzle07.Puzzle()

        assertEquals(37, puzzleSolver.solvePart1())
        assertEquals(168, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle08() {
        val puzzleSolver = puzzle08.Puzzle()

        assertEquals(26, puzzleSolver.solvePart1())
        assertEquals(61229, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle09() {
        val puzzleSolver = puzzle09.Puzzle()

        assertEquals(15, puzzleSolver.solvePart1())
        assertEquals(1134, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle10() {
        val puzzleSolver = puzzle10.Puzzle()

        assertEquals(26397, puzzleSolver.solvePart1())
        assertEquals(288957, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle11() {
        val puzzleSolver = puzzle11.Puzzle()

        assertEquals(1656, puzzleSolver.solvePart1())
        assertEquals(195, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle12() {
        val puzzleSolver = puzzle12.Puzzle()

        assertEquals(226, puzzleSolver.solvePart1())
        assertEquals(3509, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle13() {
        val puzzleSolver = puzzle13.Puzzle()

        assertEquals(17, puzzleSolver.solvePart1())
        assertEquals(null, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle14() {
        val puzzleSolver = puzzle14.Puzzle()

        assertEquals(1588, puzzleSolver.solvePart1())
        assertEquals(2188189693529, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle15() {
        val puzzleSolver = puzzle15.Puzzle()

        assertEquals(40, puzzleSolver.solvePart1())
        assertEquals(315, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle16() {

        val puzzleSolver = mockk<puzzle16.Puzzle>()
        every { puzzleSolver["readInput"]() } returnsMany listOf(
            readLines("puzzle16-1-1.txt")[0],
            readLines("puzzle16-1-2.txt")[0],
            readLines("puzzle16-1-3.txt")[0],
            readLines("puzzle16-1-4.txt")[0],
            readLines("puzzle16-2-1.txt")[0],
            readLines("puzzle16-2-2.txt")[0],
            readLines("puzzle16-2-3.txt")[0],
            readLines("puzzle16-2-4.txt")[0],
            readLines("puzzle16-2-5.txt")[0],
            readLines("puzzle16-2-6.txt")[0],
            readLines("puzzle16-2-7.txt")[0],
            readLines("puzzle16-2-8.txt")[0],
            readLines("puzzle16-2-9.txt")[0],
        )
        every { puzzleSolver.solvePart1() } answers { callOriginal() }
        every { puzzleSolver.solvePart2() } answers { callOriginal() }
        every { puzzleSolver["getInput"]() } answers { callOriginal() }
        every { puzzleSolver["convertToBinary"](any<String>()) } answers { callOriginal() }

        assertEquals(16, puzzleSolver.solvePart1())
        assertEquals(12, puzzleSolver.solvePart1())
        assertEquals(23, puzzleSolver.solvePart1())
        assertEquals(31, puzzleSolver.solvePart1())
        assertEquals(3, puzzleSolver.solvePart2())
        assertEquals(54, puzzleSolver.solvePart2())
        assertEquals(7, puzzleSolver.solvePart2())
        assertEquals(9, puzzleSolver.solvePart2())
        assertEquals(1, puzzleSolver.solvePart2())
        assertEquals(0, puzzleSolver.solvePart2())
        assertEquals(0, puzzleSolver.solvePart2())
        assertEquals(1, puzzleSolver.solvePart2())
        assertEquals(2021, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle17() {
        val puzzleSolver = puzzle17.Puzzle()

        assertEquals(45, puzzleSolver.solvePart1())
        assertEquals(112, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle18() {
        val puzzleSolver = puzzle18.Puzzle()

        assertEquals(4140, puzzleSolver.solvePart1())
        assertEquals(3993, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle20() {
        val puzzleSolver = puzzle20.Puzzle()

        assertEquals(35, puzzleSolver.solvePart1())
        assertEquals(3351, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle21() {
        val puzzleSolver = puzzle21.Puzzle()

        assertEquals(739785, puzzleSolver.solvePart1())
        assertEquals(444356092776315, puzzleSolver.solvePart2())
    }

    @Test
    fun testPuzzle22() {

        val puzzleSolver = mockk<puzzle22.Puzzle>()
        every { puzzleSolver["readInput"]() } returnsMany listOf(
            readLines("puzzle22-1.txt"),
            readLines("puzzle22-2.txt"),
            readLines("puzzle22-3.txt"),
            readLines("puzzle22-3.txt"),
        )
        every { puzzleSolver.solvePart1() } answers { callOriginal() }
        every { puzzleSolver.solvePart2() } answers { callOriginal() }

        assertEquals(39, puzzleSolver.solvePart1())
        assertEquals(590784, puzzleSolver.solvePart1())
        assertEquals(474140, puzzleSolver.solvePart1())
        assertEquals(2758514936282235, puzzleSolver.solvePart2())
    }

}