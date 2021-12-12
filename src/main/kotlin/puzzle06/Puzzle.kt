package puzzle06

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("06") {

    override fun solvePart1(): Long {
        return getNumberOfFishes(readInput(), 80)
    }

    override fun solvePart2(): Long {
        return getNumberOfFishes(readInput(), 256)
    }

    private fun readInput(): List<Int> {
        val textLines = readLines("puzzle06.txt")
        val numbers = textLines[0].split(",")

        return List(numbers.size) { i -> numbers[i].toInt() }
    }

    private fun getNumberOfFishes(input: List<Int>, days: Int): Long {
        var dayCount = days
        var fishes = input.groupingBy { it }.eachCount().mapValues { it.value.toLong() }
        while (dayCount > 0) {
            fishes = fishes.mapKeys {
                it.key - 1
            }.toMutableMap()

            fishes[-1]?.let {
                if (fishes[6] != null) {
                    fishes[6] = it + fishes[6]!!
                } else {
                    fishes[6] = it
                }
                // add new fishes
                fishes.put(8, it)

                fishes.remove(-1)
            }

            dayCount--
        }

        var sum: Long = 0
        fishes.forEach { sum += it.value }
        return sum
    }

}