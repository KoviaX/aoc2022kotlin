package days

import java.nio.file.Paths

class Utils {
    fun getTestInputFile(fileName: String): List<String> {
        return Paths.get("src", "test", "resources", "inputs", fileName).toFile().readLines()
    }
}
