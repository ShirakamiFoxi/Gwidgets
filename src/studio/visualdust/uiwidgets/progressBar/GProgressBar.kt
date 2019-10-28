package studio.visualdust.uiwidgets.progressBar

import studio.visualdust.uiwidgets.common.UIwidgets
import studio.visualdust.uiwidgets.theme.FlavorResource
import java.awt.*
import javax.swing.JPanel

class GProgressBar : JPanel, UIwidgets {

    override var bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_BG_STATIC)
    override var fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FG_STATIC)
        set(value) {
            field = value
        }
    var ftColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FT_STATIC)
    override var onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_BG_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FG_FOCUSED)
    var onActiveFT = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FT_FOCUSED)
    override var activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_BG_PRESSED)
    override var activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FG_PRESSED)
    var activedFT = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FT_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor
    var fromColor = nowBG
    var toColor = nowFG

    var frontPanel = JPanel()
    @JvmField
    var text = ""
    var displayStr = ""

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

    }

    var arcWidth = 10
    var arcHeight = 10
    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        arcWidth = this.height
        arcHeight = this.height
        this.background = this.parent.background
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
            coverWidth = ((nowValue - minValue) * 1.0 / (maxValue - minValue) * this.width).toInt()
        g2d.fillRoundRect(
            0,
            0,
            (coverWidth * 1.0).toInt(),
            (this.height * 1.0).toInt(),
            arcWidth,
            arcHeight
        )
        g2d.color = ftColor
        g2d.font = Font(
            FlavorResource.getFont(FlavorResource.Companion.fontEnum.DEFAULT).name,
            1,
            (this.height * 0.85).toInt()
        )

        if (textPainted && !textSetted)
            displayStr = ((nowValue - minValue + 1) * 100 / (maxValue - minValue + 1)).toString() + "%"
        var fontMetrics = g2d.getFontMetrics(g2d.font)
        g2d.drawString(
            displayStr,
            (this.width - fontMetrics.stringWidth(displayStr)) / 2,
            (this.height - fontMetrics.ascent - fontMetrics.descent) / 2 + fontMetrics.ascent
        )
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

    var textSetted = false
    var textPainted = false
        set(b) {
            when (b) {
                true -> displayStr = text
                false -> displayStr = ""
            }
            repaint()
            field = b
        }

    open fun setText(text: String) {
        this.text = text
        displayStr = when (textPainted) {
            true -> text
            false -> ""
        }
        textSetted = true
    }

    override fun setSize(d: Dimension) {
        setSize(d.width, d.height)
    }

    override fun setSize(width: Int, height: Int) {
        super.setSize(width, height)
    }

    override fun refreshUI() {
        bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_BG_STATIC)
        fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FG_STATIC)
        ftColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FT_STATIC)
        onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_BG_FOCUSED)
        onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FG_FOCUSED)
        onActiveFT = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FT_FOCUSED)
        activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_BG_PRESSED)
        activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FG_PRESSED)
        activedFT = FlavorResource.getColor(FlavorResource.Companion.colorEnum.PROGRESSBAR_FT_PRESSED)
        nowBG = bgColor
        nowFG = fgColor
        fromColor = nowBG
        toColor = nowFG
        this.repaint()
    }
}