package puzzle02

import org.apache.commons.csv.CSVFormat
import readCsv

class Part01 {

    fun solve(): Int? {
        val records = readCsv("puzzle02.csv", CSVFormat.newFormat(' '))
        val input = records?.let { Array(it.size) { i -> Pair(it[i].get(0), it[i].get(1).toInt()) } }
        return input?.let { getPositionProduct(it) }
    }

    private fun getPositionProduct(input: Array<Pair<String, Int>>): Int {
        var horizontal = 0
        var depth = 0

        for (elem in input) {
            when (elem.first) {
                "forward" -> {
                    horizontal += elem.second
                }
                "down" -> {
                    depth += elem.second
                }
                "up" -> {
                    depth -= elem.second
                }
            }
        }

        return horizontal * depth
    }
}