package puzzle03

import PuzzleSolution

class Puzzle : PuzzleSolution("03") {

    override fun solvePart1(): Int {
        return Part01().solve()
    }

    override fun solvePart2(): Int {
        return Part02().solve()
    }

    fun getMostCommonBits(input: List<String>): String {
        var result = ""
        for (position in input[0].indices) {
            var sum = 0
            for (row in input.indices) {
                sum += input[row][position].digitToInt()
            }
            result += if (sum >= input.size / 2.0) {
                "1"
            } else {
                "0"
            }
        }

        return result
    }

}