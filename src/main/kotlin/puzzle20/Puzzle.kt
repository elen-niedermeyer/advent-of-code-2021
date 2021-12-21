package puzzle20

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("20") {

    override fun solvePart1(): Int {
        val input = readInput()
        val step1 = enhanceImage(input.first, input.second)
        val step2 = enhanceImage(padInput(step1, input.second[0] == '1'), input.second)
        return countLitPixels(step2)
    }

    override fun solvePart2(): Int {
        val input = readInput()
        var image = input.first
        var iteration = 0
        while (iteration < 50) {
            val nextImage = enhanceImage(image, input.second)
            image = padInput(nextImage, input.second[0] == '1' && iteration % 2 == 0)
            iteration++
        }

        return countLitPixels(image)
    }

    private fun readInput(): Pair<List<String>, String> {
        val textLines = readLines("puzzle20.txt")
        val algorithm = textLines[0].map { if (it == '#') "1" else "0" }
        val image = mutableListOf<String>()
        for (i in 2 until textLines.size) {
            val line = textLines[i].map { if (it == '#') "1" else "0" }
            image.add(line.joinToString(""))
        }

        return Pair(padInput(image, false), algorithm.joinToString(""))
    }

    private fun padInput(input: List<String>, lit: Boolean): List<String> {
        val newImage = mutableListOf<String>()
        if (!lit) {
            input.forEach { newImage.add("00" + it + "00") }
            newImage.add(0, newImage[0].replace("1", "0"))
            newImage.add(0, newImage[0].replace("1", "0"))
            newImage.add(newImage[0].replace("1", "0"))
            newImage.add(newImage[0].replace("1", "0"))
        } else {
            input.forEach { newImage.add("11" + it + "11") }
            newImage.add(0, newImage[0].replace("0", "1"))
            newImage.add(0, newImage[0].replace("0", "1"))
            newImage.add(newImage[0].replace("0", "1"))
            newImage.add(newImage[0].replace("0", "1"))
        }

        return newImage
    }

    private fun enhanceImage(image: List<String>, algorithm: String): List<String> {
        val newImage = mutableListOf<String>()
        for (i in 1..image.size - 2) {
            var newLine = ""
            for (j in 1..image[0].length - 2) {
                var numberString = ""
                numberString += image[i - 1][j - 1]
                numberString += image[i - 1][j]
                numberString += image[i - 1][j + 1]
                numberString += image[i][j - 1]
                numberString += image[i][j]
                numberString += image[i][j + 1]
                numberString += image[i + 1][j - 1]
                numberString += image[i + 1][j]
                numberString += image[i + 1][j + 1]
                val number = numberString.toInt(2)
                newLine += algorithm[number]
            }
            newImage.add(newLine)
        }

        return newImage
    }

    private fun countLitPixels(image: List<String>): Int {
        var count = 0
        image.forEach { count += it.count { c -> c == '1' } }
        return count
    }

}