package puzzle22

import kotlin.math.max
import kotlin.math.min

class Part02 {

    fun solve(input: List<String>): Long {
        val cubes = mutableListOf<Cube>()
        for (instruction in input) {
            val match = "[-]?\\d+".toRegex().findAll(instruction).toList()
            val minX = match[0].value.toInt()
            val maxX = match[1].value.toInt()
            val minY = match[2].value.toInt()
            val maxY = match[3].value.toInt()
            val minZ = match[4].value.toInt()
            val maxZ = match[5].value.toInt()

            val isOn = instruction.startsWith("on")
            val newCube = Cube(minX, maxX, minY, maxY, minZ, maxZ, isOn)
            cubes.addAll(getIntersectedCubes(cubes, newCube))
            if (isOn) {
                cubes.add(newCube)
            }
        }

        var result: Long = 0
        cubes.forEach { result += it.getVolume() }
        return result
    }

    private fun getIntersectedCubes(cubes: List<Cube>, newCube: Cube): List<Cube> {
        val newCubes = mutableListOf<Cube>()
        cubes.forEach {
            if (it.minX < newCube.maxX && it.maxX > newCube.minX
                && it.minY < newCube.maxY && it.maxY > newCube.minY
                && it.minZ < newCube.maxZ && it.maxZ > newCube.minZ
            ) {
                // has intersection
                newCubes.add(
                    Cube(
                        max(it.minX, newCube.minX),
                        min(it.maxX, newCube.maxX),
                        max(it.minY, newCube.minY),
                        min(it.maxY, newCube.maxY),
                        max(it.minZ, newCube.minZ),
                        min(it.maxZ, newCube.maxZ),
                        !it.isOn
                    )
                )
            }
        }

        return newCubes
    }

}