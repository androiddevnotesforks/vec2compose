package androidvector

import models.VectorSet
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AndroidVectorParserTest {

    private val parser = AndroidVectorParser(serializer = AndroidVectorSerializer())

    @Test
    fun `parse valid AndroidVector xml to VectorSet`() {
        val vector = XML(content = """
        <vector xmlns:android="http://schemas.android.com/apk/res/android"
            android:width="24dp"
            android:height="24dp"
            android:viewportWidth="24"
            android:viewportHeight="24"
            android:tint="?attr/colorControlNormal">
          <path
              android:fillColor="@android:color/white"
              android:pathData="M11.99,2C6.47,2 2,6.48 2,12s4.47,10 9.99,10C17.52,22 22,17.52 22,12S17.52,2 11.99,2zM18.92,8h-2.95c-0.32,-1.25 -0.78,-2.45 -1.38,-3.56 1.84,0.63 3.37,1.91 4.33,3.56zM12,4.04c0.83,1.2 1.48,2.53 1.91,3.96h-3.82c0.43,-1.43 1.08,-2.76 1.91,-3.96zM4.26,14C4.1,13.36 4,12.69 4,12s0.1,-1.36 0.26,-2h3.38c-0.08,0.66 -0.14,1.32 -0.14,2 0,0.68 0.06,1.34 0.14,2L4.26,14zM5.08,16h2.95c0.32,1.25 0.78,2.45 1.38,3.56 -1.84,-0.63 -3.37,-1.9 -4.33,-3.56zM8.03,8L5.08,8c0.96,-1.66 2.49,-2.93 4.33,-3.56C8.81,5.55 8.35,6.75 8.03,8zM12,19.96c-0.83,-1.2 -1.48,-2.53 -1.91,-3.96h3.82c-0.43,1.43 -1.08,2.76 -1.91,3.96zM14.34,14L9.66,14c-0.09,-0.66 -0.16,-1.32 -0.16,-2 0,-0.68 0.07,-1.35 0.16,-2h4.68c0.09,0.65 0.16,1.32 0.16,2 0,0.68 -0.07,1.34 -0.16,2zM14.59,19.56c0.6,-1.11 1.06,-2.31 1.38,-3.56h2.95c-0.96,1.65 -2.49,2.93 -4.33,3.56zM16.36,14c0.08,-0.66 0.14,-1.32 0.14,-2 0,-0.68 -0.06,-1.34 -0.14,-2h3.38c0.16,0.64 0.26,1.31 0.26,2s-0.1,1.36 -0.26,2h-3.38z"/>
        </vector>
        """.trimIndent())
        assertEquals(
            expected = VectorSet(
                width = 24,
                height = 24,
                viewportWidth = 24,
                viewportHeight = 24,
                paths = listOf(
                    VectorSet.Path(
                        listOf(

                        )
                    )
                )
            ),
            actual = parser.parse(vector).getOrThrow(),
        )
    }
}