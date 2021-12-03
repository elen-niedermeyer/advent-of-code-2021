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

    @Test
    fun testPuzzle03() {
        val exampleInput = mutableListOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val puzzleSolver = Puzzle03()

        val resultPower = puzzleSolver.getPowerConsumption(exampleInput)
        assertEquals(198, resultPower)

        val resultLifeSupport = puzzleSolver.getLifeSupportingRate(exampleInput)
        assertEquals(230, resultLifeSupport)
    }
}