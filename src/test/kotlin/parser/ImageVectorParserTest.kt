package parser

import models.VectorSet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ImageVectorParserTest {

    private val imageVectorParser = ImageVectorParser()

    @Test
    fun `parse VectorSet to ImageVector string`() {
        val set = VectorSet(
            width = 24,
            height = 24,
            viewportWidth = 48,
            viewportHeight = 48,
            paths = listOf(
                VectorSet.Path(
                    commands = listOf(
                        Command.MoveTo(x = 1f, y = 2f, isAbsolute = true),
                        Command.LineTo(x = 2f, y = 2f, isAbsolute = true),
                        Command.LineTo(x = 1f, y = 2f, isAbsolute = false),
                        Command.Close(isAbsolute = true)
                    )
                )
            ),
        )

        val expected = """
ImageVector.Builder(
    name = "ic_icon",
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
    viewportWidth = 48f,
    viewportHeight = 48f
).path(
    fill = SolidColor(Color.Black),
    fillAlpha = fillAlpha,
    stroke = null,
    strokeAlpha = strokeAlpha,
    strokeLineWidth = 1f,
    strokeLineCap = StrokeCap.Butt,
    strokeLineJoin = StrokeJoin.Bevel,
    strokeLineMiter = 1f,
    pathFillType = pathFillType
) {
    moveTo(1.0f, 2.0f)
    lineTo(2.0f, 2.0f)
    lineToRelative(1.0f, 2.0f)
    close()
}.build()
        """.trimIndent()
        assertEquals(
            expected = expected,
            actual = imageVectorParser.parse(name = "ic_icon", vectorSet = set),
        )
    }
}