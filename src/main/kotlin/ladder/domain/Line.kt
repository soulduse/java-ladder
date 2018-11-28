package ladder.domain

import ladder.domain.generators.RandomPointGenerator
import java.util.*

class Line {
    private val points: ArrayList<Point>

    constructor(countOfPerson: Int) {
        this.points = RandomPointGenerator.generator2(countOfPerson)
    }

    constructor(points: ArrayList<Point>) {
        this.points = points
    }

    fun drawLine(): String {
        val line = StringBuilder(START_EMPTY_SPACES + VERTICAL)
        for (i in 0 until points.size) {
            line.append(drawFillToEmptyRoom(getFillCharacter(points[i])))
            line.append(VERTICAL)
        }
        return line.toString()
    }

    private fun drawFillToEmptyRoom(fillCharacter: String): String {
        val fillText = StringBuilder()
        for (i in 0 until Player.MAX_NAME_SIZE) {
            fillText.append(fillCharacter)
        }
        return fillText.toString()
    }

    private fun getFillCharacter(point: Point): String {
        val direction = Direction.findDirection(point)
        return if (direction == Direction.RIGHT) DASH else SPACE
    }

    private fun getFillCharacter(isPointed: Boolean): String {
        return if (isPointed) DASH else SPACE
    }

    companion object {
        const val START_EMPTY_SPACES = "     "
        private const val VERTICAL = "|"
        private const val SPACE = " "
        private const val DASH = "-"
    }
}
