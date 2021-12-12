package puzzle11

import PuzzleSolution
import readLines

class Puzzle : PuzzleSolution("11") {

    override fun solvePart1(): Int {
        return getFlashesCount(readInput())
    }

    override fun solvePart2(): Int {
        return getIterationWithAllFlashing(readInput())
    }

    private fun readInput(): MutableList<Octopus> {
        val textLines = readLines("puzzle11.txt")
        val input = mutableListOf<Octopus>()
        for (i in textLines.indices) {
            for (j in textLines[0].indices) {
                input.add(Octopus(Pair(i, j), textLines[i][j].digitToInt()))
            }
        }

        return input
    }

    private fun getFlashesCount(octopuses: MutableList<Octopus>): Int {
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

    private fun getIterationWithAllFlashing(octopuses: MutableList<Octopus>): Int {
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

    private fun flashOctopus(octopuses: MutableList<Octopus>, flashingOctopus: Octopus) {
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