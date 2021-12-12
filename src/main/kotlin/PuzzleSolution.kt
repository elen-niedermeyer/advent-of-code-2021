abstract class PuzzleSolution(private val puzzleNumber: String) {

    fun print() {
        var startTime = System.currentTimeMillis()
        val result1 = solvePart1()
        var endTime = System.currentTimeMillis()
        println("$puzzleNumber-01\t $result1 in ${endTime - startTime} ms")
        startTime = System.currentTimeMillis()
        val result2 = solvePart2()
        endTime = System.currentTimeMillis()
        println("$puzzleNumber-02\t $result2 in ${endTime - startTime} ms")
    }

    abstract fun solvePart1(): Number?

    abstract fun solvePart2(): Number?

}