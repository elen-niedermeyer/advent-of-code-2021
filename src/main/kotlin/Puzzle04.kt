import org.apache.commons.csv.CSVFormat

class Puzzle04 {

    fun solvePuzzle(): String? {
        val numberRecords = readCsv("puzzle04numbers.csv", CSVFormat.DEFAULT)
        val numbers = numberRecords?.let { IntArray(it[0].size()) { i -> it[0].get(i).toInt() } }

        val boards = mutableListOf<Puzzle04Board>()
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
                    var newBoard = Puzzle04Board(boardNumbers.toIntArray(), rowLength)
                    boards.add(newBoard)
                    // empty numbers
                    boardNumbers = mutableListOf<Int>()
                }
            }
        }

        return numbers?.let {
            "First winning board: " + getFirstWinningBoard(
                it,
                boards
            ) + "; Last winning board: " + getLastWinningBoard(it, boards)
        }
    }

    fun getFirstWinningBoard(numbers: IntArray, boards: List<Puzzle04Board>): Int? {
        val firstWinningBoard = getWinningBoard(numbers, boards)
        return firstWinningBoard?.let { it.first.calculateFinalScore() * it.second }
    }

    fun getLastWinningBoard(numbers: IntArray, boards: List<Puzzle04Board>): Int? {
        var mutableBoards = boards.toMutableList()
        var nextWinningBoard: Pair<Puzzle04Board, Int>? = null
        while (mutableBoards.size > 0) {
            nextWinningBoard = getWinningBoard(numbers, mutableBoards.toList())
            nextWinningBoard?.let { mutableBoards.remove(it.first) }
        }

        // mutableBoards is now empty
        return nextWinningBoard?.let { it.first.calculateFinalScore() * it.second }
    }

    private fun getWinningBoard(numbers: IntArray, boards: List<Puzzle04Board>): Pair<Puzzle04Board, Int>? {
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