package studio.visualdust.uiwigets.theme

import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.io.File
import java.util.*

class FlavorResource {
    companion object {
        var lightThemeColors = Vector<Color>()
        var darkThemeColors = Vector<Color>()
        var customThemeColors = Vector<Color>()
        var nowTheme = darkThemeColors

        var fonts = Vector<Font>()
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
            BUTTON_BG_NEXT,
            BUTTON_FG_NEXT,
            BUTTON_BG_NEXT_FOCUSED,
            BUTTON_FG_NEXT_FOCUSED,
            BUTTON_BG_NEXT_PRESSED,
            BUTTON_FG_NEXT_PRESSED,
            BUTTON_BG_OK,
            BUTTON_FG_OK,
            BUTTON_BG_OK_FOCUSED,
            BUTTON_FG_OK_FOCUSED,
            BUTTON_BG_OK_PRESSED,
            BUTTON_FG_OK_PRESSED,
            BUTTON_BG_WARN,
            BUTTON_FG_WARN,
            BUTTON_BG_WARN_FOCUSED,
            BUTTON_FG_WARN_FOCUSED,
            BUTTON_BG_WARN_PRESSED,
            BUTTON_FG_WARN_PRESSED,
            BUTTON_BG_ERROR,
            BUTTON_FG_ERROR,
            BUTTON_BG_ERROR_FOCUSED,
            BUTTON_FG_ERROR_FOCUSED,
            BUTTON_BG_ERROR_PRESSED,
            BUTTON_FG_ERROR_PRESSED,
            BUTTON_BG_DISABLED,
            BUTTON_FG_DISABLED,
            TEXTFIELD_BG,
            TEXTFIELD_FG,
            TEXTFIELD_WARN
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
            "BUTTON_BG_NEXT" to 34,
            "BUTTON_FG_NEXT" to 35,
            "BUTTON_BG_NEXT_FOCUSED" to 36,
            "BUTTON_FG_NEXT_FOCUSED" to 37,
            "BUTTON_BG_NEXT_PRESSED" to 38,
            "BUTTON_FG_NEXT_PRESSED" to 39,
            "BUTTON_BG_OK" to 40,
            "BUTTON_FG_OK" to 41,
            "BUTTON_BG_OK_FOCUSED" to 42,
            "BUTTON_FG_OK_FOCUSED" to 43,
            "BUTTON_BG_OK_PRESSED" to 44,
            "BUTTON_FG_OK_PRESSED" to 45,
            "BUTTON_BG_WARN" to 46,
            "BUTTON_FG_WARN" to 47,
            "BUTTON_BG_WARN_FOCUSED" to 48,
            "BUTTON_FG_WARN_FOCUSED" to 49,
            "BUTTON_BG_WARN_PRESSED" to 50,
            "BUTTON_FG_WARN_PRESSED" to 51,
            "BUTTON_BG_ERROR" to 52,
            "BUTTON_FG_ERROR" to 53,
            "BUTTON_BG_ERROR_FOCUSED" to 54,
            "BUTTON_FG_ERROR_FOCUSED" to 55,
            "BUTTON_BG_ERROR_PRESSED" to 56,
            "BUTTON_FG_ERROR_PRESSED" to 57,
            "BUTTON_BG_DISABLED" to 58,
            "BUTTON_FG_DISABLED" to 59,
            "TEXTFIELD_BG" to 60,
            "TEXTFIELD_FG" to 61,
            "TEXTFIELD_WARN" to 62
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