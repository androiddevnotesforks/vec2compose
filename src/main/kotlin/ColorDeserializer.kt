internal class ColorDeserializer {
    fun deserialize(color: String): VectorSet.Path.FillColor? {
        if (color.startsWith("#")) return deserialize(color.drop(1))
        return when (color.length) {
            3 -> deserialize(color.fold(initial = "") { acc, char -> "$acc$char$char" })
            6 -> deserialize("FF$color")
            8 -> color.windowed(size = 2, step = 2).let { (a, r, g, b) ->
                VectorSet.Path.FillColor(
                    red = r.toInt(16),
                    green = g.toInt(16),
                    blue = b.toInt(16),
                    alpha = a.toInt(16)
                )
            }

            else -> null
        }
    }
}