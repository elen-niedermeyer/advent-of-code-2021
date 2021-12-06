class Puzzle06 {

    fun solvePuzzle(): String {
        val textLines = readLines("puzzle06.txt")
        val numbers = textLines[0].split(",")
        val input = List(numbers.size) { i -> numbers[i].toInt() }

        return "After 80 days: " + getNumberOfFishes(input, 80) + "; After 256 days: " + getNumberOfFishes(input, 256)
    }

    fun getNumberOfFishes(input: List<Int>, days: Int): Long {
        var days = days
        var fishes = input.groupingBy { it }.eachCount().mapValues { it -> it.value.toLong() }
        while (days > 0) {
            fishes = fishes.mapKeys { it ->
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

            days--
        }

        var sum: Long = 0
        fishes.forEach { it -> sum += it.value }
        return sum
    }

}