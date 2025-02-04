import kotlin.test.Test
import kotlin.test.assertEquals

class VectorSetTest {
    @Test
    fun WhiteColorTo0xffffffff() {
        val color = VectorSet.Path.FillColor(red = 0xff, green = 0xff, blue = 0xff, alpha = 0xff)
        assertEquals(expected = "Color(0xffffffff)", actual = color.toString())
    }

    @Test
    fun BlackColorTo0xff000000() {
        val color = VectorSet.Path.FillColor(red = 0x00, green = 0x00, blue = 0x00, alpha = 0xff)
        assertEquals(expected = "Color(0xff000000)", actual = color.toString())
    }

    @Test
    fun RedColorTo0xffff0000() {
        val color = VectorSet.Path.FillColor(red = 0xff, green = 0x00, blue = 0x00, alpha = 0xff)
        assertEquals(expected = "Color(0xffff0000)", actual = color.toString())
    }

    @Test
    fun BlueColorTo0xff00ff00() {
        val color = VectorSet.Path.FillColor(red = 0x00, green = 0x00, blue = 0xff, alpha = 0xff)
        assertEquals(expected = "Color(0xff0000ff)", actual = color.toString())
    }

    @Test
    fun GreenColorTo0xff00ff00() {
        val color = VectorSet.Path.FillColor(red = 0x00, green = 0xff, blue = 0x00, alpha = 0xff)
        assertEquals(expected = "Color(0xff00ff00)", actual = color.toString())
    }
}
