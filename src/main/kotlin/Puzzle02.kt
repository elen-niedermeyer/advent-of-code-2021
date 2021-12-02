import org.apache.commons.csv.CSVFormat

class Puzzle02 {

    fun solvePuzzle(): Int? {
        val records = readInput("puzzle02.csv", CSVFormat.newFormat(' '))
        val input = records?.let { Array(it.size) { i -> Puzzle02Element(it[i].get(0), it[i].get(1).toInt()) } }
        return input?.let { getAimPositionProduct(it) }
    }

    fun getPositionProduct(input: Array<Puzzle02Element>): Int {
        var horizontal = 0
        var depth = 0

        for (elem in input) {
            when (elem.direction) {
                "forward" -> {
                    horizontal += elem.steps
                }
                "down" -> {
                    depth += elem.steps
                }
                "up" -> {
                    depth -= elem.steps
                }
            }
        }

        return horizontal * depth
    }

    fun getAimPositionProduct(input: Array<Puzzle02Element>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for (elem in input) {
            when (elem.direction) {
                "forward" -> {
                    horizontal += elem.steps
                    depth += elem.steps * aim
                }
                "down" -> {
                    aim += elem.steps
                }
                "up" -> {
                    aim -= elem.steps
                }
            }
        }

        return horizontal * depth
    }
}