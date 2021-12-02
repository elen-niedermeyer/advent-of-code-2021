class Puzzle01 {

    fun solvePuzzle(): Int? {
        val records = readInput("puzzle01.csv")
        val input = records?.let { IntArray(it.size) { i -> it[i].get(0).toInt() } }
        return input?.let { countWindowIncreasements(it) }
    }

    fun countIncreasements(input: IntArray): Int {
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

    fun countWindowIncreasements(input: IntArray): Int {
        val sums = input.toList().windowed(size = 3, step = 1) { it.sum() }
        return countIncreasements(sums.toIntArray())
    }

}