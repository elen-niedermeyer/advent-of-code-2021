import kotlin.math.abs

class Puzzle07 {

    fun solvePuzzle(): Int {
        val textLines = readLines("puzzle07.txt")
        val numbers = textLines[0].split(",")
        val input = IntArray(numbers.size) { i -> numbers[i].toInt() }

        return getMinimumIncreasingFuelUsage(input)
    }

    fun getMinimumConstantFuelUsage(input: IntArray): Int {
        val minimumHorizontalPosition = input.minOrNull()
        val maximumHorizontalPosition = input.maxOrNull()
        var minimumFuelUsage = Int.MAX_VALUE
        if (minimumHorizontalPosition != null && maximumHorizontalPosition != null) {
            for (horizontalPosition in minimumHorizontalPosition..maximumHorizontalPosition) {
                var currentFuelUsage = 0
                input.forEach { it -> currentFuelUsage += abs(it - horizontalPosition) }
                if (currentFuelUsage < minimumFuelUsage) {
                    minimumFuelUsage = currentFuelUsage
                }
            }
        }

        return minimumFuelUsage
    }

    fun getMinimumIncreasingFuelUsage(input: IntArray): Int {
        val minimumHorizontalPosition = input.minOrNull()
        val maximumHorizontalPosition = input.maxOrNull()
        var minimumFuelUsage = Int.MAX_VALUE
        if (minimumHorizontalPosition != null && maximumHorizontalPosition != null) {
            for (horizontalPosition in minimumHorizontalPosition..maximumHorizontalPosition) {
                var currentFuelUsage = 0
                // gaussian molecular formula
                input.forEach { it -> currentFuelUsage += (abs(it - horizontalPosition) * (abs(it - horizontalPosition) + 1)) / 2 }
                if (currentFuelUsage < minimumFuelUsage) {
                    minimumFuelUsage = currentFuelUsage
                }
            }
        }

        return minimumFuelUsage
    }

}