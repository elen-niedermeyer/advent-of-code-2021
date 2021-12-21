package puzzle21

class Part02 {

    private val weightMap = mapOf(3 to 1, 4 to 3, 5 to 6, 6 to 7, 7 to 6, 8 to 3, 9 to 1)

    fun solve(input: Pair<Int, Int>): Long {
        val result = playWithDiracDice(Pair(input.first, input.second), Pair(0, 0), true)
        return if (result.first > result.second) result.first else result.second
    }

    private fun playWithDiracDice(
        positions: Pair<Int, Int>,
        scores: Pair<Int, Int>,
        isPlayer1Turn: Boolean
    ): Pair<Long, Long> {
        val results = mutableListOf<Pair<Long, Long>>()
        for (i in 3..9) {
            val result = nextTurn(positions, scores, i, isPlayer1Turn)
            results.add(Pair(result.first * weightMap[i]!!, result.second * weightMap[i]!!))
        }
        var sum1: Long = 0
        var sum2: Long = 0
        results.forEach {
            sum1 += it.first
            sum2 += it.second
        }

        return Pair(sum1, sum2)
    }

    private fun nextTurn(
        positions: Pair<Int, Int>,
        scores: Pair<Int, Int>,
        steps: Int,
        isPlayer1Turn: Boolean
    ): Pair<Long, Long> {
        if (isPlayer1Turn) {
            // first player's turn
            val res = move(positions.first, scores.first, steps)
            return if (res.second >= 21) {
                // first player won
                Pair(1, 0)
            } else {
                // get result from second player's turn
                return playWithDiracDice(Pair(res.first, positions.second), Pair(res.second, scores.second), false)
            }
        } else {
            // second player's turn
            val res = move(positions.second, scores.second, steps)
            return if (res.second >= 21) {
                // second player won
                Pair(0, 1)
            } else {
                // get result from first player's turn
                return playWithDiracDice(Pair(positions.first, res.first), Pair(scores.first, res.second), true)
            }
        }
    }

    private fun move(position: Int, score: Int, steps: Int): Pair<Int, Int> {
        val newPosition = (position + steps) % 10
        val newScore = if (newPosition == 0) score + 10 else score + newPosition
        return Pair(newPosition, newScore)
    }

}