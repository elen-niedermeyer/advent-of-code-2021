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

    @Test
    fun testPuzzle08() {
        val exampleSegmentOutput = listOf(
            listOf("fdgacbe", "cefdb", "cefbgd", "gcbe"),
            listOf("fcgedb", "cgb", "dgebacf", "gc"),
            listOf("cg", "cg", "fdcagb", "cbg"),
            listOf("efabcd", "cedba", "gadfec", "cb"),
            listOf("gecf", "egdcabf", "bgf", "bfgea"),
            listOf("gebdcfa", "ecba", "ca", "fadegcb"),
            listOf("cefg", "dcbef", "fcge", "gbcadfe"),
            listOf("ed", "bcgafe", "cdgba", "cbgef"),
            listOf("gbdfcae", "bgc", "cg", "cgb"),
            listOf("fgae", "cfgab", "fg", "bagce"),
        )
        val exampleSignals = listOf(
            listOf("be", "cfbegad", "cbdgef", "fgaecd", "cgeb", "fdcge", "agebfd", "fecdb", "fabcd", "edb"),
            listOf("edbfga", "begcd", "cbg", "gc", "gcadebf", "fbgde", "acbgfd", "abcde", "gfcbed", "gfec"),
            listOf("fgaebd", "cg", "bdaec", "gdafb", "agbcfd", "gdcbef", "bgcad", "gfac", "gcb", "cdgabef"),
            listOf("fbegcd", "cbd", "adcefb", "dageb", "afcb", "bc", "aefdc", "ecdab", "fgdeca", "fcdbega"),
            listOf("aecbfdg", "fbg", "gf", "bafeg", "dbefa", "fcge", "gcbea", "fcaegb", "dgceab", "fcbdga"),
            listOf("fgeab", "ca", "afcebg", "bdacfeg", "cfaedg", "gcfdb", "baec", "bfadeg", "bafgc", "acf"),
            listOf("dbcfg", "fgd", "bdegcaf", "fgec", "aegbdf", "ecdfab", "fbedc", "dacgb", "gdcebf", "gf"),
            listOf("bdfegc", "cbegaf", "gecbf", "dfcage", "bdacg", "ed", "bedf", "ced", "adcbefg", "gebcd"),
            listOf("egadfb", "cdbfeg", "cegd", "fecab", "cgb", "gbdefca", "cg", "fgcdab", "egfdb", "bfceg"),
            listOf("gcafb", "gcf", "dcaebfg", "ecagb", "gf", "abcdeg", "gaef", "cafbge", "fdbac", "fegbdc")
        )
        val puzzleSolver = Puzzle08()

        val result1 = puzzleSolver.countUniqueSequentNumbers(exampleSegmentOutput)
        assertEquals(26, result1)

        val result2 = puzzleSolver.decodeOutputValues(exampleSignals, exampleSegmentOutput)
        assertEquals(61229, result2)
    }

    @Test
    fun testPuzzle09() {
        val exampleInput = listOf(
            Puzzle09Point(0, 0, 2), Puzzle09Point(0, 1, 1), Puzzle09Point(0, 2, 9), Puzzle09Point(0, 3, 9),
            Puzzle09Point(0, 4, 9), Puzzle09Point(0, 5, 4), Puzzle09Point(0, 6, 3), Puzzle09Point(0, 7, 2),
            Puzzle09Point(0, 8, 1), Puzzle09Point(0, 9, 0),

            Puzzle09Point(1, 0, 3), Puzzle09Point(1, 1, 9), Puzzle09Point(1, 2, 8), Puzzle09Point(1, 3, 7),
            Puzzle09Point(1, 4, 8), Puzzle09Point(1, 5, 9), Puzzle09Point(1, 6, 4), Puzzle09Point(1, 7, 9),
            Puzzle09Point(1, 8, 2), Puzzle09Point(1, 9, 1),

            Puzzle09Point(2, 0, 9), Puzzle09Point(2, 1, 8), Puzzle09Point(2, 2, 5), Puzzle09Point(2, 3, 6),
            Puzzle09Point(2, 4, 7), Puzzle09Point(2, 5, 8), Puzzle09Point(2, 6, 9), Puzzle09Point(2, 7, 8),
            Puzzle09Point(2, 8, 9), Puzzle09Point(2, 9, 2),

            Puzzle09Point(3, 0, 8), Puzzle09Point(3, 1, 7), Puzzle09Point(3, 2, 6), Puzzle09Point(3, 3, 7),
            Puzzle09Point(3, 4, 8), Puzzle09Point(3, 5, 9), Puzzle09Point(3, 6, 6), Puzzle09Point(3, 7, 7),
            Puzzle09Point(3, 8, 8), Puzzle09Point(3, 9, 9),

            Puzzle09Point(4, 0, 9), Puzzle09Point(4, 1, 8), Puzzle09Point(4, 2, 9), Puzzle09Point(4, 3, 9),
            Puzzle09Point(4, 4, 9), Puzzle09Point(4, 5, 6), Puzzle09Point(4, 6, 5), Puzzle09Point(4, 7, 6),
            Puzzle09Point(4, 8, 7), Puzzle09Point(4, 9, 8),
        )
        val puzzleSolver = Puzzle09()

        val result1 = puzzleSolver.getRiskLevelOfLowPoint(exampleInput)
        assertEquals(15, result1)

        val result2 = puzzleSolver.getLargestBasinsSize(exampleInput)
        assertEquals(1134, result2)
    }

    @Test
    fun testPuzzle10() {
        val exampleInput = listOf(
            "[({(<(())[]>[[{[]{<()<>>",
            "[(()[<>])]({[<{<<[]>>(",
            "{([(<{}[<>[]}>{[]{[(<()>",
            "(((({<>}<{<{<>}{[]{[]{}",
            "[[<[([]))<([[{}[[()]]]",
            "[{[{({}]{}}([{[{{{}}([]",
            "{<[[]]>}<{[{[{[]{()[[[]",
            "[<(<(<(<{}))><([]([]()",
            "<{([([[(<>()){}]>(<<{{",
            "<{([{{}}[<[[[<>{}]]]>[]]"
        )
        val puzzleSolver = Puzzle10()

        val result1 = puzzleSolver.getSyntaxErrorScore(exampleInput)
        assertEquals(26397, result1)

        val result2 = puzzleSolver.getAutocompletionScore(exampleInput)
        assertEquals(288957, result2)
    }

    @Test
    fun testPuzzle11() {
        val plainExampleInput = arrayOf(
            arrayOf(5, 4, 8, 3, 1, 4, 3, 2, 2, 3),
            arrayOf(2, 7, 4, 5, 8, 5, 4, 7, 1, 1),
            arrayOf(5, 2, 6, 4, 5, 5, 6, 1, 7, 3),
            arrayOf(6, 1, 4, 1, 3, 3, 6, 1, 4, 6),
            arrayOf(6, 3, 5, 7, 3, 8, 5, 4, 7, 8),
            arrayOf(4, 1, 6, 7, 5, 2, 4, 6, 4, 5),
            arrayOf(2, 1, 7, 6, 8, 4, 1, 7, 2, 1),
            arrayOf(6, 8, 8, 2, 8, 8, 1, 1, 3, 4),
            arrayOf(4, 8, 4, 6, 8, 4, 8, 5, 5, 4),
            arrayOf(5, 2, 8, 3, 7, 5, 1, 5, 2, 6)
        )
        val exampleInput1 = mutableListOf<Puzzle11Octopus>()
        val exampleInput2 = mutableListOf<Puzzle11Octopus>()
        for (i in plainExampleInput.indices) {
            for (j in plainExampleInput[0].indices) {
                exampleInput1.add(Puzzle11Octopus(Pair(i, j), plainExampleInput[i][j]))
                exampleInput2.add(Puzzle11Octopus(Pair(i, j), plainExampleInput[i][j]))
            }
        }

        val puzzleSolver = Puzzle11()

        val result1 = puzzleSolver.getFlashesCount(exampleInput1)
        assertEquals(1656, result1)

        val result2 = puzzleSolver.getIterationWithAllFlashing(exampleInput2)
        assertEquals(195, result2)
    }

}