package puzzle17

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("17") {

    override fun solvePart1(): Int {
        return Part01().solve(readInput())
    }

    override fun solvePart2(): Int {
        return Part02().solve(readInput())
    }

    private fun readInput(): IntArray {
        val textLine = readLines("puzzle17.txt")[0]
        val matchX = "x=\\d+\\.\\.\\d+".toRegex().find(textLine)!!
        val minX = matchX.value.substring(2).split("..")[0].toInt()
        val maxX = matchX.value.substring(2).split("..")[1].toInt()
        val matchY = "y=-\\d+\\.\\.-\\d+".toRegex().find(textLine)!!
        val minY = matchY.value.substring(2).split("..")[0].toInt()
        val maxY = matchY.value.substring(2).split("..")[1].toInt()

        return intArrayOf(minX, maxX, minY, maxY)
    }

}