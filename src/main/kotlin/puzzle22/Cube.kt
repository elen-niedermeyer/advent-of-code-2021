package puzzle22

class Cube(
    val minX: Int,
    val maxX: Int,
    val minY: Int,
    val maxY: Int,
    val minZ: Int,
    val maxZ: Int,
    val isOn: Boolean
) {

    fun getVolume(): Long {
        return (maxX.toLong() - minX.toLong() + 1) * (maxY.toLong() - minY.toLong() + 1) * (maxZ.toLong() - minZ.toLong() + 1) * (if (isOn) 1 else -1)
    }
}