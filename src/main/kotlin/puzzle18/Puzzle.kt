package puzzle18

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("18") {

    override fun solvePart1(): Int {
        val input = readInput()
        var currentNumber = input[0]

        for (i in 1 until input.size) {
            currentNumber = add(currentNumber, input[i])
            reduce(currentNumber)
            //println("Step result: " + currentNumber.last())
        }

        return currentNumber.calculateMagnitude()
    }

    override fun solvePart2(): Int {
        var highestMagnitude = 0
        val input = readInput()
        for (i in input.indices) {
            for (j in input.indices) {
                // renew input
                val inputCopy = readInput()
                // calculate sum
                val currentNumber = add(inputCopy[i], inputCopy[j])
                reduce(currentNumber)
                val currentMagnitude = currentNumber.calculateMagnitude()
                if (currentMagnitude > highestMagnitude) {
                    highestMagnitude = currentMagnitude
                }
            }
        }

        return highestMagnitude
    }

    private fun readInput(): List<SnailfishNumber> {
        val textLines = readLines("puzzle18.txt")
        val allNumbers = mutableListOf<SnailfishNumber>()
        textLines.forEach { allNumbers.add(parseNumberInput(it) as SnailfishNumber) }
        return allNumbers
    }

    private fun parseNumberInput(number: String): Any {
        if (!number.contains(',')) {
            return number.toInt()
        }

        val commaIndex = findCommaBetweenChildren(number)

        val leftChildren = parseNumberInput(number.substring(1, commaIndex))
        val rightChildren = parseNumberInput(number.substring(commaIndex + 1, number.length - 1))

        return SnailfishNumber(leftChildren, rightChildren)
    }

    private fun findCommaBetweenChildren(number: String, openingChar: Char = '[', closingChar: Char = ']'): Int {
        if (number.count { it == ',' } == 1) {
            return number.indexOf(',')
        }

        var index = 0
        var opening = 0
        var closing = 0
        while (index < number.length) {
            if (number[index] == openingChar) {
                opening++
            }
            if (number[index] == closingChar) {
                closing++
            }

            if (opening > 1 && closing == opening - 1) {
                return if (index < number.length - 2) index + 1
                else number.length - 1 - findCommaBetweenChildren(
                    number.reversed(), closingChar, openingChar
                )
            }

            index++
        }

        return 0
    }

    private fun add(value1: SnailfishNumber, value2: SnailfishNumber): SnailfishNumber {
        return SnailfishNumber(value1, value2)
    }

    private fun reduce(input: SnailfishNumber) {
        var toSplit = true
        while (toSplit) {
            explodeAll(input)
            val newSplittedNumber = input.trySplit()
            if (newSplittedNumber == null) {
                toSplit = false
            }
        }
    }

    private fun explodeAll(input: SnailfishNumber) {
        var numberToExplode = input.findChildToExplode()

        while (numberToExplode != null) {
            val isLeftChild = numberToExplode.parent!!.leftChild == numberToExplode

            // find left number
            var currentChild = numberToExplode
            var leftChildedParent = numberToExplode.parent
            while (leftChildedParent != null && leftChildedParent.leftChild == currentChild) {
                currentChild = leftChildedParent
                leftChildedParent = leftChildedParent.parent
            }
            if (leftChildedParent != null) {
                var leftNumber = leftChildedParent.leftChild
                var leftNumberParent = leftChildedParent
                var isLeft = true
                while (leftNumber !is Int) {
                    leftNumberParent = (leftNumber as SnailfishNumber)
                    leftNumber = leftNumber.rightChild
                    isLeft = false
                }
                val newValue = leftNumber + numberToExplode.leftChild as Int
                if (isLeft) {
                    leftNumberParent!!.leftChild = newValue
                } else {
                    leftNumberParent!!.rightChild = newValue
                }
            }

            // find right number
            currentChild = numberToExplode
            var rightChildedParent = numberToExplode.parent
            while (rightChildedParent != null && rightChildedParent.rightChild == currentChild) {
                currentChild = rightChildedParent
                rightChildedParent = rightChildedParent.parent
            }
            if (rightChildedParent != null) {
                var rightNumber = rightChildedParent.rightChild
                var rightNumberParent = rightChildedParent
                var isRight = true
                while (rightNumber !is Int) {
                    rightNumberParent = (rightNumber as SnailfishNumber)
                    rightNumber = rightNumber.leftChild
                    isRight = false
                }
                val newValue = rightNumber + numberToExplode.rightChild as Int
                if (isRight) {
                    rightNumberParent!!.rightChild = newValue
                } else {
                    rightNumberParent!!.leftChild = newValue
                }
            }

            // set 0
            if (isLeftChild) {
                numberToExplode.parent!!.leftChild = 0
            } else {
                numberToExplode.parent!!.rightChild = 0
            }

            numberToExplode = input.findChildToExplode()
        }
    }

}