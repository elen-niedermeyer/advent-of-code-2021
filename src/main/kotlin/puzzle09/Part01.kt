package puzzle09

class Part01 {

    fun solve(): Int {
        val input = Puzzle().readInput()
        val lowPointRiskLevels = mutableListOf<Int>()

        val lowPoints = Puzzle().getLowPoints(input)
        lowPoints.forEach { lowPointRiskLevels.add(it.value + 1) }

        return lowPointRiskLevels.sum()
    }

}