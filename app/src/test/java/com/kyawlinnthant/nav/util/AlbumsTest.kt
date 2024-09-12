package com.kyawlinnthant.nav.util

import assertk.assertThat
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AlbumsTest {

    @DisplayName("correct soad albums format")
    @ParameterizedTest
    @CsvSource(
        "systemofadown1998",
        "systemofadown-1998",
        "systemofadown(1998)",
        "systemofadown[1998]",
        " system of a down 1998",
        " System Of A Down ( 1 -  9 -  9  -  8 )  ",
        " S y s t e m O f A D o w n - 1 9 9 8 ",
        " S * y * s _ t + e = m & O ^ f % A $ D # o @ - w ` n ` 1 9 9 8 `",
        " S y s t e m O f A D o w n _ 1 9 9 8 _",
        " S Y S T E M O F A D O W N % 1 9 9 8 #"
    )
    fun `correct one`(
        input: String,
    ) = runTest {
        val results = Albums.validateAlbum(input)
        assertThat(results).isTrue()
    }

    @DisplayName("incorrect name returns false")
    @Test
    fun `wrong name`() {
        runTest {
            val result = Albums.validateAlbum(name = "System of down (1998)")
            assertThat(result).isFalse()
        }
    }

    @DisplayName("incorrect year returns false")
    @Test
    fun `wrong year`() {
        runTest {
            val result = Albums.validateAlbum(name = "System of a down (1999)")
            assertThat(result).isFalse()
        }
    }

    @DisplayName("album without year returns false")
    @Test
    fun `without year`() {
        runTest {
            val result = Albums.validateAlbum(name = "System of a down")
            assertThat(result).isFalse()
        }
    }

    @DisplayName("incorrect album-year returns false")
    @Test
    fun `not in order`() {
        runTest {
            val result = Albums.validateAlbum(name = "1998 System of a down")
            assertThat(result).isFalse()
        }
    }

    @DisplayName("incorrect password returns false")
    @Test
    fun `incorrect pwd`() {
        runTest {
            val result = Albums.validatePassword(password = "soad")
            assertThat(result).isFalse()
        }
    }

    @DisplayName("correct password returns true")
    @Test
    fun `correct pwd`() {
        runTest {
            val result = Albums.validatePassword(password = "SOAD")
            assertThat(result).isTrue()
        }
    }

}