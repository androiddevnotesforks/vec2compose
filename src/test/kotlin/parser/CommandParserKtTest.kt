package parser

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CommandParserKtTest {

    private val commandParser = CommandParser()

    @Test
    fun `parse Move command`() {
        val movePath = "M27.05,24.55"
        assertEquals(
            expected = Command.MoveTo(x = 27.05f, y = 24.55f, isAbsolute = true),
            actual = commandParser.parse(movePath),
        )
    }

    @Test
    fun `parse LineTo path`() {
        val linePath = "L12.15,19.65"
        assertEquals(
            expected = Command.LineTo(x = 12.15f, y = 19.65f, isAbsolute = true),
            actual = commandParser.parse(linePath)
        )
    }

    @Test
    fun `parse CurveTo path`() {
        val curveToPath = "C11.85,19.35 11.483,19.2 11.05,19.2"
        assertEquals(
            expected = Command.CurveTo(
                x1 = 11.85f,
                y1 = 19.35f,
                x2 = 11.483f,
                y2 = 19.2f,
                x3 = 11.05f,
                y3 = 19.2f,
                isAbsolute = true
            ),
            actual = commandParser.parse(curveToPath)
        )
    }

    @Test
    fun `parse Close path`() {
        val closePath = "Z"
        assertEquals(
            expected = Command.Close(isAbsolute = true),
            actual = commandParser.parse(closePath)
        )
    }

    @Test
    fun `parse Close path relative with lowercase z`() {
        val closePath = "z"
        assertEquals(
            expected = Command.Close(isAbsolute = false),
            actual = commandParser.parse(closePath)
        )
    }

    @Test
    fun `parse HorizontalLineTo path`() {
        val horizontalLineToPath = "H20.05"
        assertEquals(
            expected = Command.HorizontalLineTo(x = 20.05f, isAbsolute = true),
            actual = commandParser.parse(horizontalLineToPath)
        )
    }

    @Test
    fun `parse HorizontalLineTo path with relative command`() {
        val horizontalLineToPath = "h20.05"
        assertEquals(
            expected = Command.HorizontalLineTo(x = 20.05f, isAbsolute = false),
            actual = commandParser.parse(horizontalLineToPath)
        )
    }

    @Test
    fun `parse VerticalLineTo path`() {
        val horizontalLineToPath = "V20.05"
        assertEquals(
            expected = Command.VerticalLineTo(y = 20.05f, isAbsolute = true),
            actual = commandParser.parse(horizontalLineToPath)
        )
    }
}
