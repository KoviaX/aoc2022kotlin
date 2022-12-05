package days

import Exercise

class Day5 : Exercise {
    override fun a(input: List<String>): String {
        val (initialStacks, initialMoves, amountOfStacks) = getInputs(input)

        val stacks = fillStacks(initialStacks.dropLast(1), amountOfStacks)
        val moves = initialMoves.map { createMove(it) }

        moves.forEach { move ->
            stacks[move.to].crates.addAll(stacks[move.from].crates.takeLast(move.amount).reversed())
            repeat(move.amount) { stacks[move.from].crates.removeLast() }
        }

        return stacks.map { it.crates.last() }
            .fold("") {acc, value -> acc + value}
    }

    private fun getInputs(input: List<String>): Triple<List<String>, List<String>, Int> {
        val inputLinesSplitByCategory = input.joinToString("\n").split("\n\n")
        val initialStacks = inputLinesSplitByCategory[0].lines()
        val initialMoves = inputLinesSplitByCategory[1].lines()
        val amountOfStacks = initialStacks.reversed()[0].last().digitToInt()
        return Triple(initialStacks, initialMoves, amountOfStacks)
    }

    override fun b(input: List<String>): String {
        return input
            .toString()
    }

    private fun fillStacks(initialStacksAsLines: List<String>, stackAmount: Int): MutableList<CargoStack> {
        val stacks: MutableList<MutableList<Char>> = MutableList(stackAmount) { mutableListOf() }
        initialStacksAsLines.reversed()
            .forEach {
                it.chunked(4).forEachIndexed { i, str ->
                    if (str[1].isLetter()) stacks[i].add(str[1])
                }
            }
        return stacks.map { stack -> CargoStack(stack) }.toMutableList()
    }


    private fun createMove(line: String): Move {
        val result = line.split(" ")
        val amount = result[1].toInt()
        val from = result[3].toInt() - 1
        val to = result[5].toInt() - 1
        return Move(amount, from, to)
    }

    data class CargoStack(var crates: MutableList<Char>)
    data class Move(val amount: Int, val from: Int, val to: Int)

}
//[    [D], [N] [C], [Z] [M] [P],  1   2   3]
