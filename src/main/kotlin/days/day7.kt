package days

import Exercise

class Day7 : Exercise {
    override fun a(input: List<String>): String {
        val parsedRootDir = parseInitialStructure(input)
        return parsedRootDir.getFlatDirectoryList()
            .map { recursiveSize(mutableListOf(it), 0) }
            .filter { it < 100_000 }
            .sum()
            .toString()
    }


    override fun b(input: List<String>): String {
        val parsedRootDir = parseInitialStructure(input)
        val freeSpace = 70_000_000 - recursiveSize(mutableListOf(parsedRootDir), 0)

        val smallestDirectoryThatSolvesIssue = parsedRootDir.getFlatDirectoryList()
            .filter { recursiveSize(mutableListOf(it), 0) >= (30_000_000 - freeSpace) }
            .minBy { recursiveSize(mutableListOf(it), 0) }

        return recursiveSize(mutableListOf(smallestDirectoryThatSolvesIssue), 0).toString()
    }

    private fun parseInitialStructure(input: List<String>): Directory {
        val rootDir = Directory(name = "/")

        var currentDir = rootDir
        input.forEach { commandLine ->
            when {
                commandLine == "$ cd /" -> currentDir = rootDir
                commandLine == "$ cd .." -> currentDir = currentDir.parent ?: Directory("/")
                commandLine.startsWith("$ cd") -> currentDir =
                    currentDir.directories.first { it.name == commandLine.substringAfter("cd ") }

                commandLine.startsWith("dir") -> currentDir.directories.add(
                    Directory(
                        commandLine.substringAfter("dir "),
                        currentDir
                    )
                )

                !commandLine.contains("$") -> currentDir.files.add(
                    File(
                        commandLine.substringAfter(" "),
                        commandLine.substringBefore(" ").toInt()
                    )
                )
            }
        }
        return rootDir
    }

    private tailrec fun recursiveSize(directories: MutableList<Directory>, size: Int): Int {
        var newSize = size
        directories.forEach { dir -> newSize += (dir.files.sumOf { it.size }) }
        return if (directories.all { it.directories.isEmpty() }) newSize
        else recursiveSize(directories.flatMap { it.directories }.toMutableList(), newSize)
    }

    data class Directory(
        val name: String,
        val parent: Directory? = null,
        val directories: MutableList<Directory> = mutableListOf(),
        val files: MutableList<File> = mutableListOf()
    ) {
        fun getFlatDirectoryList(): List<Directory> = directories + directories.flatMap { it.getFlatDirectoryList() }
    }

    data class File(val name: String, val size: Int)
}
