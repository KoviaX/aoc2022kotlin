package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2Test {

    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day2.txt")
        // When
        val result = Day2().a(input)
        // Then
        assertThat(result).isEqualTo("15")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day2.txt")
        // When
        val result = Day2().b(input)
        // Then
        assertThat(result).isEqualTo("12")
    }
}
