package studio.visualdust.test

import studio.visualdust.uiwidgets.theme.FlavorResource
import studio.visualdust.uiwidgets.button.GButton
import studio.visualdust.uiwidgets.stage.GStage
import studio.visualdust.uiwidgets.passwordField.GpasswordField
import studio.visualdust.uiwidgets.progressBar.GProgressBar
import java.awt.Color
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.WindowConstants.*
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    FlavorResource.Initialize()
    var stage = GStage()
    stage.layout = null
    stage.setSize(500, 600)
    var button1 = GButton("Button_1")
    button1.setLocation(10, 10)
    button1.setSize(400, 200)
    stage.add(button1)

    var button2 = GButton(
        "Button_2",
        GButton.ButtonSeries.WARN_FEATURED
    )
    button2.setButtonShape(GButton.Shapes.oval)
    button2.setLocation(10, 220)
    button2.setSize(100, 100)
    stage.add(button2)

    var button3 = GButton(
        "Button_3",
        GButton.ButtonSeries.NEXT_FEATURED
    )
    button3.setButtonShape(GButton.Shapes.oval)
    button3.setLocation(110, 220)
    button3.setSize(100, 100)
    stage.add(button3)

    var button4 = GButton(
        "OKKKK",
        GButton.ButtonSeries.OK_FEATURED
    )
    button4.setLocation(10, 330)
    button4.setSize(160, 80)
    stage.add(button4)

    var gPasswordField = GpasswordField(Color(52, 88, 133))
    gPasswordField.setLocation(10, 330)
    gPasswordField.setSize(250, 50)

    button4.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            stage.remove(button4)
            stage.add(gPasswordField)
            gPasswordField.setPassword("123")
            stage.repaint()
        }
    })

    button1.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            println(gPasswordField.getPassword())
        }
    })

    var progressBar = GProgressBar(1, 100)
    progressBar.setSize(200, 20)
    progressBar.setLocation(10, 440)
//    progressBar.setValue(5)
    progressBar.textPainted = true
    stage.add(progressBar)
    button2.addMouseListener(object : MouseAdapter() {
        override fun mousePressed(e: MouseEvent?) {
            thread {
                for (i in 0..100) {
                    Thread.sleep(10)
                    progressBar.setValue(i)
                }
            }
        }
    })

    stage.contentPane.background = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_0_STATIC)
    stage.isVisible = true
    stage.defaultCloseOperation = EXIT_ON_CLOSE
}