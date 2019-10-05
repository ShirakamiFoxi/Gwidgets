package studio.visualdust.uiwigets.common

import java.awt.Color

interface UIwigets {
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