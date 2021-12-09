class Puzzle09 {

    fun solvePuzzle(): String {
        val textLines = readLines("puzzle09.txt")
        val input = mutableListOf<Puzzle09Point>()
        for (i in textLines.indices) {
            for (j in textLines[0].indices) {
                input.add(Puzzle09Point(i, j, textLines[i][j].digitToInt()))
            }
        }

        return "Risk Levels: " + getRiskLevelOfLowPoint(input) + "; Largest Basins: " + getLargestBasinsSize(input)
    }

    fun getRiskLevelOfLowPoint(input: List<Puzzle09Point>): Int {
        val lowPointRiskLevels = mutableListOf<Int>()

        val lowPoints = getLowPoints(input)
        lowPoints.forEach { lowPointRiskLevels.add(it.value + 1) }

        return lowPointRiskLevels.sum()
    }

    fun getLargestBasinsSize(input: List<Puzzle09Point>): Int {
        val lowPoints = getLowPoints(input)
        val basinSizes = mutableListOf<Int>()
        for (point in lowPoints) {
            basinSizes.add(getBasinSize(input, point))
        }
        val basinSizesSorted = basinSizes.sortedDescending()
        val largestBasins = listOf(basinSizesSorted[0], basinSizesSorted[1], basinSizesSorted[2])

        return largestBasins.reduce { acc, i -> acc * i }
    }

    private fun getLowPoints(input: List<Puzzle09Point>): MutableList<Puzzle09Point> {
        val lowPoints = mutableListOf<Puzzle09Point>()
        for (point in input) {
            val adjacentPoints = getAdjacentPoints(input, point)
            val lowerPoints = adjacentPoints.count { it -> it.value <= point.value }
            if (lowerPoints == 0) {
                lowPoints.add(point)
            }
        }

        return lowPoints
    }

    private fun getBasinSize(input: List<Puzzle09Point>, point: Puzzle09Point): Int {
        val points = getBasinPoints(input, point).distinct()
        return points.size
    }

    private fun getBasinPoints(input: List<Puzzle09Point>, point: Puzzle09Point): List<Puzzle09Point> {
        val basinPoints = mutableListOf<Puzzle09Point>()
        if (point.value < 9) {
            basinPoints.add(point)
            val adjacentPoints = getAdjacentPoints(input, point)
            for (adjacentPoint in adjacentPoints) {
                if (adjacentPoint.value > point.value) {
                    basinPoints.addAll(getBasinPoints(input, adjacentPoint))
                }
            }
        }

        return basinPoints
    }

    private fun getAdjacentPoints(input: List<Puzzle09Point>, point: Puzzle09Point): MutableList<Puzzle09Point> {
        val adjacentPoints = mutableListOf<Puzzle09Point>()
        input.find { it -> it.i == point.i - 1 && it.j == point.j }?.let { it1 -> adjacentPoints.add(it1) }
        input.find { it -> it.i == point.i + 1 && it.j == point.j }?.let { it1 -> adjacentPoints.add(it1) }
        input.find { it -> it.i == point.i && it.j == point.j + 1 }?.let { it1 -> adjacentPoints.add(it1) }
        input.find { it -> it.i == point.i && it.j == point.j - 1 }?.let { it1 -> adjacentPoints.add(it1) }

        return adjacentPoints
    }

}