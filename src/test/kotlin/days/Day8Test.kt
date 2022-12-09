package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day8Test {
    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day8.txt")
        // When
        val result = Day8().a(input)
        // Then
        assertThat(result).isEqualTo("21")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day8.txt")
        // When
        val result = Day8().b(input)
        // Then
        assertThat(result).isEqualTo("8")
    }
}
