package studio.visualdust.uiwigets.radioButton

import studio.visualdust.uiwigets.common.EventRW
import studio.visualdust.uiwigets.common.UIwigets
import studio.visualdust.uiwigets.theme.FlavorResource
import java.awt.Color
import javax.swing.JPanel
import studio.visualdust.uiwigets.theme.FlavorResource.Companion.colorEnum.*
import java.awt.Graphics
import java.awt.Graphics2D
import java.lang.Exception

class GRadioButton : JPanel, UIwigets {

    override var bgColor: Color = FlavorResource.getColor(CONTAINER_BG_3_STATIC)
    override var fgColor: Color = FlavorResource.getColor(CONTAINER_FG_3_STATIC)
    override var onActiveBG: Color = FlavorResource.getColor(CONTAINER_BG_3_FOCUSED)
    override var onActiveFG: Color = FlavorResource.getColor(CONTAINER_FG_3_FOCUSED)
    override var activedBG: Color = FlavorResource.getColor(CONTAINER_BG_3_PRESSED)
    override var activedFG: Color = FlavorResource.getColor(CONTAINER_BG_3_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor


    var colorChangeThread = ColorChangeThread(this, bgColor, fgColor)
    var selected = false
    var text = ""

    constructor(text: String) {
        this.text = text

    }

    init {

    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        var g2d = g as Graphics2D
    }

    override fun refreshUI() {

    }

    var onAnimation = false
    open fun isOnAnimation(): Boolean = onAnimation
}

class ColorChangeThread : Thread {

    var radioButtonObj: GRadioButton
    var nowColor: Color
    var toColorBG: Color
    var toColorFG: Color
    var interrupted = false

    constructor(radioButtonObj: GRadioButton, toColorBG: Color, toColorFG: Color) {
        this.radioButtonObj = radioButtonObj
        nowColor = this.radioButtonObj.bgColor
        this.toColorBG = toColorBG
        this.toColorFG = toColorFG
    }


    override fun run() {
        if (radioButtonObj.colorChangeThread != this) {
            radioButtonObj.colorChangeThread.interrupt()
        }
        radioButtonObj.onAnimation = true
//        println("Strat running : $this")

        val from_BG_RValue = radioButtonObj.nowBG.red * 1.0
        val from_BG_GValue = radioButtonObj.nowBG.green * 1.0
        val from_BG_BValue = radioButtonObj.nowBG.blue * 1.0
        val to_BG_RValue = toColorBG.red * 1.0
        val to_BG_GValue = toColorBG.green * 1.0
        val to_BG_BValue = toColorBG.blue * 1.0
        val sub_BG_RValue = map(from_BG_RValue, to_BG_RValue, 100)
        val sub_BG_GValue = map(from_BG_GValue, to_BG_GValue, 100)
        val sub_BG_BValue = map(from_BG_BValue, to_BG_BValue, 100)

        val from_FG_RValue = radioButtonObj.nowFG.red * 1.0
        val from_FG_GValue = radioButtonObj.nowFG.green * 1.0
        val from_FG_BValue = radioButtonObj.nowFG.blue * 1.0
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
            radioButtonObj.nowBG =
                Color(
                    (from_BG_RValue + i * sub_BG_RValue).toInt(),
                    (from_BG_GValue + i * sub_BG_GValue).toInt(),
                    (from_BG_BValue + i * sub_BG_BValue).toInt()
                )
            radioButtonObj.nowFG =
                Color(
                    (from_FG_RValue + i * sub_FG_RValue).toInt(),
                    (from_FG_GValue + i * sub_FG_GValue).toInt(),
                    (from_FG_BValue + i * sub_FG_BValue).toInt()
                )
            radioButtonObj.repaint()
            if (interrupted) return
        }
        radioButtonObj.nowBG = Color(to_BG_RValue.toInt(), to_BG_GValue.toInt(), to_BG_BValue.toInt())
        radioButtonObj.nowFG = Color(to_FG_RValue.toInt(), to_FG_GValue.toInt(), to_FG_BValue.toInt())
        radioButtonObj.repaint()
        radioButtonObj.onAnimation = false
//        println("Running finished : $this")
    }

    override fun interrupt() {
        this.interrupted = true
        super.interrupt()
    }

    fun map(from: Double, to: Double, times: Int): Double = (to - from) / times
}

