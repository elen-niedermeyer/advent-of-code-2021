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
}