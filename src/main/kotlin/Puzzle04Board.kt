class Puzzle04Board(private val numbers: IntArray, private val rowLength: Int) {
    private val boardElements: List<Puzzle04BoardElement>

    init {
        val tempBoardElements = mutableListOf<Puzzle04BoardElement>()
        for (i in numbers) {
            tempBoardElements.add(Puzzle04BoardElement(i, false))
        }
        boardElements = tempBoardElements.toList()
    }

    fun mark(calledNumber: Int) {
        boardElements.forEach { it ->
            if (it.value == calledNumber) {
                it.isMarked = true
            }
        }
    }

    fun hasBingo(): Boolean {
        val rows = boardElements.windowed(rowLength, rowLength)

        // check rows
        for (row in rows) {
            var hasOnlyMarkedNumbers = true
            row.forEach { it ->
                if (!it.isMarked) {
                    hasOnlyMarkedNumbers = false
                }
            }
            if (hasOnlyMarkedNumbers) {
                // that is a bingo
                return true
            }
        }

        // check columns
        for (i in 0 until rowLength) {
            var hasOnlyMarkedNumbers = true
            for (row in rows) {
                if (!row[i].isMarked) {
                    hasOnlyMarkedNumbers = false
                }
            }
            if (hasOnlyMarkedNumbers) {
                // that is a bingo
                return true
            }
        }

        // no bingo
        return false
    }

    fun calculateFinalScore(): Int {
        var sum = 0
        boardElements.forEach { it ->
            if (!it.isMarked) {
                sum += it.value
            }
        }
        return sum
    }

}