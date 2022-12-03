package days

import Exercise

class Day2 : Exercise {
    override fun a(input: List<String>): String {
        return input
            .sumOf { determineRoundScoreA(it) }
            .toString()
    }

    override fun b(input: List<String>): String {
        return input
            .sumOf { determineRoundScoreB(it) }
            .toString()
    }

    private fun determineRoundScoreA(inputLine: String): Int {
        val gameValues = inputLine.split(" ")
        val valuesAsEnum = gameValues.map { HandShape.fromString(it) }
        return calculateRoundResultA(valuesAsEnum.last(), valuesAsEnum.first())
    }

    private fun determineRoundScoreB(inputLine: String): Int {
        val gameValues = inputLine.split(" ")
        val valuesAsEnums = Pair(HandShape.fromString(gameValues[0]), GameResult.fromString(gameValues[1]))
        return calculateRoundResultB(valuesAsEnums.first, valuesAsEnums.second)
    }

    private fun calculateRoundResultA(mine: HandShape, theirs: HandShape): Int {
        when (mine) {
            HandShape.ROCK -> {
                return HandShape.ROCK.pointValue +
                when (theirs) {
                    HandShape.PAPER -> GameResult.LOSE.pointValue
                    HandShape.ROCK -> GameResult.DRAW.pointValue
                    HandShape.SCISSORS -> GameResult.WIN.pointValue
                }
            }
            HandShape.PAPER -> {
                return HandShape.PAPER.pointValue +
                when (theirs) {
                    HandShape.SCISSORS -> GameResult.LOSE.pointValue
                    HandShape.PAPER -> GameResult.DRAW.pointValue
                    HandShape.ROCK -> GameResult.WIN.pointValue
                }
            }
            HandShape.SCISSORS -> {
                return HandShape.SCISSORS.pointValue +
                when (theirs) {
                    HandShape.ROCK -> GameResult.LOSE.pointValue
                    HandShape.SCISSORS -> GameResult.DRAW.pointValue
                    HandShape.PAPER -> GameResult.WIN.pointValue
                }
            }
        }
    }

    private fun calculateRoundResultB(theirs: HandShape, desiredResult: GameResult): Int {
        when (theirs) {
            HandShape.ROCK -> {
                return when (desiredResult) {
                    GameResult.DRAW -> HandShape.ROCK.pointValue + GameResult.DRAW.pointValue
                    GameResult.WIN -> HandShape.PAPER.pointValue + GameResult.WIN.pointValue
                    GameResult.LOSE -> HandShape.SCISSORS.pointValue + GameResult.LOSE.pointValue
                }
            }
            HandShape.PAPER -> {
                return when (desiredResult) {
                    GameResult.DRAW -> HandShape.PAPER.pointValue + GameResult.DRAW.pointValue
                    GameResult.WIN -> HandShape.SCISSORS.pointValue + GameResult.WIN.pointValue
                    GameResult.LOSE -> HandShape.ROCK.pointValue + GameResult.LOSE.pointValue
                }
            }
            HandShape.SCISSORS -> {
                return when (desiredResult) {
                    GameResult.DRAW -> HandShape.SCISSORS.pointValue + GameResult.DRAW.pointValue
                    GameResult.WIN -> HandShape.ROCK.pointValue + GameResult.WIN.pointValue
                    GameResult.LOSE -> HandShape.PAPER.pointValue + GameResult.LOSE.pointValue
                }
            }
        }
    }


}


enum class HandShape(val pointValue: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    companion object {
        fun fromString(value: String): HandShape = when (value) {
            "A", "X"-> ROCK
            "B", "Y"-> PAPER
            "C", "Z" -> SCISSORS
            else -> throw Exception("No such shape recognized")
        }
    }
}

enum class GameResult(val pointValue: Int) {
    WIN(6),
    LOSE(0),
    DRAW(3);

    companion object {
        fun fromString(value: String): GameResult = when (value) {
            "X"-> LOSE
            "Y" -> DRAW
            "Z"-> WIN
            else -> throw Exception("No such result recognized")
        }
    }
}

