package studio.visualdust.uiwigets.passwordField

import studio.visualdust.uiwigets.common.EventRW
import studio.visualdust.uiwigets.theme.FlavorResource
import studio.visualdust.uiwigets.theme.FlavorResource.Companion.colorEnum.*
import studio.visualdust.uiwigets.common.UIwigets
import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.lang.Exception
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.border.EmptyBorder

class GpasswordField : JPanel, UIwigets {

    var tagWidth = 10

    override var bgColor = FlavorResource.getColor(CONTAINER_BG_2_STATIC)
    override var fgColor = FlavorResource.getColor(CONTAINER_FG_2_STATIC)
    override var onActiveBG = FlavorResource.getColor(CONTAINER_BG_2_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(CONTAINER_FG_2_FOCUSED)
    override var activedBG = FlavorResource.getColor(CONTAINER_BG_2_PRESSED)
    override var activedFG = FlavorResource.getColor(CONTAINER_FG_2_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    var me = this
    var passwordField = JPasswordField()
    var tag = JPanel()
    var colorChangeThread = ColorChangeThread(this, bgColor, fgColor)

    constructor() {
        tag.background=bgColor
    }
    constructor(color: Color) {
        tag.background = color
    }

    var onAnimation = false
    open fun isOnAnimation() = onAnimation

    init {
        passwordField.addMouseListener(object : MouseAdapter() {
            override fun mouseEntered(e: MouseEvent?) {
                ColorChangeThread(me, onActiveBG, onActiveFG).start()
                super.mouseEntered(e)
            }

            override fun mouseExited(e: MouseEvent?) {
                ColorChangeThread(me, bgColor, fgColor).start()
                super.mouseExited(e)
            }

            override fun mousePressed(e: MouseEvent?) {
                ColorChangeThread(me, activedBG, activedFG).start()
                super.mousePressed(e)
            }

            override fun mouseReleased(e: MouseEvent?) {
                if (me.hasFocus()) ColorChangeThread(me, onActiveBG, onActiveFG).start()
                else ColorChangeThread(me, bgColor, fgColor).start()
                super.mouseReleased(e)
            }
        })
        this.layout = null
        passwordField.setBorder(EmptyBorder(0, 0, 0, 0))
        this.background = bgColor
        this.foreground = fgColor
        passwordField.background = bgColor
        passwordField.foreground = fgColor
        this.add(passwordField)
        this.add(tag)
        this.repaint()
    }

    override fun paintComponent(g: Graphics?) {
        //todo finish this function
        var dividerWidth = 10
        tag.setSize(tagWidth, this.height)
        tag.setLocation(0, 0)
        passwordField.setSize(this.width - tagWidth - dividerWidth, this.height)
        passwordField.setLocation(tagWidth + dividerWidth, 0)
        passwordField.font = Font(passwordField.font.name, 0, (this.height * 0.5).toInt())
        super.paintComponent(g)
    }

    open fun getPassword() = passwordField.password
    open fun setPassword(password: String) {
        passwordField.text = password
    }

    open fun setTagColor(color:Color){
        tag.background=color
    }

    override fun refreshUI() {

    }
}

class ColorChangeThread : Thread {

    var textFiledObj: GpasswordField
    var toColorBG: Color
    var toColorFG: Color
    var interrupted = false

    constructor(textFiledObj: GpasswordField, toColorBG: Color, toColorFG: Color) {
        this.textFiledObj = textFiledObj
        this.toColorBG = toColorBG
        this.toColorFG = toColorFG
    }

    override fun run() {
        if (textFiledObj.colorChangeThread != this) {
            textFiledObj.colorChangeThread.interrupt()
        }
        textFiledObj.onAnimation = true
//        println("Strat running : $this")

        val from_BG_RValue = textFiledObj.passwordField.background.red * 1.0
        val from_BG_GValue = textFiledObj.passwordField.background.green * 1.0
        val from_BG_BValue = textFiledObj.passwordField.background.blue * 1.0
        val to_BG_RValue = toColorBG.red * 1.0
        val to_BG_GValue = toColorBG.green * 1.0
        val to_BG_BValue = toColorBG.blue * 1.0
        val sub_BG_RValue = map(from_BG_RValue, to_BG_RValue, 100)
        val sub_BG_GValue = map(from_BG_GValue, to_BG_GValue, 100)
        val sub_BG_BValue = map(from_BG_BValue, to_BG_BValue, 100)

        val from_FG_RValue = textFiledObj.passwordField.foreground.red * 1.0
        val from_FG_GValue = textFiledObj.passwordField.foreground.green * 1.0
        val from_FG_BValue = textFiledObj.passwordField.foreground.blue * 1.0
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
            textFiledObj.passwordField.background =
                Color(
                    (from_BG_RValue + i * sub_BG_RValue).toInt(),
                    (from_BG_GValue + i * sub_BG_GValue).toInt(),
                    (from_BG_BValue + i * sub_BG_BValue).toInt()
                )
            textFiledObj.background = textFiledObj.passwordField.background

            textFiledObj.passwordField.foreground =
                Color(
                    (from_FG_RValue + i * sub_FG_RValue).toInt(),
                    (from_FG_GValue + i * sub_FG_GValue).toInt(),
                    (from_FG_BValue + i * sub_FG_BValue).toInt()
                )
            textFiledObj.foreground = textFiledObj.passwordField.foreground
            textFiledObj.repaint()
            if (interrupted) return
        }
        textFiledObj.passwordField.background = Color(to_BG_RValue.toInt(), to_BG_GValue.toInt(), to_BG_BValue.toInt())
        textFiledObj.passwordField.foreground = Color(to_FG_RValue.toInt(), to_FG_GValue.toInt(), to_FG_BValue.toInt())
        textFiledObj.background = textFiledObj.passwordField.background
        textFiledObj.foreground = textFiledObj.passwordField.foreground
        textFiledObj.repaint()
        textFiledObj.onAnimation = false
//        println("Running finished : $this")
    }

    override fun interrupt() {
        this.interrupted = true
        super.interrupt()
    }

    fun map(from: Double, to: Double, times: Int): Double = (to - from) / times
}