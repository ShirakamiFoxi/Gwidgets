package studio.visualdust.uiwigets.slider

import studio.visualdust.uiwigets.common.UIwigets
import studio.visualdust.uiwigets.theme.FlavorResource
import java.awt.Color
import javax.swing.JPanel

class GSlider : JPanel, UIwigets {

    override var bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.BUTTON_BG_STATIC)
    override var fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.BUTTON_FG_STATIC)
    override var onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.BUTTON_BG_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.BUTTON_FG_FOCUSED)
    override var activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.BUTTON_BG_PRESSED)
    override var activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.BUTTON_FG_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    constructor() {

    }

    init {

    }

    override fun refreshUI() {

    }
}