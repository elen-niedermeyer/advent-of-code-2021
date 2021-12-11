package puzzle03

import readLines

class Part01 {

    fun solve(): Int {
        val input = readLines("puzzle03.txt")
        return getPowerConsumption(input)
    }

    private fun getPowerConsumption(input: List<String>): Int {
        val mostCommonBits = Puzzle().getMostCommonBits(input)

        var gammaRating = ""
        var epsilonRating = ""
        for (bit in mostCommonBits) {
            if (bit == "1".single()) {
                gammaRating += "1"
                epsilonRating += "0"
            } else { // bit == "0".single()
                gammaRating += "0"
                epsilonRating += "1"
            }
        }

        return gammaRating.toInt(2) * epsilonRating.toInt(2)
    }

}