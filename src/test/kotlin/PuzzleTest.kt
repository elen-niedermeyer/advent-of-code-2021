import kotlin.test.Test
import kotlin.test.assertEquals

class PuzzleTest {

    @Test
    fun testPuzzle01() {
        val exampleInput = intArrayOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val puzzleSolver = Puzzle01()

        val result = puzzleSolver.countIncreasements(exampleInput)
        assertEquals(7, result)

        val resultWindows = puzzleSolver.countWindowIncreasements(exampleInput)
        assertEquals(5, resultWindows)
    }

    @Test
    fun testPuzzle02() {
        val exampleInput = arrayOf(
            Puzzle02Element("forward", 5),
            Puzzle02Element("down", 5),
            Puzzle02Element("forward", 8),
            Puzzle02Element("up", 3),
            Puzzle02Element("down", 8),
            Puzzle02Element("forward", 2)
        )
        val puzzleSolver = Puzzle02()

        val result = puzzleSolver.getPositionProduct(exampleInput)
        assertEquals(150, result)

        val resultAim = puzzleSolver.getAimPositionProduct(exampleInput)
        assertEquals(900, resultAim)
    }
}