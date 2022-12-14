package days

import Exercise
import java.awt.Point

class Day9 : Exercise {
    override fun a(input: List<String>): String {
        return followTrail(input).toString()
    }

    override fun b(input: List<String>): String {
        return ""
    }

    private fun followTrail(input: List<String>): Int {
        val coordinatesVisitedByHead = visitCoordinatesWithHead(Point(0, 0), input)
        val coordinatesVisitedByTail = visitCoordinatesWithTail(Point(0, 0), coordinatesVisitedByHead)
        return coordinatesVisitedByTail.toSet().count()
    }

    private fun visitCoordinatesWithTail(
        tailCoordinate: Point,
        coordinatesVisitedByHead: MutableList<Point>
    ): MutableList<Point> {
        val coordinatesVisitedByTail = mutableListOf(tailCoordinate)
        coordinatesVisitedByHead.fold(tailCoordinate) { acc, headCoord ->
            val newPos = determineTailCoordinate(acc, headCoord)
            coordinatesVisitedByTail.add(newPos)
            newPos
        }
        return coordinatesVisitedByTail
    }

    private fun visitCoordinatesWithHead(
        headCoordinate: Point,
        input: List<String>
    ): MutableList<Point> {
        val coordinatesVisitedByHead = mutableListOf(headCoordinate)
        commandToSteps(input).fold(headCoordinate) { acc, direction ->
            val newPos = Direction.getNewPosition(acc, direction)
            coordinatesVisitedByHead.add(newPos)
            newPos
        }
        return coordinatesVisitedByHead
    }

    private fun commandToSteps(input: List<String>): List<Direction> {
        return input
            .map { it.split(" ") }
            .flatMap { multiplyIntoDirectionsPerStep(it) }
    }

    private fun multiplyIntoDirectionsPerStep(commandPair: List<String>): List<Direction> {
        return (1..commandPair[1].toInt())
            .map { Direction.valueOf(commandPair[0]) }
    }

    private fun determineTailCoordinate(tailCoordinate: Point, headCoordinate: Point): Point {
        if (headIsCloseEnough(headCoordinate, tailCoordinate)) return tailCoordinate
        val (xDiff, yDiff) = desiredTailMovement(headCoordinate, tailCoordinate)
        return Point(tailCoordinate.x + xDiff, tailCoordinate.y + yDiff)
    }

    private fun desiredTailMovement(headCoordinate: Point, tailCoordinate: Point): Pair<Int, Int> {
        var xDiff = headCoordinate.x - tailCoordinate.x
        var yDiff = headCoordinate.y - tailCoordinate.y
        if (xDiff == 2) xDiff = 1
        if (xDiff == -2) xDiff = -1
        if (yDiff == 2) yDiff = 1
        if (yDiff == -2) yDiff = -1
        return Pair(xDiff, yDiff)
    }

    private fun headIsCloseEnough(headCoordinate: Point, tailCoordinate: Point): Boolean {
        return headCoordinate.distanceSq(tailCoordinate).compareTo(2) <= 0
    }

    enum class Direction {
        U,
        D,
        R,
        L;

        companion object {
            fun getNewPosition(inputCoordinates: Point, direction: Direction): Point = when (direction) {
                U -> Point(inputCoordinates.x, inputCoordinates.y + 1)
                D -> Point(inputCoordinates.x, inputCoordinates.y - 1)
                R -> Point(inputCoordinates.x + 1, inputCoordinates.y)
                L -> Point(inputCoordinates.x - 1, inputCoordinates.y)
            }
        }
    }
}
