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
            Pair("forward", 5),
            Pair("down", 5),
            Pair("forward", 8),
            Pair("up", 3),
            Pair("down", 8),
            Pair("forward", 2)
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

    @Test
    fun testPuzzle04() {
        val exampleNumbers =
            intArrayOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
        val exampleBoards = listOf(
            Puzzle04Board(
                intArrayOf(
                    22, 13, 17, 11, 0,
                    8, 2, 23, 4, 24,
                    21, 9, 14, 16, 7,
                    6, 10, 3, 18, 5,
                    1, 12, 20, 15, 19
                ),
                5
            ),
            Puzzle04Board(
                intArrayOf(
                    3, 15, 0, 2, 22,
                    9, 18, 13, 17, 5,
                    19, 8, 7, 25, 23,
                    20, 11, 10, 24, 4,
                    14, 21, 16, 12, 6
                ),
                5
            ),
            Puzzle04Board(
                intArrayOf(
                    14, 21, 17, 24, 4,
                    10, 16, 15, 9, 19,
                    18, 8, 23, 26, 20,
                    22, 11, 13, 6, 5,
                    2, 0, 12, 3, 7
                ),
                5
            )
        )
        val puzzleSolver = Puzzle04()

        val winningResult = puzzleSolver.getFirstWinningBoard(exampleNumbers, exampleBoards)
        assertEquals(4512, winningResult)

        val losingResult = puzzleSolver.getLastWinningBoard(exampleNumbers, exampleBoards)
        assertEquals(1924, losingResult)
    }

    @Test
    fun testPuzzle05() {
        val exampleInput = mutableListOf(
            intArrayOf(0, 9, 5, 9),
            intArrayOf(8, 0, 0, 8),
            intArrayOf(9, 4, 3, 4),
            intArrayOf(2, 2, 2, 1),
            intArrayOf(7, 0, 7, 4),
            intArrayOf(6, 4, 2, 0),
            intArrayOf(0, 9, 2, 9),
            intArrayOf(3, 4, 1, 4),
            intArrayOf(0, 0, 8, 8),
            intArrayOf(5, 5, 8, 2)
        )
        val puzzleSolver = Puzzle05()

        val result = puzzleSolver.getHorizontalAndVerticalOverlappingPoints(exampleInput)
        assertEquals(5, result)

        val resultAll = puzzleSolver.getAllOverlappingPoints(exampleInput)
        assertEquals(12, resultAll)
    }

    @Test
    fun testPuzzle06() {
        val exampleInput = listOf(
            3, 4, 3, 1, 2
        )
        val puzzleSolver = Puzzle06()

        val result = puzzleSolver.getNumberOfFishes(exampleInput, 80)
        assertEquals(5934, result)

        val result2 = puzzleSolver.getNumberOfFishes(exampleInput, 256)
        assertEquals(26984457539, result2)
    }

    @Test
    fun testPuzzle07() {
        val exampleInput = intArrayOf(
            16, 1, 2, 0, 4, 2, 7, 1, 2, 14
        )
        val puzzleSolver = Puzzle07()

        val result1 = puzzleSolver.getMinimumConstantFuelUsage(exampleInput)
        assertEquals(37, result1)

        val result2 = puzzleSolver.getMinimumIncreasingFuelUsage(exampleInput)
        assertEquals(168, result2)
    }

}