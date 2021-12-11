class Puzzle11 {

    fun solvePuzzle(): String {
        val textLines = readLines("puzzle11.txt")
        val input1 = mutableListOf<Puzzle11Octopus>()
        val input2 = mutableListOf<Puzzle11Octopus>()
        for (i in textLines.indices) {
            for (j in textLines[0].indices) {
                input1.add(Puzzle11Octopus(Pair(i, j), textLines[i][j].digitToInt()))
                input2.add(Puzzle11Octopus(Pair(i, j), textLines[i][j].digitToInt()))
            }
        }

        return "Flashes after 100 iterations: " + getFlashesCount(input1) +
                "; All flashing in iteration: " + getIterationWithAllFlashing(input2)
    }

    fun getFlashesCount(octopuses: MutableList<Puzzle11Octopus>): Int {
        var flashesCount = 0

        for (step in 0..99) {
            // increase all
            octopuses.forEach { it.increaseEnergyLevel() }

            // let them flash
            while (octopuses.count { it.energyLevel > 9 } > 0) {
                octopuses.forEach {
                    if (it.energyLevel > 9) {
                        flashOctopus(octopuses, it)
                    }
                }
            }

            // count flashed octopuses
            flashesCount += octopuses.count { it.energyLevel == 0 }
        }

        return flashesCount
    }

    fun getIterationWithAllFlashing(octopuses: MutableList<Puzzle11Octopus>): Int {
        var iterationCount = 0

        while (octopuses.count { it.energyLevel == 0 } != octopuses.size) {
            // increase all
            octopuses.forEach { it.increaseEnergyLevel() }

            // let them flash
            while (octopuses.count { it.energyLevel > 9 } > 0) {
                octopuses.forEach {
                    if (it.energyLevel > 9) {
                        flashOctopus(octopuses, it)
                    }
                }
            }

            iterationCount++
        }

        return iterationCount
    }

    private fun flashOctopus(octopuses: MutableList<Puzzle11Octopus>, flashingOctopus: Puzzle11Octopus) {
        octopuses.find { it.position.first == flashingOctopus.position.first - 1 && it.position.second == flashingOctopus.position.second - 1 }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first - 1 && it.position.second == flashingOctopus.position.second }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first - 1 && it.position.second == flashingOctopus.position.second + 1 }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first && it.position.second == flashingOctopus.position.second - 1 }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first && it.position.second == flashingOctopus.position.second + 1 }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first + 1 && it.position.second == flashingOctopus.position.second - 1 }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first + 1 && it.position.second == flashingOctopus.position.second }
            ?.increaseEnergyLevelIfNotFlashed()
        octopuses.find { it.position.first == flashingOctopus.position.first + 1 && it.position.second == flashingOctopus.position.second + 1 }
            ?.increaseEnergyLevelIfNotFlashed()

        flashingOctopus.flash()
    }

}