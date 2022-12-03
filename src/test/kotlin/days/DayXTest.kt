package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DayXTest {

    @Test
    fun a() {
        // Given
        val input = Utils().getTestInputFile("dayX.txt")
        // When
        val result = DayX().a(input)
        // Then
        assertThat(result).isEqualTo("15")
    }

    @Test
    fun b() {
        // Given
        val input = Utils().getTestInputFile("dayX.txt")
        // When
        val result = DayX().b(input)
        // Then
        assertThat(result).isEqualTo("12")
    }
}
