package puzzle14

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("14") {

    override fun solvePart1(): Int {
        return Part01().solve(readPolymer(), readInsertionRules(), 10)
    }

    override fun solvePart2(): Long {
        return Part02().solve(readPolymer(), readInsertionRules(), 40)
    }

    private fun readPolymer(): String {
        return readLines("puzzle14polymer.txt")[0]
    }

    private fun readInsertionRules(): Map<String, String> {
        val textLines = readLines("puzzle14rules.txt")
        val rules = mutableMapOf<String, String>()
        for (line in textLines) {
            val parts = line.split(" -> ")
            rules[parts[0]] = parts[1]
        }

        return rules
    }

}