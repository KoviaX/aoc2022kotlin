package days

import Exercise

class Day4 : Exercise {
    override fun a(input: List<String>): String {
        return input
            .map { getRanges(it) }
            .fold(0) { acc, values: Pair<IntRange, IntRange> -> determineListFullyOverlaps(values, acc) }
            .toString()
    }

    override fun b(input: List<String>): String {
        return input
            .map { getRanges(it) }
            .fold(0) { acc, values: Pair<IntRange, IntRange> -> determineListOverlaps(values, acc) }
            .toString()
    }

    private fun determineListFullyOverlaps(values: Pair<IntRange, IntRange>, acc: Int): Int {
        val firstSet = values.first.toSet()
        val secondSet = values.second.toSet()
        return if (firstSet.intersect(values.second) == firstSet || secondSet.intersect(values.first) == secondSet) {
            acc + 1
        } else acc
    }

    private fun determineListOverlaps(values: Pair<IntRange, IntRange>, acc: Int): Int {
        val firstSet = values.first.toSet()
        return if (firstSet.intersect(values.second).isNotEmpty()) {
            acc + 1
        } else acc
    }

    private fun getRanges(it: String): Pair<IntRange, IntRange> {
        val ranges = it.split(",")
            .map { stringToRange(it) }
        return Pair(ranges[0], ranges[1])
    }

    private fun stringToRange(it: String): IntRange {
        val rangesAsString = it.split("-")
        val first = rangesAsString.first().toInt()
        val last = rangesAsString.last().toInt()
        return first..last
    }

}
