import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ColorDeserializerTest {

    private val deserializer = ColorDeserializer()

    @Nested
    inner class DeserializeThreeCharHex {
        @Test
        fun `white color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#fff")
            )
        }

        @Test
        fun `red color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0xFF, green = 0x00, blue = 0x00, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#F00")
            )
        }

        @Test
        fun `green color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0xFF, blue = 0x00, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#0F0")
            )
        }

        @Test
        fun `blue color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0x00, blue = 0xFF, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#00F")
            )
        }
    }

    @Nested
    inner class DeserializeSixCharHex {
        @Test
        fun `white color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#FFFFFF")
            )
        }

        @Test
        fun `red color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0xFF, green = 0x00, blue = 0x00, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#FF0000")
            )
        }

        @Test
        fun `green color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0xFF, blue = 0x00, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#00FF00")
            )
        }

        @Test
        fun `blue color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0x00, blue = 0xFF, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#0000FF")
            )
        }
    }

    @Nested
    inner class DeserializeEightCharHex {
        @Test
        fun `white color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0xFF, green = 0xFF, blue = 0xFF, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#FFFFFFFF")
            )
        }

        @Test
        fun `red color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0xFF, green = 0x00, blue = 0x00, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#FFFF0000")
            )
        }

        @Test
        fun `green color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0xFF, blue = 0x00, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#FF00FF00")
            )
        }

        @Test
        fun `blue color to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0x00, blue = 0xFF, alpha = 0xFF),
                actual = deserializer.deserialize(color = "#FF0000FF")
            )
        }

        @Test
        fun `black color with alpha to FillColor`() {
            assertEquals(
                expected = VectorSet.Path.FillColor(red = 0x00, green = 0x00, blue = 0xFF, alpha = 0x33),
                actual = deserializer.deserialize(color = "#330000FF")
            )
        }
    }

    @Nested
    inner class DeserializeNoHex {
        @Test
        fun `returns no color`() {
            assertNull(actual = deserializer.deserialize(color = "R.color.white"))
        }
    }

}