package puzzle13

import PuzzleSolution
import org.apache.commons.csv.CSVFormat
import readCsv
import readLines
import java.util.*

class Puzzle : PuzzleSolution("13") {

    override fun solvePart1(): Int? {
        return readPointInput()?.let { fold(it, readFoldInput()[0]).size }
    }

    override fun solvePart2(): Number? {
        var points = readPointInput()
        readFoldInput().forEach { points = fold(points!!, it) }
        points?.let {
            val gridSize = getGridSize(points!!)
            val grid = Array(gridSize.second + 1) { Array(gridSize.first + 1) { '.' } }
            points!!.forEach { grid[it.y][it.x] = '#' }
            var results = mutableListOf<String>()
            grid.forEach { results.add(it.joinToString(" ")) }
            println(results.joinToString("\n"))
        }
        return null
    }

    private fun readPointInput(): List<Point>? {
        val records = readCsv("puzzle13points.csv", CSVFormat.DEFAULT)
        return records?.let { List(it.size) { i -> Point(it[i].get(0).toInt(), it[i].get(1).toInt()) } }
    }

    private fun readFoldInput(): List<Pair<String, Int>> {
        val textLines = readLines("puzzle13folds.txt")
        val input = mutableListOf<Pair<String, Int>>()
        textLines.forEach {
            val match = "[x,y]{1}=\\d+".toRegex().find(it)!!
            val parts = match.value.split('=')
            input.add(Pair(parts[0], parts[1].toInt()))
        }

        return input
    }

    private fun fold(points: List<Point>, folding: Pair<String, Int>): List<Point> {
        val resultingPoints = mutableListOf<Point>()
        if (folding.first == "x") {
            points.forEach {
                if (it.x > folding.second) {
                    val diff = it.x - folding.second
                    resultingPoints.add(Point(it.x - diff * 2, it.y))
                } else if (it.x < folding.second) {
                    resultingPoints.add(it)
                }
            }
        } else {
            // folding.first == "y"
            points.forEach {
                if (it.y > folding.second) {
                    val diff = it.y - folding.second
                    resultingPoints.add(Point(it.x, it.y - diff * 2))
                } else if (it.y < folding.second) {
                    resultingPoints.add(it)
                }
            }
        }

        return resultingPoints.distinctBy { Pair(it.x, it.y) }
    }

    private fun getGridSize(points: List<Point>): Pair<Int, Int> {
        var maxX = 0
        var maxY = 0
        points.forEach {
            if (it.x > maxX) {
                maxX = it.x
            }
            if (it.y > maxY) {
                maxY = it.y
            }
        }

        return Pair(maxX, maxY)
    }
}