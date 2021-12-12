package puzzle12

import PuzzleSolution
import org.apache.commons.csv.CSVFormat
import readCsv

class Puzzle : PuzzleSolution("12") {

    override fun solvePart1(): Int? {
        return findAllPaths(readInput(), false)
    }

    override fun solvePart2(): Int? {
        return findAllPaths(readInput(), true)
    }

    private fun readInput(): List<Cave> {
        val records = readCsv("puzzle12.csv", CSVFormat.newFormat('-'))
        val input = mutableListOf<Cave>()
        if (records != null) {
            for (record in records) {
                if (input.count { it.name == record.get(0) } == 0) {
                    input.add(Cave(record.get(0)))
                }
                if (input.count { it.name == record.get(1) } == 0) {
                    input.add(Cave(record.get(1)))
                }
                input.find { it.name == record.get(0) }?.neighbors?.add(input.find { it.name == record.get(1) }!!)
                input.find { it.name == record.get(1) }?.neighbors?.add(input.find { it.name == record.get(0) }!!)
            }
        }
        return input
    }

    private fun findAllPaths(input: List<Cave>, useSmallCaveDoubled: Boolean): Int? {
        val startCave = input.find { it.name == "start" }

        return startCave?.let { countPaths(it, listOf(), !useSmallCaveDoubled) }
    }

    private fun countPaths(cave: Cave, path: List<Cave>, wasSmallDoubleUsed: Boolean): Int {
        if (cave.name == "end") {
            return 1
        }

        var usedSmallDouble = wasSmallDoubleUsed
        if (cave.name.first().isLowerCase() && path.contains(cave)) {
            if (usedSmallDouble) {
                return 0
            } else {
                usedSmallDouble = true
            }
        }

        var count = 0
        cave.neighbors.forEach {
            if (it.name != "start") {
                count += countPaths(it, path + cave, usedSmallDouble)
            }
        }
        return count
    }

}