package puzzle17

class Part01 {

    fun solve(input: IntArray): Int {
        // max speed
        val velocity = kotlin.math.abs(input[2]) - 1
        return velocity * (velocity + 1) / 2
    }

}