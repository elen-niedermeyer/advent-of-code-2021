package puzzle07

import readLines
import kotlin.math.abs

class Part02 {

    fun solve(): Int {
        val textLines = readLines("puzzle07.txt")
        val numbers = textLines[0].split(",")
        val input = IntArray(numbers.size) { i -> numbers[i].toInt() }

        return getMinimumIncreasingFuelUsage(input)
    }

    private fun getMinimumIncreasingFuelUsage(input: IntArray): Int {
        val minimumHorizontalPosition = input.minOrNull()
        val maximumHorizontalPosition = input.maxOrNull()
        var minimumFuelUsage = Int.MAX_VALUE
        if (minimumHorizontalPosition != null && maximumHorizontalPosition != null) {
            for (horizontalPosition in minimumHorizontalPosition..maximumHorizontalPosition) {
                var currentFuelUsage = 0
                // gaussian molecular formula
                input.forEach { currentFuelUsage += (abs(it - horizontalPosition) * (abs(it - horizontalPosition) + 1)) / 2 }
                if (currentFuelUsage < minimumFuelUsage) {
                    minimumFuelUsage = currentFuelUsage
                }
            }
        }

        return minimumFuelUsage
    }

}