package fileparser

import imagevector.ImageVectorParser
import svg.SVGParser
import java.io.File

internal class SVGFileParser(
    private val svgParser: SVGParser,
    private val imageVectorParser: ImageVectorParser,
) : FileParser {
    override fun parse(file: File): Result<String> {
        return file.readText()
            .let(svgParser::parse)
            .mapCatching { imageVectorParser.parse(name = file.nameWithoutExtension, vectorSet = it) }
    }
}