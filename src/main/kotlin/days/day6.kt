package days

import Exercise

class Day6 : Exercise {
    override fun a(input: List<String>): String {
        val inputLine = input.first()
        return inputLine.toList().windowed(4)
            .mapIndexed {index, window -> Pair(index, window.toSet().size) }
            .filter { it.second == 4 }
            .first().first
            .plus(4)
            .toString()
    }

    override fun b(input: List<String>): String {
        val inputLine = input.first()
        return inputLine.toList().windowed(14)
            .mapIndexed {index, window -> Pair(index, window.toSet().size) }
            .filter { it.second == 14 }
            .first().first
            .plus(14)
            .toString()
    }
}
