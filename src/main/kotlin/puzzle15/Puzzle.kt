package puzzle15

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("15") {

    override fun solvePart1(): Int {
        return findShortestPath(readInput())
    }

    override fun solvePart2(): Int? {
        // takes loooong
        // return findShortestPath(readAndMultiplyInput())
        return null
    }

    private fun readInput(): List<Vertex> {
        val textLines = readLines("puzzle15.txt")
        val input = mutableListOf<Vertex>()
        textLines.forEachIndexed { index, string ->
            string.forEachIndexed { indexString, c ->
                input.add(
                    Vertex(
                        index, indexString, c.digitToInt()
                    )
                )
            }
        }

        return input
    }

    private fun readAndMultiplyInput(): List<Vertex> {
        val textLines = readLines("puzzle15.txt")
        val input = mutableListOf<Vertex>()
        textLines.forEachIndexed { index, string ->
            string.forEachIndexed { indexString, c ->
                val intValue = c.digitToInt()
                for (i in 0..4) {
                    for (j in 0..4) {
                        val newIntValue = if (intValue + i + j > 9) (intValue + i + j) % 9 else intValue + i + j
                        input.add(Vertex(index + i * textLines.size, indexString + j * string.length, newIntValue))
                    }
                }
            }
        }

        return input
    }

    private fun findShortestPath(input: List<Vertex>): Int {
        val waiting = mutableListOf(input.first())
        val visited = mutableListOf<Vertex>()

        var currentVertex = waiting.first()
        var endVertex = input.last()
        while (currentVertex != endVertex) {
            waiting.remove(currentVertex)
            val neighbors = getAdjacentVertices(currentVertex, input)
            neighbors.forEach {
                if (!visited.contains(it)) {
                    val distance = it.costs + currentVertex.distance
                    if (it.distance == 0 || distance < it.distance) {
                        it.distance = distance
                        if (!waiting.contains(it)) {
                            waiting.add(it)
                        }
                    }
                }
            }
            visited.add(currentVertex)
            currentVertex = waiting.minByOrNull { it.distance }!!
        }

        return currentVertex.distance
    }

    private fun getAdjacentVertices(vertex: Vertex, allVertices: List<Vertex>): List<Vertex> {
        val neighbors = mutableListOf<Vertex>()
        allVertices.find { it.row == vertex.row - 1 && it.column == vertex.column }?.let { neighbors.add(it) }
        allVertices.find { it.row == vertex.row + 1 && it.column == vertex.column }?.let { neighbors.add(it) }
        allVertices.find { it.row == vertex.row && it.column == vertex.column + 1 }?.let { neighbors.add(it) }
        allVertices.find { it.row == vertex.row && it.column == vertex.column - 1 }?.let { neighbors.add(it) }

        return neighbors
    }

}