package puzzle08

import org.apache.commons.csv.CSVFormat
import readCsv

class Part02 {

    fun solve(): Int? {
        val records = readCsv("puzzle08.csv", CSVFormat.newFormat('|'))
        val signals = records?.let { List(it.size) { i -> it[i].get(0).split(' ') } }
        val segmentOutput = records?.let { List(it.size) { i -> it[i].get(1).split(' ') } }
        return segmentOutput?.let {
            signals?.let {
                decodeOutputValues(
                    it, segmentOutput
                )
            }
        }
    }

    private fun decodeOutputValues(signals: List<List<String>>, segmentOutput: List<List<String>>): Int {
        var sum = 0
        for (i in signals.indices) {
            val signalMap = mapSignals(signals[i])
            val output = decodeOutput(segmentOutput[i], signalMap)
            sum += output
        }

        return sum
    }

    private fun mapSignals(signals: List<String>): Map<String, String> {
        val mutableSignals = signals.toMutableList()
        val mapping = mutableMapOf<String, String>()
        // 1, 4, 7, 8
        mutableSignals.find { it.length == 2 }?.let { signal ->
            mapping["1"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 1
        mutableSignals.find { it.length == 4 }?.let { signal ->
            mapping["4"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 4
        mutableSignals.find { it.length == 3 }?.let { signal ->
            mapping["7"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 7
        mutableSignals.find { it.length == 7 }?.let { signal ->
            mapping["8"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 8

        // 9 is the only remaining containing 4
        mutableSignals.find { it.toList().containsAll(mapping["4"]!!.toList()) }?.let { signal ->
            mapping["9"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 9

        // 0 has length 6 and contains 1
        mutableSignals.find { it.length == 6 && it.toList().containsAll(mapping["1"]!!.toList()) }?.let { signal ->
            mapping["0"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 0

        // 6 is the only remaining with length 6
        mutableSignals.find { it.length == 6 }?.let { signal ->
            mapping["6"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 6

        // 3 is the only remaining containing 7
        mutableSignals.find { it.toList().containsAll(mapping["7"]!!.toList()) }?.let { signal ->
            mapping["3"] = signal.alphabetized()
            mutableSignals.remove(signal)
        } // 3

        // 2 and 5
        if (mutableSignals[0].count { c -> c in mapping["6"]!! } > mutableSignals[1].count { c -> c in mapping["6"]!! }) {
            // index 0 is 5
            mapping["5"] = mutableSignals[0].alphabetized()
            mapping["2"] = mutableSignals[1].alphabetized()
        } else {
            // index 1 is 5
            mapping["5"] = mutableSignals[1].alphabetized()
            mapping["2"] = mutableSignals[0].alphabetized()
        }

        // reverse map for returning
        return mapping.entries.associateBy({ it.value }) { it.key }
    }

    private fun decodeOutput(outputSignals: List<String>, signalMap: Map<String, String>): Int {
        var output = ""
        for (signal in outputSignals) {
            if (signal.isNotEmpty()) {
                output += signalMap[signal.alphabetized()]
            }
        }

        return output.toInt()
    }

    private fun String.alphabetized() = String(toCharArray().apply { sort() })

}