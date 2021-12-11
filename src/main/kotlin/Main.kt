import puzzle04.Puzzle
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.File

fun main() {
    println("Hello Advent of Code!")
    println("Part\t Result Value\t Time in ms")

    var startTime = System.currentTimeMillis()
    var resultInt = puzzle01.Puzzle().solvePart1()
    var endTime = System.currentTimeMillis()
    println("01-01\t ${resultInt}\t\t\t ${endTime-startTime}")
    startTime = System.currentTimeMillis()
    resultInt = puzzle01.Puzzle().solvePart2()
    endTime = System.currentTimeMillis()
    println("01-02\t ${resultInt}\t\t\t ${endTime-startTime}")

    startTime = System.currentTimeMillis()
    var resultIntNullable = puzzle02.Puzzle().solvePart1()
    endTime = System.currentTimeMillis()
    println("02-01\t ${resultIntNullable}\t\t ${endTime-startTime}")
    startTime = System.currentTimeMillis()
    resultIntNullable = puzzle02.Puzzle().solvePart2()
    endTime = System.currentTimeMillis()
    println("02-02\t ${resultIntNullable}\t\t ${endTime-startTime}")

    startTime = System.currentTimeMillis()
    resultInt = puzzle03.Puzzle().solvePart1()
    endTime = System.currentTimeMillis()
    println("03-01\t ${resultInt}\t\t ${endTime-startTime}")
    startTime = System.currentTimeMillis()
    resultInt = puzzle03.Puzzle().solvePart2()
    endTime = System.currentTimeMillis()
    println("03-02\t ${resultInt}\t\t\t ${endTime-startTime}")

    startTime = System.currentTimeMillis()
    resultIntNullable = puzzle04.Puzzle().solvePart1()
    endTime = System.currentTimeMillis()
    println("04-01\t ${resultIntNullable}\t\t\t ${endTime-startTime}")
    startTime = System.currentTimeMillis()
    resultIntNullable = puzzle04.Puzzle().solvePart2()
    endTime = System.currentTimeMillis()
    println("04-02\t ${resultIntNullable}\t\t\t ${endTime-startTime}")

    println("Puzzle 05: " + Puzzle05().solvePuzzle())
    println("Puzzle 06: " + Puzzle06().solvePuzzle())
    println("Puzzle 07: " + Puzzle07().solvePuzzle())
    println("Puzzle 08: " + Puzzle08().solvePuzzle())
    println("Puzzle 09: " + Puzzle09().solvePuzzle())
    println("Puzzle 10: " + Puzzle10().solvePuzzle())
    println("Puzzle 11: " + Puzzle11().solvePuzzle())
}

fun readCsv(fileName: String, csvFormat: CSVFormat): MutableList<CSVRecord>? {
    val res = {}.javaClass.getResource(fileName)
    val bufferedReader = File(res.file).bufferedReader()
    val csvParser = CSVParser(bufferedReader, csvFormat)
    return csvParser.records
}

fun readLines(fileName: String): List<String> {
    val res = {}.javaClass.getResource(fileName)
    return File(res.file).readLines()
}
