package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4Test {

    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day4.txt")
        // When
        val result = Day4().a(input)
        // Then
        assertThat(result).isEqualTo("2")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day4.txt")
        // When
        val result = Day4().b(input)
        // Then
        assertThat(result).isEqualTo("4")
    }
}
