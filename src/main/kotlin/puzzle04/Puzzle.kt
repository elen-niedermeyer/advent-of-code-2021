package puzzle04

import PuzzleSolution
import org.apache.commons.csv.CSVFormat
import readCsv

class Puzzle : PuzzleSolution("04") {

    override fun solvePart1(): Int? {
        return readNumberInput()?.let { getFirstWinningBoard(it, readBoardInput()) }
    }

    override fun solvePart2(): Int? {
        return readNumberInput()?.let { getLastWinningBoard(it, readBoardInput()) }
    }

    private fun readNumberInput(): IntArray? {
        val numberRecords = readCsv("puzzle04numbers.csv", CSVFormat.DEFAULT)
        return numberRecords?.let { IntArray(it[0].size()) { i -> it[0].get(i).toInt() } }
    }

    private fun readBoardInput(): List<Board> {
        val boards = mutableListOf<Board>()
        val boardRecords = readCsv("puzzle04boards.csv", CSVFormat.newFormat(' '))
        if (boardRecords != null) {
            var boardNumbers = mutableListOf<Int>()
            var rowLength = 0
            for (record in boardRecords) {
                if (record.size() > 1) {
                    val filteredRecord = record.filter { s -> s != "" }
                    rowLength = filteredRecord.size
                    for (elem in filteredRecord) {
                        boardNumbers.add(elem.toInt())
                    }
                } else {
                    // one board complete
                    val newBoard = Board(boardNumbers.toIntArray(), rowLength)
                    boards.add(newBoard)
                    // empty numbers
                    boardNumbers = mutableListOf()
                }
            }
        }

        return boards
    }

    private fun getFirstWinningBoard(numbers: IntArray, boards: List<Board>): Int? {
        val firstWinningBoard = getWinningBoard(numbers, boards)
        return firstWinningBoard?.let { it.first.calculateFinalScore() * it.second }
    }

    private fun getLastWinningBoard(numbers: IntArray, boards: List<Board>): Int? {
        val mutableBoards = boards.toMutableList()
        var nextWinningBoard: Pair<Board, Int>? = null
        while (mutableBoards.size > 0) {
            nextWinningBoard = getWinningBoard(numbers, mutableBoards.toList())
            nextWinningBoard?.let { mutableBoards.remove(it.first) }
        }

        // mutableBoards is now empty
        return nextWinningBoard?.let { it.first.calculateFinalScore() * it.second }
    }

    private fun getWinningBoard(numbers: IntArray, boards: List<Board>): Pair<Board, Int>? {
        for (calledNumber in numbers) {
            for (board in boards) {
                board.mark(calledNumber)
                val hasWon = board.hasBingo()
                if (hasWon) {
                    return Pair(board, calledNumber)
                }
            }
        }

        return null
    }

}