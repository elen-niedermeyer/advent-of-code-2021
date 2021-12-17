package puzzle16

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("16") {

    override fun solvePart1(): Int {
        return Part01().solve(getInput())
    }

    override fun solvePart2(): Long {
        return Part02().solve(getInput())
    }

    private fun getInput(): String {
        return convertToBinary(readInput())
    }

    private fun readInput(): String {
        return readLines("puzzle16.txt")[0]
    }

    private fun convertToBinary(hexString: String): String {
        var input = ""
        hexString.forEach {
            val binaryString = Integer.toBinaryString(Integer.valueOf(it.toString(), 16))
            input += binaryString.padStart(4, '0')
        }

        return input
    }

}