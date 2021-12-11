class Puzzle11Octopus(val position: Pair<Int, Int>, var energyLevel: Int) {

    fun increaseEnergyLevel() {
        energyLevel++
    }

    fun increaseEnergyLevelIfNotFlashed() {
        if (energyLevel > 0) {
            energyLevel++
        }
    }

    fun flash() {
        if (energyLevel > 9) {
            energyLevel = 0
        }
    }

}