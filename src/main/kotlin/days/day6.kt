package days

import Exercise

class Day6 : Exercise {
    override fun a(input: List<String>): String {
        return findFirstWindow(input.first(), 4)
    }

    override fun b(input: List<String>): String {
        return findFirstWindow(input.first(), 14)
    }

    private fun findFirstWindow(inputLine: String, windowSize: Int) = inputLine.toList()
        .windowed(windowSize)
        .mapIndexed { index, window -> Pair(index, window.toSet().size) }
        .first { it.second == windowSize }.first
        .plus(windowSize)
        .toString()
}
