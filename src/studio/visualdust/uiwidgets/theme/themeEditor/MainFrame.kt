package studio.visualdust.uiwidgets.theme.themeEditor

import studio.visualdust.uiwidgets.theme.FlavorResource

class MainFrame {
}

fun main(args: Array<String>) {
    FlavorResource.Initialize()
    if (args.isNotEmpty())
        when (args[0]) {
            "-darkTheme" -> FlavorResource.swichTheme(FlavorResource.Companion.themeEnum.DarkTheme)
            "-lightTheme" -> FlavorResource.swichTheme(FlavorResource.Companion.themeEnum.LightTheme)
            else -> println("$args[0] isn't a legal theme name")
        }
}