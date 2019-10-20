package studio.visualdust.uiwidgets.common

import java.awt.Color

interface UIwidgets {
    var bgColor: Color
    var fgColor: Color
    var onActiveBG: Color
    var onActiveFG: Color
    var activedBG: Color
    var activedFG: Color
    var nowBG: Color
    var nowFG: Color

    open fun refreshUI()

}