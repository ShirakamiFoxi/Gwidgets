package studio.visualdust.uiwigets.theme

import studio.visualdust.uiwigets.common.LinedFile
import java.awt.Color
import java.io.File
import java.lang.Exception
import java.util.*

class ThemeReader {
    companion object {
        fun readTheme(file: File): Vector<Color> {
            var theme = Vector<Color>()
            var themeSize = 50
            var linedFile = LinedFile(file).linedFile
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
                    } else throw Exception("No color pattern in $colorConfig : file $file")
                }
            }
            var standardThemeSize = 54
            if (theme.size < standardThemeSize)
                throw Exception("Theme file $file is supposed to be as $themeSize lines long, but it's only has ${theme.size} lines, this may occur some exception.")
            return theme
        }
    }
}