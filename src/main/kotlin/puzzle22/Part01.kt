package puzzle22

class Part01 {

    fun solve(input: List<String>): Int {
        var cubes = mutableListOf<Triple<Int, Int, Int>>()
        for (instruction in input) {
            val match = "[-]?\\d+".toRegex().findAll(instruction).toList()
            val minX = match[0].value.toInt()
            val maxX = match[1].value.toInt()
            val minY = match[2].value.toInt()
            val maxY = match[3].value.toInt()
            val minZ = match[4].value.toInt()
            val maxZ = match[5].value.toInt()

            if (instruction.startsWith("on")) {
                cubes = turnOn(cubes, minX..maxX, minY..maxY, minZ..maxZ).toMutableList()
            } else {
                // turn off
                turnOff(cubes, minX..maxX, minY..maxY, minZ..maxZ)
            }
        }

        return cubes.size
    }

    private fun turnOn(
        cubes: MutableList<Triple<Int, Int, Int>>,
        xRange: IntRange,
        yRange: IntRange,
        zRange: IntRange
    ): List<Triple<Int, Int, Int>> {
        for (x in xRange) {
            if (x >= -50 && x <= 50) {
                for (y in yRange) {
                    if (y >= -50 && y <= 50) {
                        for (z in zRange) {
                            if (z >= -50 && z <= 50)
                                cubes.add(Triple(x, y, z))
                        }
                    }
                }
            }
        }

        return cubes.distinctBy { Triple(it.first, it.second, it.third) }
    }

    private fun turnOff(
        cubes: MutableList<Triple<Int, Int, Int>>,
        xRange: IntRange,
        yRange: IntRange,
        zRange: IntRange
    ) {
        cubes.removeIf { it.first in xRange && it.second in yRange && it.third in zRange }
    }

}