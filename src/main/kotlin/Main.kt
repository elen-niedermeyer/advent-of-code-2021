import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.File

fun main(args: Array<String>) {
    println("Hello Advent of Code!")

    println("Puzzle 01: " + Puzzle01().solvePuzzle())
    println("Puzzle 02: " + Puzzle02().solvePuzzle())
    println("Puzzle 03: " + Puzzle03().solvePuzzle())
    println("Puzzle 04: " + Puzzle04().solvePuzzle())
    println("Puzzle 05: " + Puzzle05().solvePuzzle())
    println("Puzzle 06: " + Puzzle06().solvePuzzle())
    println("Puzzle 07: " + Puzzle07().solvePuzzle())
}

fun readCsv(fileName: String, csvFormat: CSVFormat): MutableList<CSVRecord>? {
    val res = {}.javaClass.getResource(fileName)
    val bufferedReader = File(res.file).bufferedReader()
    val csvParser = CSVParser(bufferedReader, csvFormat)
    return csvParser.records
}

fun readLines(fileName: String): List<String> {
    val res = {}.javaClass.getResource(fileName)
    val lines = File(res.file).readLines()
    return lines
}