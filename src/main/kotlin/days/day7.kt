package days

import Exercise

class Day7 : Exercise {
    override fun a(input: List<String>): String {
        val parsedRootDir = parseInitialStructure(input)
        recursiveSize(parsedRootDir, 0)
        return ""
    }


    private fun parseInitialStructure(input: List<String>): Directory {
        val rootDir = Directory(name = "/")

        var currentDir = rootDir
        input.forEach { commandLine ->
            when {
                commandLine == "$ cd /" -> currentDir = rootDir
                commandLine == "$ cd .." -> currentDir = currentDir.parent ?: Directory("/")
                commandLine.startsWith("$ cd") -> currentDir = currentDir.directories.first { it.name == commandLine.substringAfter("cd ") }
                commandLine.startsWith("dir") -> currentDir.directories.add(Directory(commandLine.substringAfter("dir "), currentDir))
                !commandLine.contains("$") -> currentDir.files.add(File(commandLine.substringAfter(" "), commandLine.substringBefore(" ").toInt()))
            }
        }
        return rootDir
    }

    private fun recursiveSize(directory: Directory, size: Int): Int {
        return directory.files.sumOf { it.size } + directory.directories.sumOf { recursiveSize(directory, size) }
    }

    data class Directory(
        val name: String,
        val parent: Directory? = null,
        val directories: MutableList<Directory> = mutableListOf(),
        val files: MutableList<File> = mutableListOf()
    )

    data class File(val name: String, val size: Int)

    override fun b(input: List<String>): String {
        return ""
    }
}
