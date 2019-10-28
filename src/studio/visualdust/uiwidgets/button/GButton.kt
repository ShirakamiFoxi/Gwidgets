package studio.visualdust.uiwidgets.button

import studio.visualdust.uiwidgets.common.EventRW
import studio.visualdust.uiwidgets.common.UIwidgets
import studio.visualdust.uiwidgets.theme.FlavorResource
import studio.visualdust.uiwidgets.theme.FlavorResource.Companion.colorEnum.*
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JLabel
import javax.swing.JPanel

open class GButton : JPanel, UIwidgets {

    override var bgColor = FlavorResource.getColor(BUTTON_BG_STATIC)
    override var fgColor = FlavorResource.getColor(BUTTON_FG_STATIC)
    override var onActiveBG = FlavorResource.getColor(BUTTON_BG_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(BUTTON_FG_FOCUSED)
    override var activedBG = FlavorResource.getColor(BUTTON_BG_PRESSED)
    override var activedFG = FlavorResource.getColor(BUTTON_FG_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    var colorChangeThread = ColorChangeThread(this, bgColor, fgColor)
    var label = JLabel("", JLabel.CENTER)
    var text = ""
    var me = this

    enum class ButtonSeries {
        DEFAULT, NEXT_FEATURED, OK_FEATURED, WARN_FEATURED, ERROR_FEATURED, OPT_TYPE
    }

    constructor() {}
    constructor(text: String) {
        this.setDisplayText(text)
    }

    constructor(text: String, buttonSeries: ButtonSeries) {
        this.setDisplayText(text)
        when (buttonSeries) {
            ButtonSeries.DEFAULT -> {
            }
            ButtonSeries.NEXT_FEATURED -> {
                bgColor = FlavorResource.getColor(BUTTON_BG_NEXT_STATIC)
                fgColor = FlavorResource.getColor(BUTTON_FG_NEXT_STATIC)
                onActiveBG = FlavorResource.getColor(BUTTON_BG_NEXT_FOCUSED)
                onActiveFG = FlavorResource.getColor(BUTTON_FG_NEXT_FOCUSED)
                activedBG = FlavorResource.getColor(BUTTON_BG_NEXT_PRESSED)
                activedFG = FlavorResource.getColor(BUTTON_FG_NEXT_PRESSED)
                nowBG = bgColor
                nowFG = fgColor
            }
            ButtonSeries.OK_FEATURED -> {
                bgColor = FlavorResource.getColor(BUTTON_BG_OK_STATIC)
                fgColor = FlavorResource.getColor(BUTTON_FG_OK_STATIC)
                onActiveBG = FlavorResource.getColor(BUTTON_BG_OK_FOCUSED)
                onActiveFG = FlavorResource.getColor(BUTTON_FG_OK_FOCUSED)
                activedBG = FlavorResource.getColor(BUTTON_BG_OK_PRESSED)
                activedFG = FlavorResource.getColor(BUTTON_FG_OK_PRESSED)
                nowBG = bgColor
                nowFG = fgColor
            }
            ButtonSeries.WARN_FEATURED -> {
                bgColor = FlavorResource.getColor(BUTTON_BG_WARN_STATIC)
                fgColor = FlavorResource.getColor(BUTTON_FG_WARN_STATIC)
                onActiveBG = FlavorResource.getColor(BUTTON_BG_WARN_FOCUSED)
                onActiveFG = FlavorResource.getColor(BUTTON_FG_WARN_FOCUSED)
                activedBG = FlavorResource.getColor(BUTTON_BG_WARN_PRESSED)
                activedFG = FlavorResource.getColor(BUTTON_FG_WARN_PRESSED)
                nowBG = bgColor
                nowFG = fgColor
            }
            ButtonSeries.ERROR_FEATURED -> {
                bgColor = FlavorResource.getColor(BUTTON_BG_ERROR_STATIC)
                fgColor = FlavorResource.getColor(BUTTON_FG_ERROR_STATIC)
                onActiveBG = FlavorResource.getColor(BUTTON_BG_ERROR_FOCUSED)
                onActiveFG = FlavorResource.getColor(BUTTON_FG_ERROR_FOCUSED)
                activedBG = FlavorResource.getColor(BUTTON_BG_ERROR_PRESSED)
                activedFG = FlavorResource.getColor(BUTTON_FG_ERROR_PRESSED)
                nowBG = bgColor
                nowFG = fgColor
            }
            else -> {
            }
        }
    }

    init {
        label.addMouseListener(object : MouseAdapter() {
            override fun mouseEntered(e: MouseEvent?) {
                ColorChangeThread(me, onActiveBG, onActiveFG).start()
            }

            override fun mouseExited(e: MouseEvent?) {
                ColorChangeThread(me, bgColor, fgColor).start()
            }

            override fun mousePressed(e: MouseEvent?) {
                ColorChangeThread(me, activedBG, activedFG).start()
            }

            override fun mouseReleased(e: MouseEvent?) {
                if (me.hasFocus()) ColorChangeThread(me, onActiveBG, onActiveFG).start()
                else ColorChangeThread(me, bgColor, fgColor).start()
            }
        })
        this.layout = null
        this.add(label)
        label.setLocation(0, 0)
    }

    override fun addMouseListener(l: MouseListener?) {
        label.addMouseListener(l)
    }

    fun setDisplayText(text: String) {
        this.text = text
        label.text = text
    }

    enum class Shapes {
        rectangle, oval
    }

    var shape = Shapes.rectangle

    open fun setButtonShape(shape: Shapes) {
        this.shape = shape
        this.repaint()
    }

    var arcWidth = 10
    var arcHeight = 10
    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        this.background = this.parent.background
        super.paintComponent(g)
        val g2d = g as Graphics2D
        g2d.color = nowBG
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        when (shape) {
            Shapes.rectangle -> g2d.fillRoundRect(
                0,
                0,
                (this.width * 1.0).toInt(),
                (this.height * 1.0).toInt(),
                arcWidth,
                arcHeight
            )
            Shapes.oval -> g2d.fillOval(0, 0, this.width, this.height)
        }
        label.setSize(this.width, this.height)
        var fontSize = (me.width * 1.1 / (text.length - 0)).toInt()
        if (fontSize > (this.height * 0.9).toInt())
            fontSize = (this.height * 0.8).toInt()
        label.font = Font("等线", 1, fontSize)
        label.foreground = nowFG
    }

    override fun refreshUI() {
        bgColor = FlavorResource.getColor(BUTTON_BG_STATIC)
        fgColor = FlavorResource.getColor(BUTTON_FG_STATIC)
        onActiveBG = FlavorResource.getColor(BUTTON_BG_FOCUSED)
        onActiveFG = FlavorResource.getColor(BUTTON_FG_FOCUSED)
        activedBG = FlavorResource.getColor(BUTTON_BG_PRESSED)
        activedFG = FlavorResource.getColor(BUTTON_FG_PRESSED)
        nowBG = bgColor
        nowFG = fgColor
        this.repaint()
    }

    var onAnimation = false
    open fun isOnAnimation(): Boolean = onAnimation
}

class ColorChangeThread : Thread {

