package studio.visualdust.uiwigets.progressBar

import studio.visualdust.uiwigets.common.UIwigets
import studio.visualdust.uiwigets.theme.FlavorResource
import java.awt.*
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JProgressBar
import javax.swing.border.Border

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
    var text = ""

    @JvmField
    var minValue: Int
    @JvmField
    var maxValue: Int
    @JvmField
    var nowValue = 0

    enum class ProgressBarTypes {

    }

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
        this.add(textLabel)
        textLabel.setLocation(0, 0)
        textLabel.setSize(this.size)
    }

    var arcWidth = 0
    var arcHeight = 0
    override fun paintComponent(g: Graphics?) {
        var g2d = g as Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g2d.color = nowBG
        g2d.fillRoundRect(
            0,
            0,
            (this.width * 1.0).toInt(),
            (this.height * 1.0).toInt(),
            arcWidth,
            arcHeight
        )
        g2d.color = nowFG
        var coverWidth = 0
        if (nowValue - minValue > 0)
            coverWidth = this.width * (nowValue - minValue) / (maxValue - minValue)
        g2d.fillRoundRect(
            0,
            0,
            (coverWidth * 1.0).toInt(),
            (this.height * 1.0).toInt(),
            arcWidth,
            arcHeight
        )
        super.paintComponent(g)
    }

    open fun setMinValue(minValue: Int) {
        this.minValue = minValue
        this.repaint()
    }

    open fun setMaxValue(maxValue: Int) {
        this.maxValue = maxValue
        this.repaint()
    }

    open fun setValue(value: Int) {
        this.nowValue = value
        this.repaint()
    }

    var textPainted = false
        set(b) {
            when (b) {
                true -> textLabel.text = ""
                false -> textLabel.text = text
            }
            field = b
        }

    open fun setText(text: String) {
        this.text = text
        textLabel.text = when (textPainted) {
            true -> text
            false -> ""
        }
    }

    override fun setSize(d: Dimension?) {
        textLabel.setSize(d)
        super.setSize(d)
    }

    override fun setSize(width: Int, height: Int) {
        textLabel.setSize(width, height)
        super.setSize(width, height)
    }

    override fun refreshUI() {

    }
}