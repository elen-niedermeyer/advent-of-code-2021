package puzzle17

class Part02 {

    fun solve(input: IntArray): Int {
        return getAllInitialVelocities(input).size
    }

    private fun getAllInitialVelocities(input: IntArray): List<Pair<Int, Int>> {
        val velocities = mutableListOf<Pair<Int, Int>>()
        for (x in 2..input[1]) {
            for (y in input[2]..kotlin.math.abs(input[2])) {
                val velocity = Pair(x, y)
                if (isInTargetArea(input, velocity)) {
                    velocities.add(velocity)
                }
            }
        }

        return velocities.distinctBy { Pair(it.first, it.second) }
    }

    private fun isInTargetArea(area: IntArray, velocity: Pair<Int, Int>): Boolean {
        var nextPoint = velocity.copy()
        var diffX = velocity.first
        var diffY = velocity.second
        while (nextPoint.first <= area[1] && nextPoint.second >= area[2]) {
            if (nextPoint.first >= area[0] && nextPoint.first <= area[1] && nextPoint.second >= area[2] && nextPoint.second <= area[3]) {
                return true
            }

            diffX--
            val nextX = if (diffX > 0) nextPoint.first + diffX else nextPoint.first
            diffY--
            val nextY = nextPoint.second + diffY

            nextPoint = Pair(nextX, nextY)
        }

        return false
    }
}