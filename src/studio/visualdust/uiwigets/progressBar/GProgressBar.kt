package studio.visualdust.uiwigets.progressBar

import studio.visualdust.uiwigets.common.UIwigets
import studio.visualdust.uiwigets.theme.FlavorResource
import java.awt.Color
import java.awt.Graphics
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JProgressBar

class GProgressBar : JPanel, UIwigets {

    override var bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_STATIC)
    override var fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_STATIC)
    override var onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_FOCUSED)
    override var activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_PRESSED)
    override var activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor
    var fromColor = nowBG
    var toColor = nowFG

    var frontPanel = JPanel()
    var textLabel = JLabel("", JLabel.CENTER)

    @JvmField
    var minValue: Int
    @JvmField
    var maxValue: Int
    @JvmField
    var nowValue = 0

    constructor(minValue: Int, maxValue: Int) {
        this.minValue = minValue
        this.maxValue = maxValue
    }

    constructor(minValue: Int, maxValue: Int, fromColor: Color, toColor: Color) {
        this.minValue = minValue
        this.maxValue = maxValue
        this.fromColor = fromColor
        this.toColor = toColor
    }

    init {

    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
    }

    open fun setMinValue(minValue: Int) {
        this.minValue = minValue
        var pb = JProgressBar()

    }

    open fun setMaxValue(maxValue: Int) {
        this.maxValue = maxValue
    }

    open fun setValue(value: Int) {
        this.nowValue = value
        this.repaint()
    }

    override fun refreshUI() {

    }
}