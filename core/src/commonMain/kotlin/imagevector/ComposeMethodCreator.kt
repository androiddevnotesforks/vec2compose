package imagevector

import VectorSet
import commands.Command

internal class ComposeMethodCreator(private val indentation: CharSequence) {

    fun parseConstructor(name: String, set: VectorSet): String = buildString {
        append("ImageVector.Builder(").appendLine()
        indent().append("name = \"$name\",").appendLine()
        indent().append("defaultWidth = ${set.width}.dp,").appendLine()
        indent().append("defaultHeight = ${set.height}.dp,").appendLine()
        indent().append("viewportWidth = ${set.viewportWidth}f,").appendLine()
        indent().append("viewportHeight = ${set.viewportHeight}f").appendLine()
        append(")")
    }

    fun parsePath(path: VectorSet.Path, forBuilder: Boolean = true): String = buildString {
        if (forBuilder) append(".")
        append("path(").appendLine()
        val fillColor = path.fillColor?.toString() ?: "Color.Black"
        indent().append("fill = SolidColor($fillColor),").appendLine()
        indent().append("fillAlpha = ${path.alpha}f,").appendLine()
        indent().append("stroke = null,").appendLine()
        indent().append("strokeAlpha = 1f,").appendLine()
        indent().append("strokeLineWidth = 1f,").appendLine()
        indent().append("strokeLineCap = StrokeCap.Butt,").appendLine()
        indent().append("strokeLineJoin = StrokeJoin.Bevel,").appendLine()
        indent().append("strokeLineMiter = 1f,").appendLine()
        indent().append("pathFillType = ${path.fillType.composeName}").appendLine()
        append(") {").appendLine()

        path.commands.map(Command::method)
            .forEach { indent().append(it).appendLine() }

        append("}")
    }.removePrefix(indentation)

    fun parseGroup(group: VectorSet.Group, forBuilder: Boolean = true): String = buildString {
        if (forBuilder) append(".")
        append("group(").appendLine()
        group.name?.also { indent().append("name = $it").appendLine() }
        indent().append("rotate = ${group.rotate}f,").appendLine()
        indent().append("pivotX = ${group.pivot.x}f,").appendLine()
        indent().append("pivotY = ${group.pivot.y}f,").appendLine()
        indent().append("scaleX = ${group.scale.x}f,").appendLine()
        indent().append("scaleY = ${group.scale.y}f,").appendLine()
        indent().append("translationX = ${group.translation.x}f,").appendLine()
        indent().append("translationY = ${group.translation.y}f,").appendLine()
        indent().append("clipPathData = emptyList()").appendLine()
        append(") {").appendLine()
        group.groups.joinToString(separator = "\n") { parseGroup(it, forBuilder = false) }
            .setupIndent()
            .let(::append)
            .appendLine()
        group.paths.joinToString(separator = "\n") { parsePath(it, forBuilder = false) }
            .setupIndent()
            .let(::append)
            .appendLine()
        append("}")
    }

    private fun String.setupIndent(): String = prependIndent(indent = indentation.toString())
    private fun StringBuilder.indent(): StringBuilder = append(indentation)
    private val VectorSet.Path.FillType.composeName: String
        get() = when (this) {
            VectorSet.Path.FillType.NonZero -> "PathFillType.NonZero"
            VectorSet.Path.FillType.EvenOdd -> "PathFillType.EvenOdd"
        }
}
