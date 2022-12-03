package days

import Exercise

class Day2 : Exercise {
    override fun a(input: List<String>): String {
        return input
            .sumOf { determineRoundScore(it) }
            .toString()
    }

    override fun b(input: List<String>): String {
        return "1"
    }

    private fun determineRoundScore(inputLine: String): Int {
        val gameValues = inputLine.split(" ")
        val valuesAsEnum = gameValues.map { HandShape.fromString(it) }
        return calculateRoundResult(valuesAsEnum.last(), valuesAsEnum.first())
    }

    private fun calculateRoundResult(mine: HandShape, theirs: HandShape): Int {
        when (mine) {
            HandShape.ROCK -> {
                return when (theirs) {
                    HandShape.ROCK -> 1 + 3
                    HandShape.PAPER -> 1 + 0
                    HandShape.SCISSORS -> 1 + 6
                }
            }
            HandShape.PAPER -> {
                return when (theirs) {
                    HandShape.ROCK -> 2 + 6
                    HandShape.PAPER -> 2 + 3
                    HandShape.SCISSORS -> 2 + 0
                }
            }
            HandShape.SCISSORS -> {
                return when (theirs) {
                    HandShape.ROCK -> 3 + 0
                    HandShape.PAPER -> 3 + 6
                    HandShape.SCISSORS -> 3 + 3
                }
            }

        }
    }


}


enum class HandShape(pointValue: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {
        fun fromString(value: String): HandShape = when (value) {
            "A", "X" -> ROCK
            "B", "Y" -> PAPER
            "C", "Z" -> SCISSORS
            else -> throw Exception("No such shape recognized")
        }
    }
}

