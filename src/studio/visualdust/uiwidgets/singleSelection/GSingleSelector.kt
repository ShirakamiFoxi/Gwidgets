package studio.visualdust.uiwidgets.radioButton

import studio.visualdust.uiwidgets.button.GButton
import studio.visualdust.uiwidgets.common.UIwidgets
import studio.visualdust.uiwidgets.theme.FlavorResource
import studio.visualdust.uiwidgets.theme.FlavorResource.Companion.colorEnum.*
import java.awt.Color
import java.util.*
import javax.swing.JPanel

class GSingleSelector : JPanel, UIwidgets {
    override var bgColor = FlavorResource.getColor(CONTAINER_BG_0_STATIC)
    override var fgColor = FlavorResource.getColor(CONTAINER_FG_0_STATIC)
    override var onActiveBG = FlavorResource.getColor(CONTAINER_BG_0_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(CONTAINER_FG_0_FOCUSED)
    override var activedBG = FlavorResource.getColor(CONTAINER_BG_0_PRESSED)
    override var activedFG = FlavorResource.getColor(CONTAINER_FG_0_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    private var options = Vector<Option>()

    constructor()

    init {

    }

    override fun refreshUI() {

    }
}

private class Option : GButton {
    var index = -1
    var title = ""
//    var titleWidth = -1

    constructor(title: String) : super(title) {
        this.title = title
//        var font = FlavorResource.getFont(FlavorResource.Companion.fontEnum.TAG_FONT)
//        var fontMetrics = this.getFontMetrics(font)
//        this.titleWidth = fontMetrics.stringWidth(title)
    }

    constructor(title: String, bgColor: Color) : super(title) {
        this.title = title
        this.bgColor = bgColor
        this.refreshUI()
    }

    constructor(title: String, bgColor: Color, fgColor: Color) : super(title) {
        this.title = title
        this.bgColor = bgColor
        this.fgColor = fgColor
        this.refreshUI()
    }
}