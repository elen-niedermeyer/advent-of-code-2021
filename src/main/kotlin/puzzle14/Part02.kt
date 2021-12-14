package puzzle14

class Part02 {

    fun solve(polymer: String, rules: Map<String, String>, iterations: Int): Long {
        val pairs = polymer.windowed(2, 1)
        var result = pairs.groupingBy { it }.eachCount().mapValues { it.value.toLong() }
        for (i in 1..iterations) {
            result = insert(result, rules)
        }

        val counts = count(result)
        counts[polymer.last()] = counts[polymer.last()]?.plus(1) ?: 1
        val max = counts.maxByOrNull { it.value }?.value
        val min = counts.minByOrNull { it.value }?.value
        return max!! - min!!
    }

    private fun insert(polymerCounts: Map<String, Long>, rules: Map<String, String>): Map<String, Long> {
        val result = mutableMapOf<String, Long>()
        polymerCounts.forEach { (key, value) ->
            val newPair1 = rules[key]?.let { key[0].plus(it) }
            result[newPair1!!] = result[newPair1]?.plus(value) ?: value
            val newPair2 = rules[key]?.plus(key[1])
            result[newPair2!!] = result[newPair2]?.plus(value) ?: value
        }

        return result
    }

    private fun count(result: Map<String, Long>): MutableMap<Char, Long> {
        val counts = mutableMapOf<Char, Long>()
        result.forEach { (key, value) ->
            counts[key[0]] = counts[key[0]]?.plus(value) ?: value
        }

        return counts
    }

}