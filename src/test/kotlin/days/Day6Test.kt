package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day6Test {

    @Test
    fun a() {
        // Given
        val files = listOf("day6.txt", "day6b.txt", "day6c.txt", "day6d.txt")
        val inputs = files.map {  Utils().getTestInputFile(it) }
        // When
        val results = inputs.map { Day6().a(it) }
        // Then
        assertThat(results).containsExactly("5", "6", "10", "11")
    }

    @Test
    fun b() {
        // Given
        val files = listOf("day6.txt", "day6b.txt", "day6c.txt", "day6d.txt")
        val inputs = files.map {  Utils().getTestInputFile(it) }
        // When
        val results = inputs.map { Day6().b(it) }
        // Then
        assertThat(results).containsExactly("23", "23", "29", "26")
    }
}
