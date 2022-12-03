package days

import Exercise

class Day3 : Exercise {
    override fun a(input: List<String>): String {
        return input
            .map { splitIntoCompartments(it) }
            .map { findDuplicate(it) }
            .sumOf { convertToPriority(it) }
            .toString()
    }

    private fun convertToPriority(duplicate: Char): Int {
        return if (duplicate.isUpperCase()) duplicate.code - 38 else duplicate.code - 96
    }

    private fun findDuplicate(compartments: Pair<String, String>): Char {
        return compartments.first.toSet()
            .intersect(compartments.second.toSet())
            .first()
    }

    override fun b(input: List<String>): String {
        return input
            .toString()
    }

    private fun splitIntoCompartments(input: String): Pair<String, String> {
        return Pair(input.substring(0, input.length / 2), input.substring(input.length / 2))
    }

}
