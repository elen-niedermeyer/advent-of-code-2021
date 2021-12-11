package puzzle01

import readLines

class Puzzle {

    fun solvePart1(): Int {
        val records = readLines("puzzle01.txt")
        val input = records.let { IntArray(it.size) { i -> it[i].toInt() } }
        return countIncreasements(input)
    }

    fun solvePart2(): Int {
        val records = readLines("puzzle01.txt")
        val input = records.let { IntArray(it.size) { i -> it[i].toInt() } }
        return countWindowIncreasements(input)
    }

    private fun countIncreasements(input: IntArray): Int {
        var count = 0
        var previous = input[0]
        for (i in input) {
            if (i > previous) {
                count += 1
            }
            previous = i
        }

        return count
    }

    private fun countWindowIncreasements(input: IntArray): Int {
        val sums = input.toList().windowed(size = 3, step = 1) { it.sum() }
        return countIncreasements(sums.toIntArray())
    }

}