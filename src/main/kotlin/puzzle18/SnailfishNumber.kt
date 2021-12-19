package puzzle18

class SnailfishNumber(leftChildInitial: Any, rightChildInitial: Any) {

    var parent: SnailfishNumber? = null

    var leftChild = leftChildInitial
        set(value) {
            field = value
            if (value is SnailfishNumber) {
                (field as SnailfishNumber).parent = this
            }
        }

    var rightChild = rightChildInitial
        set(value) {
            field = value
            if (value is SnailfishNumber) {
                (field as SnailfishNumber).parent = this
            }
        }

    init {
        if (leftChildInitial is SnailfishNumber) {
            leftChildInitial.parent = this
        }
        if (rightChildInitial is SnailfishNumber) {
            rightChildInitial.parent = this
        }
    }

    override fun toString(): String {
        return "[$leftChild,$rightChild]"
    }

    fun findChildToExplode(level: Int = 0): SnailfishNumber? {
        if (level == 4) {
            return this
        }

        if (leftChild !is Int) {
            val leftResult = (leftChild as SnailfishNumber).findChildToExplode(level + 1)
            if (leftResult != null) return leftResult
        }
        if (rightChild !is Int) {
            return (rightChild as SnailfishNumber).findChildToExplode(level + 1)
        }

        return null
    }

    fun trySplit(): SnailfishNumber? {
        if (leftChild is Int) {
            if (leftChild as Int > 9) {
                return split("left")
            }
        } else {
            val leftResult = (leftChild as SnailfishNumber).trySplit()
            if (leftResult != null) {
                return leftResult
            }
        }

        if (rightChild is Int) {
            if (rightChild as Int > 9) {
                return split("right")
            }
        } else {
            val rightResult = (rightChild as SnailfishNumber).trySplit()
            if (rightResult != null) {
                return rightResult
            }
        }

        return null
    }

    fun calculateMagnitude(): Int {
        return if (leftChild is Int) {
            if (rightChild is Int) {
                3 * leftChild as Int + 2 * rightChild as Int
            } else {
                3 * leftChild as Int + 2 * (rightChild as SnailfishNumber).calculateMagnitude()
            }
        } else if (rightChild is Int) {
            3 * (leftChild as SnailfishNumber).calculateMagnitude() + 2 * rightChild as Int
        } else {
            3 * (leftChild as SnailfishNumber).calculateMagnitude() + 2 * (rightChild as SnailfishNumber).calculateMagnitude()
        }
    }

    private fun split(child: String): SnailfishNumber {
        return if (child == "left") {
            leftChild = SnailfishNumber(
                kotlin.math.floor(leftChild as Int / 2.0).toInt(),
                kotlin.math.ceil(leftChild as Int / 2.0).toInt()
            )
            leftChild as SnailfishNumber
        } else {
            rightChild = SnailfishNumber(
                kotlin.math.floor(rightChild as Int / 2.0).toInt(),
                kotlin.math.ceil(rightChild as Int / 2.0).toInt()
            )
            rightChild as SnailfishNumber
        }
    }

}