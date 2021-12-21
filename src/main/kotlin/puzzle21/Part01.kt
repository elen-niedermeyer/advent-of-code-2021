package puzzle21

class Part01 {

    fun solve(input: Pair<Int, Int>): Int {
        return playWithDeterministic100SidedDice(input)
    }

    private fun playWithDeterministic100SidedDice(input: Pair<Int, Int>): Int {
        var position1 = input.first
        var position2 = input.second
        var score1 = 0
        var score2 = 0
        var diceNumber = 0
        var iterations = 0
        while (score2 < 1000) {
            // player 1
            val steps1 = nextDiceNumber(diceNumber) + nextDiceNumber(diceNumber + 1) + nextDiceNumber(diceNumber + 2)
            position1 = (position1 + steps1) % 10
            score1 += if (position1 == 0) 10 else position1
            if (score1 >= 1000) break

            // player 2
            val steps2 =
                nextDiceNumber(diceNumber + 3) + nextDiceNumber(diceNumber + 4) + nextDiceNumber(diceNumber + 5)
            position2 = (position2 + steps2) % 10
            score2 += if (position2 == 0) 10 else position2

            diceNumber = nextDiceNumber(diceNumber + 5)
            iterations++
        }

        if (score1 >= 1000) {
            // player 1 wins
            return score2 * ((iterations) * 6 + 3)
        }
        // player 2 wins
        return score1 * (iterations * 6)
    }

    private fun nextDiceNumber(diceNumber: Int): Int {
        if (diceNumber == 100) {
            return 1
        }
        return diceNumber + 1
    }
}