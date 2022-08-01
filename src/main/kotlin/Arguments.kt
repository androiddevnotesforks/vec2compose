import kotlinx.cli.*

internal class Arguments(args: Array<String>) {
    private val inputOption: SingleOption<String, DefaultRequiredType.Required>
    private val outputOption: SingleNullableOption<String>

    val input: String get() = inputOption.value
    val output: String? get() = outputOption.value

    init {
        val argParser = ArgParser(programName = "vec2compose")
        inputOption = argParser.option(
            type = ArgType.String,
            shortName = "i",
            fullName = "input",
            description = "Input file"
        ).required()
        outputOption = argParser.option(
            type = ArgType.String,
            shortName = "o",
            fullName = "output",
            description = "Output file"
        )
        argParser.parse(args)
    }
}