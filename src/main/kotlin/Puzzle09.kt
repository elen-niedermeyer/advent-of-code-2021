class Puzzle09 {

    fun solvePuzzle(): String {
        val textLines = readLines("puzzle09.txt")
        val inputList = mutableListOf<IntArray>()
        for (line in textLines) {
            inputList.add(IntArray(line.length) { i -> line[i].digitToInt() })
        }
        val input = inputList.toTypedArray()

        return "Risk Levels: " + getRiskLevelOfLowPoint(input) + "; Largest Basins: " + getLargestBasinsSize(input)
    }

    fun getRiskLevelOfLowPoint(input: Array<IntArray>): Int {
        val lowPointRiskLevels = mutableListOf<Int>()

        val lowPointPositions = getLowPointPositions(input)
        lowPointPositions.forEach { pair -> lowPointRiskLevels.add(input[pair.first][pair.second] + 1) }

        return lowPointRiskLevels.sum()
    }

    fun getLargestBasinsSize(input: Array<IntArray>): Int {
        val lowPointPositions = getLowPointPositions(input)
        val basinSizes = mutableListOf<Int>()
        for (position in lowPointPositions) {
            basinSizes.add(getBasinSize(input, position, input[position.first][position.second]))
        }
        val basinSizesSorted = basinSizes.sortedDescending()
        val largestBasins = listOf(basinSizesSorted[0], basinSizesSorted[1], basinSizesSorted[2])

        return largestBasins.reduce { acc, i -> acc * i }
    }

    private fun getLowPointPositions(input: Array<IntArray>): List<Pair<Int, Int>> {
        val lowPointPositions = mutableListOf<Pair<Int, Int>>()
        for (i in input.indices) {
            for (j in input[0].indices) {
                val adjacentPoints = getAdjacentPointsValue(input, i, j)
                val lowerPoints = adjacentPoints.count { point -> point <= input[i][j] }
                if (lowerPoints == 0) {
                    lowPointPositions.add(Pair(i, j))
                }
            }
        }

        return lowPointPositions
    }

    private fun getBasinSize(input: Array<IntArray>, position: Pair<Int, Int>, lowerPointValue: Int): Int {
        val points = getBasinPoints(input, position, lowerPointValue).distinct()
        return points.size
    }

    private fun getBasinPoints(
        input: Array<IntArray>,
        position: Pair<Int, Int>,
        lowerPointValue: Int
    ): List<Pair<Int, Int>> {
        val basinPoints = mutableListOf<Pair<Int, Int>>()
        if (input[position.first][position.second] < 9) {
            basinPoints.add(position)
            val adjacentPoints = getAdjacentPointPositions(input, position.first, position.second)
            for (adjacentPosition in adjacentPoints) {
                val adjacentValue = input[adjacentPosition.first][adjacentPosition.second]
                if (adjacentValue > lowerPointValue) {
                    basinPoints.addAll(getBasinPoints(input, adjacentPosition, adjacentValue))
                }
            }
        }
        return basinPoints
    }

    private fun getAdjacentPointsValue(input: Array<IntArray>, i: Int, j: Int): List<Int> {
        val positions = getAdjacentPointPositions(input, i, j)
        val adjacentPoints = mutableListOf<Int>()
        positions.forEach { pair -> adjacentPoints.add(input[pair.first][pair.second]) }

        return adjacentPoints
    }

    private fun getAdjacentPointPositions(input: Array<IntArray>, i: Int, j: Int): List<Pair<Int, Int>> {
        val adjacentPointPositions = mutableListOf<Pair<Int, Int>>()
        if (i > 0) {
            adjacentPointPositions.add(Pair(i - 1, j))
        }
        if (i < input.size - 1) {
            adjacentPointPositions.add(Pair(i + 1, j))
        }
        if (j > 0) {
            adjacentPointPositions.add(Pair(i, j - 1))
        }
        if (j < input[0].size - 1) {
            adjacentPointPositions.add(Pair(i, j + 1))
        }

        return adjacentPointPositions
    }

}