package puzzle05

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("05") {

    override fun solvePart1(): Int {
        return getHorizontalAndVerticalOverlappingPoints(readInput())
    }

    override fun solvePart2(): Int {
        return getAllOverlappingPoints(readInput())
    }

    private fun readInput(): List<IntArray> {
        val textLines = readLines("puzzle05.txt")
        val input = mutableListOf<IntArray>()
        for (line in textLines) {
            val commaSeparated = line.replace(" -> ", ",")
            val numbers = commaSeparated.split(",")
            val lineArray = IntArray(numbers.size) { i -> numbers[i].toInt() }
            input.add(lineArray)
        }
        return input
    }

    private fun getHorizontalAndVerticalOverlappingPoints(input: List<IntArray>): Int {
        val points = mutableListOf<Pair<Int, Int>>()
        for (line in input) {
            if (line[0] == line[2] || line[1] == line[3]) {
                // only horizontal and vertical lines
                points.addAll(findAllPointForLine(line))
            }
        }

        return points.groupingBy { it }.eachCount().filter { it.value > 1 }.size
    }

    private fun getAllOverlappingPoints(input: List<IntArray>): Int {
        val points = mutableListOf<Pair<Int, Int>>()
        for (line in input) {
            points.addAll(findAllPointForLine(line))
        }

        return points.groupingBy { it }.eachCount().filter { it.value > 1 }.size
    }

    private fun findAllPointForLine(line: IntArray): MutableList<Pair<Int, Int>> {
        val linePoints = mutableListOf<Pair<Int, Int>>()

        var x = line[0]
        var y = line[1]

        while (x != line[2] || y != line[3]) {
            linePoints.add(Pair(x, y))

            if (line[0] < line[2]) {
                x++
            } else if (line[0] > line[2]) {
                x--
            }

            if (line[1] < line[3]) {
                y++
            } else if (line[1] > line[3]) {
                y--
            }
        }

        linePoints.add(Pair(line[2], line[3]))

        return linePoints
    }

}