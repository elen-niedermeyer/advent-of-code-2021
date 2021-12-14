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

}