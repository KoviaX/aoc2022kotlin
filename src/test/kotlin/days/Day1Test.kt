package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1Test {

    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day1.txt")
        // When
        val result = Day1().a(input)
        // Then
        assertThat(result).isEqualTo("24000")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day1.txt")
        // When
        val result = Day1().b(input)
        // Then
        assertThat(result).isEqualTo("45000")
    }
}
