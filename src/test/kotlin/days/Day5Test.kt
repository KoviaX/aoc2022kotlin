package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day5Test {

    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("day5.txt")
        // When
        val result = Day5().a(input)
        // Then
        assertThat(result).isEqualTo("CMZ")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("day5.txt")
        // When
        val result = Day5().b(input)
        // Then
        assertThat(result).isEqualTo("MCD")
    }
}
