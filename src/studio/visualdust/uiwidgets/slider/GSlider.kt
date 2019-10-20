package studio.visualdust.uiwidgets.slider

import studio.visualdust.uiwidgets.button.GButton
import studio.visualdust.uiwidgets.common.UIwidgets
import studio.visualdust.uiwidgets.theme.FlavorResource
import studio.visualdust.uiwidgets.theme.FlavorResource.Companion.colorEnum.*
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class GSlider : JPanel, UIwidgets {
    override var bgColor = FlavorResource.getColor(CONTAINER_BG_3_STATIC)
    override var fgColor = FlavorResource.getColor(CONTAINER_FG_3_STATIC)
    override var onActiveBG = FlavorResource.getColor(CONTAINER_BG_3_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(CONTAINER_FG_3_STATIC)
    override var activedBG = FlavorResource.getColor(CONTAINER_BG_3_PRESSED)
    override var activedFG = FlavorResource.getColor(CONTAINER_FG_3_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    var minValue = 0
    var maxValue = 100
    var nowValue = 0

    var tab = GButton("", GButton.ButtonSeries.DEFAULT)

    constructor(minValue: Int, maxValue: Int) {
        this.maxValue = maxValue
        this.minValue = minValue
    }

    var tabWidth = 20
    var tabHeight = 20

    init {
        tab.setButtonShape(GButton.Shapes.oval)
        tab.setSize(tabWidth, tabHeight)
        //todo add listeners here
    }

    var sliderHeight = 3
    var sliderArcWidth = 3
    var sliderArcHeight = 3
    override fun paintComponent(g: Graphics?) {
//        super.paintComponent(g)
        var g2d = g as Graphics2D
        g2d.color = nowFG
        g2d.fillRoundRect(
            tabWidth / 2,
            (this.height - sliderHeight) / 2,
            this.width - tabWidth,
            sliderHeight,
            sliderArcWidth,
            sliderArcHeight
        )
    }

    fun setValue(value: Int) {
        this.nowValue = value
        //todo change tab location here
//        tab.setLocation(
//            (this.nowValue - this.minValue) / (this.maxValue - this.minValue),
//            (this.height - tabHeight) / 2
//        )

    }

    override fun setSize(d: Dimension) {
        var width = d.width
        var height = d.height
        this.setSize(width, height)
    }

    var minSliderWidth = tabWidth
    var minSliderHeight = tabHeight
    override fun setSize(width: Int, height: Int) {
        var width = width
        var height = height
        if (width < minSliderWidth) width = minSliderWidth
        if (height < minSliderHeight) height = minSliderHeight
        super.setSize(width, height)
        this.repaint()
    }

    override fun refreshUI() {
        bgColor = FlavorResource.getColor(CONTAINER_FG_3_STATIC)
        fgColor = FlavorResource.getColor(CONTAINER_FG_3_STATIC)
        onActiveBG = FlavorResource.getColor(CONTAINER_BG_3_FOCUSED)
        onActiveFG = FlavorResource.getColor(CONTAINER_FG_3_STATIC)
        activedBG = FlavorResource.getColor(CONTAINER_BG_3_PRESSED)
        activedFG = FlavorResource.getColor(CONTAINER_FG_3_PRESSED)
        nowBG = bgColor
        nowFG = fgColor
        this.repaint()
    }
}

//private class SliderTab : JPanel {
//    var tabWidth = 10
//
//    var tabHeight = 20
//    var tabColor = Color(200, 200, 200)
//
//    //    var tabArcHeight = 5
////    var tabArcWidth = 5
//    constructor(color: Color) {
//        this.tabColor = color
//    }
//
//    override fun paintComponent(g: Graphics?) {
////        super.paintComponent(g)
//        var g2d = g as Graphics2D
//        g2d.color = tabColor
//        g2d.fillOval(0, 0, this.tabWidth, this.tabHeight)
//    }
//
//    override fun setSize(d: Dimension) {
//        var width = d.width
//        var height = d.height
//        this.setSize(width, height)
//    }
//
//    override fun setSize(width: Int, height: Int) {
//        this.tabWidth = width
//        this.tabHeight = height
//        super.setSize(width, height)
//    }
//}