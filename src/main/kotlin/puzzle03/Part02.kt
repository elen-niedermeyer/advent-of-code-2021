package puzzle03

import readLines

class Part02 {

    fun solve(): Int {
        val input = readLines("puzzle03.txt")
        return getLifeSupportingRate(input)
    }

    private fun getLifeSupportingRate(input: List<String>): Int {
        val oxygenGeneratorRating = getOxygenGeneratorRating(input.toMutableList(), 0)
        val co2ScrubberRating = getCo2ScrubberRating(input.toMutableList(), 0)

        return oxygenGeneratorRating.toInt(2) * co2ScrubberRating.toInt(2)
    }

    private fun getOxygenGeneratorRating(input: MutableList<String>, index: Int): String {
        return if (input.size > 1) {
            val mostCommonBits = Puzzle().getMostCommonBits(input)
            input.removeIf { value -> value[index] != mostCommonBits[index] }
            getOxygenGeneratorRating(input, index + 1)
        } else {
            input[0]
        }
    }

    private fun getCo2ScrubberRating(input: MutableList<String>, index: Int): String {
        return if (input.size > 1) {
            val mostCommonBits = Puzzle().getMostCommonBits(input)
            input.removeIf { value -> value[index] == mostCommonBits[index] }
            getCo2ScrubberRating(input, index + 1)
        } else {
            input[0]
        }
    }

}