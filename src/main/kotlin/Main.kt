import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    println("Hello Advent of Code!")

    println("Puzzle 01: " + Puzzle01().solvePuzzle())
    println("Puzzle 02: " + Puzzle02().solvePuzzle())
    println("Puzzle 03: " + Puzzle03().solvePuzzle())
}

fun readInput(fileName: String, csvFormat: CSVFormat): MutableList<CSVRecord>? {
    val res = {}.javaClass.getResource(fileName)
    val bufferedReader = File(res.file).bufferedReader()
    val csvParser = CSVParser(bufferedReader, csvFormat)
    return csvParser.records
}