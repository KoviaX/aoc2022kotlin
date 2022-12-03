package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1Test {

    @Test
    fun a() {
        // Given
        // When
        val result = Day1().a(Utils().getTestInputFile("day1"))
        // Then
        assertThat(result).isEqualTo("24000")
    }

    @Test
    fun b() {
        // Given
        // When
        val result = Day1().b(Utils().getTestInputFile("day1"))
        // Then
        assertThat(result).isEqualTo("45000")
    }
}
