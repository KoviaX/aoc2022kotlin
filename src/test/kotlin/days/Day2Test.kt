package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2Test {

    @Test
    fun a() {
        // Given
        // When
        val result = Day2().a(Utils().getTestInputFile("day2"))
        // Then
        assertThat(result).isEqualTo("15")
    }

    @Test
    fun b() {
        // Given
        // When
        val result = Day2().b(Utils().getTestInputFile("day2"))
        // Then
        assertThat(result).isEqualTo("12")
    }
}
