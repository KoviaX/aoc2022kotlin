package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3Test {

    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day3.txt")
        // When
        val result = Day3().a(input)
        // Then
        assertThat(result).isEqualTo("157")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day3.txt")
        // When
        val result = Day3().b(input)
        // Then
        assertThat(result).isEqualTo("70")
    }
}
