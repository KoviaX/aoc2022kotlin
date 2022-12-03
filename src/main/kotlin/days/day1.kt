package days

import Exercise

class Day1 : Exercise {
    override fun a(input: List<String>): String {
        return totalsPerElf(input).max().toString()
    }

    override fun b(input: List<String>): String {
        val result = totalsPerElf(input)
            .sortedDescending()
            .take(3)
            .sum()

        return result.toString()
    }

    private fun totalsPerElf(input: List<String>): List<Int> {
        val elfList = splitAfter(input, "")
        val totals = elfList
            .map { listOfLists ->
                listOfLists
                    .map { entries -> if (entries.isNotBlank()) entries.toInt() else 0 }
            }
            .map { it.sum() }
        return totals
    }
}

fun <T> splitAfter(collection: Collection<T>, separator: T): List<List<T>> {
    val result = mutableListOf<MutableList<T>>()

    var newSublist = true
    collection.forEach { item ->
        if (newSublist)
            result += mutableListOf<T>()
        result.last() += item
        newSublist = (item == separator)
    }

    return result.toList()
}
