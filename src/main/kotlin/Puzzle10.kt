class Puzzle10 {

    private val openingCharacters = arrayOf('(', '[', '{', '<')
    private val closingCharacters = arrayOf(')', ']', '}', '>')
    private val errorScores = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
    private val autocompletionPoints = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)

    fun solvePuzzle(): String {
        val input = readLines("puzzle10.txt")
        return "Syntax error score: " + getSyntaxErrorScore(input) +
                "; Autocompletion score: " + getAutocompletionScore(input)
    }

    fun getSyntaxErrorScore(input: List<String>): Int {
        val illegalCharacters = mutableListOf<Char>()

        input.forEach {
            val result = findIllegalCharacter(it)
            if (result.first != null) {
                illegalCharacters.add(result.first!!)
            }
        }

        return calculateScore(illegalCharacters)
    }

    fun getAutocompletionScore(input: List<String>): Long {
        val lineScores = mutableListOf<Long>()

        input.forEach {
            val result = findIllegalCharacter(it)
            if (result.first == null) {
                val stack = result.second
                var lineScore: Long = 0
                for (c in stack.asReversed()) {
                    lineScore *= 5
                    lineScore += autocompletionPoints[getMatchingClosingChar(c)]!!
                }
                lineScores.add(lineScore)
            }
        }

        val scoresSorted = lineScores.sorted()
        return scoresSorted[scoresSorted.size / 2]
    }

    private fun findIllegalCharacter(string: String): Pair<Char?, List<Char>> {
        var illegalCharacter: Char? = null
        val stack = mutableListOf<Char>()
        for (c in string) {
            if (openingCharacters.contains(c)) {
                // opening character
                stack.add(c)
            } else {
                // closing character
                val isMatching = isMatchingClosingChar(stack.lastOrNull(), c)
                if (!isMatching) {
                    illegalCharacter = c
                    break
                } else {
                    stack.removeLastOrNull()
                }
            }
        }

        return Pair(illegalCharacter, stack)
    }

    private fun isMatchingClosingChar(c1: Char?, c2: Char): Boolean {
        if (c1 != null) {
            return getMatchingClosingChar(c1) == c2
        }

        return false
    }

    private fun getMatchingClosingChar(c: Char): Char {
        val index = openingCharacters.indexOf(c)
        return closingCharacters[index]
    }


    private fun calculateScore(illegalCharacters: List<Char>): Int {
        var sum = 0
        illegalCharacters.forEach { sum += errorScores[it]!! }
        return sum
    }


}