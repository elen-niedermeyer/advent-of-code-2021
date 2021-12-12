package puzzle09

class Part02 {

    fun solve(): Int {
        val input = Puzzle().readInput()
        val lowPoints = Puzzle().getLowPoints(input)
        val basinSizes = mutableListOf<Int>()
        for (point in lowPoints) {
            basinSizes.add(getBasinSize(input, point))
        }
        val basinSizesSorted = basinSizes.sortedDescending()
        val largestBasins = listOf(basinSizesSorted[0], basinSizesSorted[1], basinSizesSorted[2])

        return largestBasins.reduce { acc, i -> acc * i }
    }

    private fun getBasinSize(input: List<Point>, point: Point): Int {
        val points = getBasinPoints(input, point).distinct()
        return points.size
    }

    private fun getBasinPoints(input: List<Point>, point: Point): List<Point> {
        val basinPoints = mutableListOf<Point>()
        if (point.value < 9) {
            basinPoints.add(point)
            val adjacentPoints = Puzzle().getAdjacentPoints(input, point)
            for (adjacentPoint in adjacentPoints) {
                if (adjacentPoint.value > point.value) {
                    basinPoints.addAll(getBasinPoints(input, adjacentPoint))
                }
            }
        }

        return basinPoints
    }

}