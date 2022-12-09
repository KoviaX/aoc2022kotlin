import days.*
import java.nio.file.Paths

fun main() {
    val days: MutableList<Pair<String, String>> = mutableListOf()
    days.add(executeExercise(Day1(), "day1.txt"))
    days.add(executeExercise(Day2(), "day2.txt"))
    days.add(executeExercise(Day3(), "day3.txt"))
    days.add(executeExercise(Day4(), "day4.txt"))
    days.add(executeExercise(Day5(), "day5.txt"))
    days.add(executeExercise(Day6(), "day6.txt"))
    days.add(executeExercise(Day7(), "day7.txt"))
    days.add(executeExercise(Day8(), "day8.txt"))
    days.forEachIndexed {i, dayResults -> printResults(i, dayResults) }
}

private fun printResults(index: Int, day: Pair<String, String>) {
    println("Day ${index+1}a: ${day.first}, Day ${index+1}b: ${day.second}")
}

private fun executeExercise(exercise: Exercise, fileName: String): Pair<String, String> {
    val input = readInput(fileName)
    return Pair(exercise.a(input), exercise.b(input))
}

fun readInput(fileName: String): List<String> {
    return Paths.get("src", "main", "resources", "inputs", fileName).toFile().readLines()
}
