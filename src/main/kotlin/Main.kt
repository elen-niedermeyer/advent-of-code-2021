import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.File

fun main() {
    println("Hello Advent of Code!")

    val solutions = arrayOf(
        puzzle01.Puzzle(),
        puzzle02.Puzzle(),
        puzzle03.Puzzle(),
        puzzle04.Puzzle(),
        puzzle05.Puzzle(),
        puzzle06.Puzzle(),
        puzzle07.Puzzle(),
        puzzle08.Puzzle(),
        puzzle09.Puzzle(),
        puzzle10.Puzzle(),
        puzzle11.Puzzle(),
        puzzle12.Puzzle(),
        puzzle13.Puzzle(),
        puzzle14.Puzzle(),
        puzzle15.Puzzle()
    )

    println("Part\t Result")

    for (solution in solutions) {
        solution.print()
    }
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
