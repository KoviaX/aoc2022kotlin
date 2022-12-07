package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day7Test {
    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day7.txt")
        // When
        val result = Day7().a(input)
        // Then
        assertThat(result).isEqualTo("95437")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day7.txt")
        // When
        val result = Day7().b(input)
        // Then
        assertThat(result).isEqualTo("d")
    }
}
