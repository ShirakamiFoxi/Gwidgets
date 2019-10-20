package studio.visualdust.uiwidgets.theme

import java.awt.Color
import java.awt.Font
import java.io.File
import java.util.*

class FlavorResource {
    companion object {

        var lightThemeColors = Vector<Color>()
        var darkThemeColors = Vector<Color>()
        var customThemeColors = Vector<Color>()
        var nowTheme = darkThemeColors


        var fonts = Vector<Font>()
        enum class fontEnum{
            DEFAULT
        }
        var fontMap = mapOf<String,Int>(
            "DEFAULT" to 0
        )
        open fun getFont(fontName: fontEnum):Font{
            return fonts.elementAt(fontMap.getValue(fontName.name))
        }

        var themes = Vector<Vector<Color>>()
        /**
         *set up the color enum and the name-value mapping structure for in-theme color choosing
         */

        enum class colorEnum {

            COMMON_BG,
            COMMON_FG,
            COMMON_BG_DISABLED,
            COMMON_FG_DISABLED,

            CONTAINER_BG_0_STATIC, CONTAINER_BG_1_STATIC,
            CONTAINER_FG_0_STATIC, CONTAINER_FG_1_STATIC,
            CONTAINER_BG_0_FOCUSED, CONTAINER_BG_1_FOCUSED,
            CONTAINER_FG_0_FOCUSED, CONTAINER_FG_1_FOCUSED,
            CONTAINER_BG_0_PRESSED, CONTAINER_BG_1_PRESSED,
            CONTAINER_FG_0_PRESSED, CONTAINER_FG_1_PRESSED,
            CONTAINER_BG_2_STATIC, CONTAINER_BG_3_STATIC,
            CONTAINER_FG_2_STATIC, CONTAINER_FG_3_STATIC,
            CONTAINER_BG_2_FOCUSED, CONTAINER_BG_3_FOCUSED,
            CONTAINER_FG_2_FOCUSED, CONTAINER_FG_3_FOCUSED,
            CONTAINER_BG_2_PRESSED, CONTAINER_BG_3_PRESSED,
            CONTAINER_FG_2_PRESSED, CONTAINER_FG_3_PRESSED,

            BUTTON_BG_STATIC,
            BUTTON_FG_STATIC,
            BUTTON_BG_FOCUSED,
            BUTTON_FG_FOCUSED,
            BUTTON_BG_PRESSED,
            BUTTON_FG_PRESSED,
            BUTTON_BG_NEXT_STATIC,
            BUTTON_FG_NEXT_STATIC,
            BUTTON_BG_NEXT_FOCUSED,
            BUTTON_FG_NEXT_FOCUSED,
            BUTTON_BG_NEXT_PRESSED,
            BUTTON_FG_NEXT_PRESSED,
            BUTTON_BG_OK_STATIC,
            BUTTON_FG_OK_STATIC,
            BUTTON_BG_OK_FOCUSED,
            BUTTON_FG_OK_FOCUSED,
            BUTTON_BG_OK_PRESSED,
            BUTTON_FG_OK_PRESSED,
            BUTTON_BG_WARN_STATIC,
            BUTTON_FG_WARN_STATIC,
            BUTTON_BG_WARN_FOCUSED,
            BUTTON_FG_WARN_FOCUSED,
            BUTTON_BG_WARN_PRESSED,
            BUTTON_FG_WARN_PRESSED,
            BUTTON_BG_ERROR_STATIC,
            BUTTON_FG_ERROR_STATIC,
            BUTTON_BG_ERROR_FOCUSED,
            BUTTON_FG_ERROR_FOCUSED,
            BUTTON_BG_ERROR_PRESSED,
            BUTTON_FG_ERROR_PRESSED,
            BUTTON_BG_DISABLED,
            BUTTON_FG_DISABLED,

            TEXTFIELD_BG_STATIC,
            TEXTFIELD_FG_STATIC,
            TEXTFIELD_BG_FOCUSED,
            TEXTFIELD_FG_FOCUSED,
            TEXTFIELD_BG_PRESSED,
            TEXTFIELD_FG_PRESSED,
            TEXTFIELD_BG_OK_STATIC,
            TEXTFIELD_FG_OK_STATIC,
            TEXTFIELD_BG_OK_FOCUSED,
            TEXTFIELD_FG_OK_FOCUSED,
            TEXTFIELD_BG_OK_PRESSED,
            TEXTFIELD_FG_OK_PRESSED,
            TEXTFIELD_BG_WARN_STATIC,
            TEXTFIELD_FG_WARN_STATIC,
            TEXTFIELD_BG_WARN_FOCUSED,
            TEXTFIELD_FG_WARN_FOCUSED,
            TEXTFIELD_BG_WARN_PRESSED,
            TEXTFIELD_FG_WARN_PRESSED,
            TEXTFIELD_BG_ERROR_STATIC,
            TEXTFIELD_FG_ERROR_STATIC,
            TEXTFIELD_BG_ERROR_FOCUSED,
            TEXTFIELD_FG_ERROR_FOCUSED,
            TEXTFIELD_BG_ERROR_PRESSED,
            TEXTFIELD_FG_ERROR_PRESSED,

            PROGRESSBAR_BG_STATIC,
            PROGRESSBAR_FG_STATIC,
            PROGRESSBAR_FT_STATIC,
            PROGRESSBAR_BG_FOCUSED,
            PROGRESSBAR_FG_FOCUSED,
            PROGRESSBAR_FT_FOCUSED,
            PROGRESSBAR_BG_PRESSED,
            PROGRESSBAR_FG_PRESSED,
            PROGRESSBAR_FT_PRESSED
        }

        /**
         *get in-theme color using colors' name in the enum
         */

        open var colorMap = mapOf<String, Int>(
            "COMMON_BG" to 0,
            "COMMON_FG" to 1,
            "COMMON_BG_DISABLED" to 2,
            "COMMON_FG_DISABLED" to 3,

            "CONTAINER_BG_0_STATIC" to 4, "CONTAINER_BG_1_STATIC" to 10,
            "CONTAINER_FG_0_STATIC" to 5, "CONTAINER_FG_1_STATIC" to 11,
            "CONTAINER_BG_0_FOCUSED" to 6, "CONTAINER_BG_1_FOCUSED" to 12,
            "CONTAINER_FG_0_FOCUSED" to 7, "CONTAINER_FG_1_FOCUSED" to 13,
            "CONTAINER_BG_0_PRESSED" to 8, "CONTAINER_BG_1_PRESSED" to 14,
            "CONTAINER_FG_0_PRESSED" to 9, "CONTAINER_FG_1_PRESSED" to 15,

            "CONTAINER_BG_2_STATIC" to 16, "CONTAINER_BG_3_STATIC" to 22,
            "CONTAINER_FG_2_STATIC" to 17, "CONTAINER_FG_3_STATIC" to 23,
            "CONTAINER_BG_2_FOCUSED" to 18, "CONTAINER_BG_3_FOCUSED" to 24,
            "CONTAINER_FG_2_FOCUSED" to 19, "CONTAINER_FG_3_FOCUSED" to 25,
            "CONTAINER_BG_2_PRESSED" to 20, "CONTAINER_BG_3_PRESSED" to 26,
            "CONTAINER_FG_2_PRESSED" to 21, "CONTAINER_FG_3_PRESSED" to 27,

            "BUTTON_BG_STATIC" to 28,
            "BUTTON_FG_STATIC" to 29,
            "BUTTON_BG_FOCUSED" to 30,
            "BUTTON_FG_FOCUSED" to 31,
            "BUTTON_BG_PRESSED" to 32,
            "BUTTON_FG_PRESSED" to 33,
            "BUTTON_BG_NEXT_STATIC" to 34,
            "BUTTON_FG_NEXT_STATIC" to 35,
            "BUTTON_BG_NEXT_FOCUSED" to 36,
            "BUTTON_FG_NEXT_FOCUSED" to 37,
            "BUTTON_BG_NEXT_PRESSED" to 38,
            "BUTTON_FG_NEXT_PRESSED" to 39,
            "BUTTON_BG_OK_STATIC" to 40,
            "BUTTON_FG_OK_STATIC" to 41,
            "BUTTON_BG_OK_FOCUSED" to 42,
            "BUTTON_FG_OK_FOCUSED" to 43,
            "BUTTON_BG_OK_PRESSED" to 44,
            "BUTTON_FG_OK_PRESSED" to 45,
            "BUTTON_BG_WARN_STATIC" to 46,
            "BUTTON_FG_WARN_STATIC" to 47,
            "BUTTON_BG_WARN_FOCUSED" to 48,
            "BUTTON_FG_WARN_FOCUSED" to 49,
            "BUTTON_BG_WARN_PRESSED" to 50,
            "BUTTON_FG_WARN_PRESSED" to 51,
            "BUTTON_BG_ERROR_STATIC" to 52,
            "BUTTON_FG_ERROR_STATIC" to 53,
            "BUTTON_BG_ERROR_FOCUSED" to 54,
            "BUTTON_FG_ERROR_FOCUSED" to 55,
            "BUTTON_BG_ERROR_PRESSED" to 56,
            "BUTTON_FG_ERROR_PRESSED" to 57,
            "BUTTON_BG_DISABLED" to 58,
            "BUTTON_FG_DISABLED" to 59,

            "TEXTFIELD_BG_STATIC" to 60,
            "TEXTFIELD_FG_STATIC" to 61,
            "TEXTFIELD_BG_FOCUSED" to 62,
            "TEXTFIELD_FG_FOCUSED" to 63,
            "TEXTFIELD_BG_PRESSED" to 64,
            "TEXTFIELD_FG_PRESSED" to 65,
            "TEXTFIELD_BG_OK_STATIC" to 66,
            "TEXTFIELD_FG_OK_STATIC" to 67,
            "TEXTFIELD_BG_OK_FOCUSED" to 68,
            "TEXTFIELD_FG_OK_FOCUSED" to 69,
            "TEXTFIELD_BG_OK_PRESSED" to 70,
            "TEXTFIELD_FG_OK_PRESSED" to 71,
            "TEXTFIELD_BG_WARN_STATIC" to 72,
            "TEXTFIELD_FG_WARN_STATIC" to 73,
            "TEXTFIELD_BG_WARN_FOCUSED" to 74,
            "TEXTFIELD_FG_WARN_FOCUSED" to 75,
            "TEXTFIELD_BG_WARN_PRESSED" to 76,
            "TEXTFIELD_FG_WARN_PRESSED" to 77,
            "TEXTFIELD_BG_ERROR_STATIC" to 78,
            "TEXTFIELD_FG_ERROR_STATIC" to 79,
            "TEXTFIELD_BG_ERROR_FOCUSED" to 80,
            "TEXTFIELD_FG_ERROR_FOCUSED" to 81,
            "TEXTFIELD_BG_ERROR_PRESSED" to 82,
            "TEXTFIELD_FG_ERROR_PRESSED" to 83,

            "PROGRESSBAR_BG_STATIC" to 84,
            "PROGRESSBAR_FG_STATIC" to 85,
            "PROGRESSBAR_FT_STATIC" to 86,
            "PROGRESSBAR_BG_FOCUSED" to 87,
            "PROGRESSBAR_FG_FOCUSED" to 88,
            "PROGRESSBAR_FT_FOCUSED" to 89,
            "PROGRESSBAR_BG_PRESSED" to 90,
            "PROGRESSBAR_FG_PRESSED" to 91,
            "PROGRESSBAR_FT_PRESSED" to 92
        )


        fun Initialize() {
            /**
             * Initialize the color vector of the dark-theme
             */
            darkThemeColors = ThemeReader.readTheme(
                File(ThemeReader.javaClass.getResource("DefaultDarkTheme.Gtheme").toURI())
            )
            nowTheme = darkThemeColors

            /**
             * Initialize the theme vector
             */
            themes.add(darkThemeColors)
            themes.add(lightThemeColors)
            themes.add(customThemeColors)

            /**
             * Initialize the font vector
             */
            fonts.add(Font("等线", 0, 10))
        }

        /**
         * set up the theme enum and the name-value mapping structure for theme choosing
         */
        enum class themeEnum {
            DarkTheme,
            LightTheme,
            CustomTheme
        }

        open var themeMap = mapOf<String, Int>(
            "DarkTheme" to 0,
            "LightTheme" to 1,
            "CustomTheme" to 2
        )

        open fun swichTheme(theme: themeEnum) {
            nowTheme = themes.elementAt(
                themeMap.getValue(theme.name)
            )
        }

        open fun getColor(colorName: colorEnum): Color = nowTheme.elementAt(colorMap.getValue(colorName.name))


        open fun setColor(colorName: colorEnum, color: Color): Unit =
            nowTheme.setElementAt(color, colorMap.getValue(colorName.name))
    }
}