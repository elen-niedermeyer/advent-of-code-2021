import org.apache.commons.csv.CSVFormat

class Puzzle03 {

    fun solvePuzzle(): String? {
        val records = readCsv("puzzle03.csv", CSVFormat.DEFAULT)
        val input = records?.let { List(it.size) { i -> it[i].get(0) } }
        return input?.let {
            "Power Consumption: " + getPowerConsumption(it) + "; Life Support Rating: " + getLifeSupportingRate(
                it.toMutableList()
            )
        }
    }

    fun getPowerConsumption(input: List<String>): Int {
        val mostCommonBits = getMostCommonBits(input)

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

    fun getLifeSupportingRate(input: MutableList<String>): Int {
        val oxygenGeneratorRating = getOxygenGeneratorRating(input.toMutableList(), 0)
        val co2ScrubberRating = getCo2ScrubberRating(input.toMutableList(), 0)

        return oxygenGeneratorRating.toInt(2) * co2ScrubberRating.toInt(2)
    }

    private fun getMostCommonBits(input: List<String>): String {
        var result = ""
        for (position in input[0].indices) {
            var sum = 0
            for (row in input.indices) {
                sum += input[row][position].digitToInt()
            }
            if (sum >= input.size / 2.0) {
                result += "1"
            } else {
                result += "0"
            }
        }

        return result
    }

    private fun getOxygenGeneratorRating(input: MutableList<String>, index: Int): String {
        if (input.size > 1) {
            val mostCommonBits = getMostCommonBits(input)
            input.removeIf { value -> value[index] != mostCommonBits[index] }
            return getOxygenGeneratorRating(input, index + 1)
        } else {
            return input[0]
        }
    }

    private fun getCo2ScrubberRating(input: MutableList<String>, index: Int): String {
        if (input.size > 1) {
            val mostCommonBits = getMostCommonBits(input)
            input.removeIf { value -> value[index] == mostCommonBits[index] }
            return getCo2ScrubberRating(input, index + 1)
        } else {
            return input[0]
        }
    }

}