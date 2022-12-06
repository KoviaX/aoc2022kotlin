package days

import Exercise

class Day6 : Exercise {
    override fun a(input: List<String>): String {
        val inputLine = input.first()
        val windowSize = 4
        return findFirstWindow(inputLine, windowSize)
    }

    override fun b(input: List<String>): String {
        val inputLine = input.first()
        val windowSize = 14
        return findFirstWindow(inputLine, windowSize)
    }

    private fun findFirstWindow(inputLine: String, windowSize: Int) = inputLine.toList()
        .windowed(windowSize)
        .mapIndexed { index, window -> Pair(index, window.toSet().size) }
        .first { it.second == windowSize }.first
        .plus(windowSize)
        .toString()
}