    var buttonObj: GButton
    var nowColor: Color
    var toColorBG: Color
    var toColorFG: Color
    var interrupted = false

    constructor(buttonObj: GButton, toColorBG: Color, toColorFG: Color) {
        this.buttonObj = buttonObj
        nowColor = buttonObj.bgColor
        this.toColorBG = toColorBG
        this.toColorFG = toColorFG
    }


    override fun run() {
        if (buttonObj.colorChangeThread != this) {
            buttonObj.colorChangeThread.interrupt()
        }
        buttonObj.onAnimation = true

        val from_BG_RValue = buttonObj.nowBG.red * 1.0
        val from_BG_GValue = buttonObj.nowBG.green * 1.0
        val from_BG_BValue = buttonObj.nowBG.blue * 1.0
        val to_BG_RValue = toColorBG.red * 1.0
        val to_BG_GValue = toColorBG.green * 1.0
        val to_BG_BValue = toColorBG.blue * 1.0
        val sub_BG_RValue = map(from_BG_RValue, to_BG_RValue, 100)
        val sub_BG_GValue = map(from_BG_GValue, to_BG_GValue, 100)
        val sub_BG_BValue = map(from_BG_BValue, to_BG_BValue, 100)

        val from_FG_RValue = buttonObj.nowFG.red * 1.0
        val from_FG_GValue = buttonObj.nowFG.green * 1.0
        val from_FG_BValue = buttonObj.nowFG.blue * 1.0
        val to_FG_RValue = toColorFG.red * 1.0
        val to_FG_GValue = toColorFG.green * 1.0
        val to_FG_BValue = toColorFG.blue * 1.0
        val sub_FG_RValue = map(from_FG_RValue, to_FG_RValue, 60)
        val sub_FG_GValue = map(from_FG_GValue, to_FG_GValue, 60)
        val sub_FG_BValue = map(from_FG_BValue, to_FG_BValue, 60)

        for (i in 1..60) {
            try {
                sleep(1)
            } catch (e: Exception) {
                EventRW.write(e)
            }
            buttonObj.nowBG =
                Color(
                    (from_BG_RValue + i * sub_BG_RValue).toInt(),
                    (from_BG_GValue + i * sub_BG_GValue).toInt(),
                    (from_BG_BValue + i * sub_BG_BValue).toInt()
                )
            buttonObj.nowFG =
                Color(
                    (from_FG_RValue + i * sub_FG_RValue).toInt(),
                    (from_FG_GValue + i * sub_FG_GValue).toInt(),
                    (from_FG_BValue + i * sub_FG_BValue).toInt()
                )
            buttonObj.repaint()
            if (interrupted) return
        }
        buttonObj.nowBG = Color(to_BG_RValue.toInt(), to_BG_GValue.toInt(), to_BG_BValue.toInt())
        buttonObj.nowFG = Color(to_FG_RValue.toInt(), to_FG_GValue.toInt(), to_FG_BValue.toInt())
        buttonObj.repaint()
        buttonObj.onAnimation = false
//        println("Running finished : $this")
    }

    override fun interrupt() {
        this.interrupted = true
        super.interrupt()
    }

    fun map(from: Double, to: Double, times: Int): Double = (to - from) / times
}