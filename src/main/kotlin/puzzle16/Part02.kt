package puzzle16

class Part02 {

    fun solve(input: String): Long {
        return parseNextPackage(input).first
    }

    private fun parseNextPackage(input: String): Pair<Long, Int> {
        if (!input.contains('1')) {
            return Pair(-1, -1)
        }

        val packetTypeId = input.substring(3, 6).toInt(2)
        if (packetTypeId == 4) {
            // literal
            val result = getLiteralValue(input.substring(6, input.length))
            return Pair(result.first, result.second + 6)
        } else {
            // resolve all subpackages
            val lengthTypeId = input[6].digitToInt(2)

            var currentIndex: Int
            val subPacketValues = mutableListOf<Long>()
            if (lengthTypeId == 0) {
                // next 15 bits indicate the length of sub-packets
                val subPacketsLength = input.substring(7, 22).toInt(2)
                currentIndex = 22
                val lastIndex = 22 + subPacketsLength
                while (currentIndex < lastIndex) {
                    val res = parseNextPackage(input.substring(currentIndex, lastIndex))
                    subPacketValues.add(res.first)
                    currentIndex += res.second
                }
            } else {
                // next 11 bits indicate number of sub-packets
                val subPacketsCount = input.substring(7, 18).toInt(2)
                currentIndex = 18
                var resolvedPackages = 0
                while (resolvedPackages < subPacketsCount) {
                    val res = parseNextPackage(input.substring(currentIndex, input.length))
                    subPacketValues.add(res.first)
                    currentIndex += res.second
                    resolvedPackages++
                }
            }
            return Pair(performOperation(subPacketValues, packetTypeId)!!, currentIndex)
        }
    }

    private fun getLiteralValue(string: String): Pair<Long, Int> {
        var result = ""
        var length = 0
        var index = 0
        while (index < string.length - 4) {
            result += string.substring(index + 1, index + 5)
            length = index + 5
            if (string[index] == '0') {
                break
            }
            index += 5
        }

        return Pair(result.toLong(2), length)
    }

    private fun performOperation(values: List<Long>, packetTypeId: Int): Long? {
        when (packetTypeId) {
            0 -> {
                return values.sum()
            }

            1 -> {
                return values.reduce { acc, i -> acc * i }
            }

            2 -> {
                return values.minOrNull()
            }

            3 -> {
                return values.maxOrNull()
            }

            5 -> {
                return if (values[0] > values[1]) 1 else 0
            }

            6 -> {
                return if (values[0] < values[1]) 1 else 0
            }

            7 -> {
                return if (values[0] == values[1]) 1 else 0
            }

            else -> {
                return null
            }
        }
    }
}