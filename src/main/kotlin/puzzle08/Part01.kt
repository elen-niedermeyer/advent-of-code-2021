package puzzle08

import org.apache.commons.csv.CSVFormat
import readCsv

class Part01 {

    fun solve(): Int? {
        val records = readCsv("puzzle08.csv", CSVFormat.newFormat('|'))
        val segmentOutput = records?.let { List(it.size) { i -> it[i].get(1).split(' ') } }
        return segmentOutput?.let { countUniqueSequentNumbers(it) }
    }

    private fun countUniqueSequentNumbers(segmentOutput: List<List<String>>): Int {
        val flattenArray = segmentOutput.flatten()
        return flattenArray.count { it.length == 2 || it.length == 3 || it.length == 4 || it.length == 7 }
    }

}