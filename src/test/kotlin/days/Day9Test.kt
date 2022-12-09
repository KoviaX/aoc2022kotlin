package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day9Test {
    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day9.txt")
        // When
        val result = Day9().a(input)
        // Then
        assertThat(result).isEqualTo("13")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day9.txt")
        // When
        val result = Day9().b(input)
        // Then
        assertThat(result).isEqualTo("9")
    }
}
