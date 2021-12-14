package puzzle14

class Part01 {

    fun solve(polymer: String, rules: Map<String, String>, iterations: Int): Int {
        var result = polymer
        for (i in 1..iterations) {
            result = insert(result, rules)
        }

        val counts = result.groupingBy { it }.eachCount().mapValues { it.value }
        val max = counts.maxByOrNull { it.value }?.value
        val min = counts.minByOrNull { it.value }?.value
        return max!! - min!!
    }

    private fun insert(polymer: String, rules: Map<String, String>): String {
        var result = polymer[0].toString()
        val pairs = polymer.windowed(2, 1)
        for (pair in pairs) {
            result += rules[pair] + pair[1]
        }

        return result
    }
}