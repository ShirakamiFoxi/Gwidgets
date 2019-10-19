package studio.visualdust.uiwigets.slider

import studio.visualdust.uiwigets.common.UIwigets
import studio.visualdust.uiwigets.theme.FlavorResource
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JFrame
import javax.swing.JPanel

class GSlider : JPanel, UIwigets {

    override var bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_STATIC)
    override var fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_STATIC)
    override var onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_FOCUSED)
    override var activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_PRESSED)
    override var activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    var minValue = 0;
    var maxValue = 100;
    var nowValue = 0

    var me = this

    constructor(minValue: Int, maxValue: Int) {
        this.minValue = minValue
        this.maxValue = maxValue
    }

    var isPressed = false
    var lastReleasePos = Dimension(0, 0)

    private var tab = SliderTab(nowFG)
    var tabWidth = 4
    var tabHeight = 10

    init {
        tab.setSize(tabWidth, tabHeight)
        this.add(tab)
//        this.tab.addMouseListener(object : MouseAdapter() {
//            override fun mousePressed(e: MouseEvent?) {
//                me.isPressed = true
//                if (e != null) {
//                    lastReleasePos = Dimension(e.x, e.y)
//                }
//            }
//
//            override fun mouseReleased(e: MouseEvent?) {
//                me.isPressed = false
//            }
//
//            override fun mouseMoved(e: MouseEvent?) {
//                println("!!!")
//                if (me.isPressed) {
//                    var oriValue = getValue()
//                    if (e != null) {
//                        me.setValue(oriValue + (e.x - lastReleasePos.width) / me.width * (maxValue - minValue))
//                    }
//                }
//            }
//        })
    }

    fun setValue(value: Int) {
        var value = value
        if (value < minValue)
            value = minValue
        if (value > maxValue)
            value = maxValue
        this.nowValue = value
        this.repaint()
    }

    fun getValue() = nowValue

    var sliderWidth = this.width
    var sliderHeight = 4
    var sliderArcWidth = 3
    var sliderArcHeight = 3
    var suffixLenHeight = 3
    override fun paintComponent(g: Graphics?) {
//                super.paintComponent(g)
        var g2d = g as Graphics2D
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g2d.color = nowBG
        g2d.fillRoundRect(
            0,
            (this.height - sliderHeight) / 2,
            sliderWidth,
            sliderHeight,
            sliderArcWidth,
            sliderArcHeight
        )
        tab.setLocation(
            this.width * nowValue / (maxValue - minValue) - tabWidth / 2,
            (this.height - tabHeight) / 2 - suffixLenHeight
        )
        //todo finish this function
    }

    override fun setSize(d: Dimension) {
        var width = d.width
        var height = d.height
        this.setSize(width, height)
    }

    var minWidth = 10
    var minHeight = 13
    override fun setSize(width: Int, height: Int) {
        var wid = width
        if (wid < minWidth) wid = minWidth
        var hei = height
        if (hei < minHeight) hei = minHeight
        tab.setSize(tabWidth, tabHeight)
        super.setSize(wid, hei)
    }

    override fun refreshUI() {
        bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_STATIC)
        fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_STATIC)
        onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_FOCUSED)
        onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_FOCUSED)
        activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_3_PRESSED)
        activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_3_PRESSED)
        nowBG = bgColor
        nowFG = fgColor
        tab = SliderTab(nowFG)
    }
}

/**
 * Slider tab class......
 */
private class SliderTab : JPanel {

    var color: Color

    constructor(color: Color) {
        this.color = color
    }

    var tabArcWidth = 2
    var tabArcHeight = 2

    override fun paintComponent(g: Graphics?) {
        var g2d = g as Graphics2D
        g2d.color = this.color
        g2d.fillRoundRect(0, 0, this.width, this.height, tabArcWidth, tabArcHeight)
        super.paintComponent(g)
    }

    override fun setSize(d: Dimension) {
        var width = d.width
        var height = d.height
        this.setSize(width, height)
    }

    var minWidth = 4
    var minHeight = 10
    override fun setSize(width: Int, height: Int) {
        var wid = when (width < minWidth) {
            true -> minWidth
            false -> width
        }
        var hei = when (height < minHeight) {
            true -> minHeight
            false -> height
        }
        super.setSize(wid, hei)
    }
}
