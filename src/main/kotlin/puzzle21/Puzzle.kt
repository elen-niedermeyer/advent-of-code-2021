package puzzle21

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("21") {

    override fun solvePart1(): Int {
        return Part01().solve(readInput())
    }

    override fun solvePart2(): Long {
        return Part02().solve(readInput())
    }

    private fun readInput(): Pair<Int, Int> {
        val textLines = readLines("puzzle21.txt")
        return Pair(textLines[0].last().digitToInt(), textLines[1].last().digitToInt())
    }

}