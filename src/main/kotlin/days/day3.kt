package days

import Exercise

class Day3 : Exercise {
    override fun a(input: List<String>): String {
        return input
            .map { splitIntoCompartments(it) }
            .map { findDuplicateA(it) }
            .map { convertToPriority(it) }
            .sum()
            .toString()
    }

    override fun b(input: List<String>): String {
        return input
            .chunked(3)
            .map { findDuplicateB(it) }
            .map { convertToPriority(it) }
            .sum()
            .toString()
    }

    private fun convertToPriority(duplicate: Char): Int {
        return if (duplicate.isUpperCase()) duplicate.code - 38 else duplicate.code - 96
    }

    private fun findDuplicateA(compartments: Pair<String, String>): Char {
        return compartments.first.toSet()
            .intersect(compartments.second.toSet())
            .first()
    }
    private fun findDuplicateB(input: List<String>): Char {
        val first = input[0].toSet()
        val second = input[1].toSet()
        val third = input[2].toSet()
        return first.toSet()
            .intersect(second)
            .intersect(third)
            .first()
    }

    private fun splitIntoCompartments(input: String): Pair<String, String> {
        return Pair(input.substring(0, input.length / 2), input.substring(input.length / 2))
    }

}
