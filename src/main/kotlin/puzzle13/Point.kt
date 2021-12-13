package puzzle13

class Point(var x: Int, var y: Int) {

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return this.x == other.x && this.y == other.y
        }
        return false
    }

}