package puzzle16

class Part01 {

    fun solve(input:String): Int {
        return getVersionNumberSum(input)
    }

    private fun getVersionNumberSum(input: String): Int {
        var versionNumberSum = 0
        var pointer = 0

        while (input.substring(pointer, input.length).contains('1')) {
            versionNumberSum += input.substring(pointer, pointer + 3).toInt(2)
            val packetTypeId = input.substring(pointer + 3,pointer + 6).toInt(2)

            if (packetTypeId == 4) {
                val packageValueLength = getPackageValueLength(input.substring(pointer + 6, input.length))
                pointer += 6 + packageValueLength
            } else {
                // subpackages
                val lengthTypeId = input[pointer + 6].digitToInt(2)
                if (lengthTypeId == 0) {
                    // next 15 bits indicate the length of sub-packets
                    pointer += 7 + 15
                } else if (lengthTypeId == 1) {
                    // next 11 bits indicate number of sub-packets
                    pointer += 7 + 11
                }
            }
        }

        return versionNumberSum
    }

    private fun getPackageValueLength(string: String): Int {
        var length = 0

        for (i in string.indices) {
            if (i % 5 == 0 && string[i] == '0') {
                length = i + 5
                break
            }
        }

        return length
    }
}