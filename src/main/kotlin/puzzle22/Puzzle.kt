package puzzle22

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("22") {

    override fun solvePart1(): Int {
        return Part01().solve(readInput())
    }

    override fun solvePart2(): Long {
        return Part02().solve(readInput())
    }

    private fun readInput(): List<String> {
        return readLines("puzzle22.txt")
    }

}