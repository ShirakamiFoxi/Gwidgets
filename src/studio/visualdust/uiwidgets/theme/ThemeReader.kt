package studio.visualdust.uiwidgets.theme

import studio.visualdust.uiwidgets.common.LinedFile
import java.awt.Color
import java.io.File
import java.io.InputStream
import java.util.*

class ThemeReader {
    companion object {
        fun readTheme(inputStream:InputStream):Vector<Color>{
            var linedFile = LinedFile(inputStream).linedFile
            return readTheme(linedFile)
        }

        fun readTheme(file: File): Vector<Color> {
            var linedFile = LinedFile(file).linedFile
            return readTheme(linedFile)
        }

        private fun readTheme(linedFile: Vector<String>): Vector<Color> {
            var theme = Vector<Color>()
            for (line in linedFile) {
                if (line[0] == '$') {
                    var colorConfig = line.substring(1, line.length).split(',')
//                    println("now resolving : $colorConfig")
                    if (colorConfig.size == 3) {
                        theme.add(
                            Color(
                                colorConfig.elementAt(0).toInt(),
                                colorConfig.elementAt(1).toInt(),
                                colorConfig.elementAt(2).toInt()
                            )
                        )
//                        println("Now adding: $colorConfig")
                    } else throw Exception("No color pattern in $colorConfig : file $linedFile")
                }
            }
            var standardThemeSize = 93
            if (theme.size != standardThemeSize)
                throw Exception("Theme file $linedFile is supposed to be as $standardThemeSize lines long, but it has ${theme.size} lines, this may occur some exception.")
            return theme
        }
    }
}