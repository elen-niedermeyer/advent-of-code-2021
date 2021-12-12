package puzzle09

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("09") {


    override fun solvePart1(): Int {
        return Part01().solve()
    }

    override fun solvePart2(): Int {
        return Part02().solve()
    }

    fun readInput(): List<Point> {
        val textLines = readLines("puzzle09.txt")
        val input = mutableListOf<Point>()
        for (i in textLines.indices) {
            for (j in textLines[0].indices) {
                input.add(Point(i, j, textLines[i][j].digitToInt()))
            }
        }

        return input
    }

    fun getLowPoints(input: List<Point>): MutableList<Point> {
        val lowPoints = mutableListOf<Point>()
        for (point in input) {
            val adjacentPoints = getAdjacentPoints(input, point)
            val lowerPoints = adjacentPoints.count { it.value <= point.value }
            if (lowerPoints == 0) {
                lowPoints.add(point)
            }
        }

        return lowPoints
    }

    fun getAdjacentPoints(input: List<Point>, point: Point): MutableList<Point> {
        val adjacentPoints = mutableListOf<Point>()
        input.find { it.i == point.i - 1 && it.j == point.j }?.let { it1 -> adjacentPoints.add(it1) }
        input.find { it.i == point.i + 1 && it.j == point.j }?.let { it1 -> adjacentPoints.add(it1) }
        input.find { it.i == point.i && it.j == point.j + 1 }?.let { it1 -> adjacentPoints.add(it1) }
        input.find { it.i == point.i && it.j == point.j - 1 }?.let { it1 -> adjacentPoints.add(it1) }

        return adjacentPoints
    }

}