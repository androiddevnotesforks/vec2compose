package output

import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertIsNot

internal class OutputStrategyFactoryTest {

    private val factory = OutputStrategyFactory(NameFormatter())

    @Test
    fun create_without_output_path_returns_PrintOutputStrategy() {
        assertIsNot<FileOutputStrategy>(factory.create(outputPath = null, name = "George"))
    }

    @Test
    fun create_with_output_path_returns_FileOutputStrategy() {
        assertIs<FileOutputStrategy>(factory.create(outputPath = "some_file.xml", name = "George"))
    }
}