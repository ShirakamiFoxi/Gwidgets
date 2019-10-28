package studio.visualdust.uiwidgets.radioButton

import studio.visualdust.uiwidgets.button.GButton
import studio.visualdust.uiwidgets.common.UIwidgets
import studio.visualdust.uiwidgets.theme.FlavorResource
import studio.visualdust.uiwidgets.theme.FlavorResource.Companion.colorEnum.*
import java.awt.Color
import java.awt.Dimension
import java.util.*
import javax.swing.JLabel
import javax.swing.JPanel

class GSingleSelector : JPanel, UIwidgets {
    override var bgColor = FlavorResource.getColor(CONTAINER_BG_1_STATIC)
    override var fgColor = FlavorResource.getColor(CONTAINER_FG_1_STATIC)
    override var onActiveBG = FlavorResource.getColor(CONTAINER_BG_1_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(CONTAINER_FG_1_FOCUSED)
    override var activedBG = FlavorResource.getColor(CONTAINER_BG_1_PRESSED)
    override var activedFG = FlavorResource.getColor(CONTAINER_FG_1_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    var title = ""
    var label = JLabel(title, JLabel.LEFT)
    var selectorWidth = -1

    var options = Vector<Option>()

    constructor(title: String) {

    }

    init {

    }

    fun addOption(option: Option) {
        initOption(option)
    }

    fun addOption(title: String): Option {
        var option = Option(title)
        initOption(option)
        return option
    }

    private fun initOption(option: Option) {

    }

    override fun setSize(d: Dimension?) {
//        super.setSize(d)
    }

    override fun refreshUI() {

    }
}

class Option : GButton {
    var index = -1
    var title = ""
    var titleWidth = -1

    constructor(title: String) : super(title) {
        this.title = title
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

    init {
        var font = FlavorResource.getFont(FlavorResource.Companion.fontEnum.TAG_FONT)
        var fontMetrics = this.getFontMetrics(font)
        this.titleWidth = fontMetrics.stringWidth(title)
        this.setSize((titleWidth * 1.2).toInt(), (titleWidth * 1.1 / title.length).toInt())
        //todo finish this fucking calss
    }
}