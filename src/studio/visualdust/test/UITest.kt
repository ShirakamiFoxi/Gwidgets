package studio.visualdust.test

import studio.visualdust.uiwigets.theme.FlavorResource
import studio.visualdust.uiwigets.button.GButton
import studio.visualdust.uiwigets.stage.GStage
import studio.visualdust.uiwigets.passwordField.GpasswordField
import java.awt.Color
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.WindowConstants.*

fun main(args: Array<String>) {
    FlavorResource.Initialize()
    var frame = GStage()
    frame.layout = null
    frame.setSize(500, 500)
    var button1 = GButton("Button_1")
    button1.setLocation(10, 10)
    button1.setSize(400, 200)
    frame.add(button1)

    var button2 = GButton(
        "Button_2",
        GButton.ButtonSeries.WARN_FEATURED
    )
    button2.setButtonShape(GButton.Shapes.oval)
    button2.setLocation(10, 220)
    button2.setSize(100, 100)
    frame.add(button2)

    var button3 = GButton(
        "Button_3",
        GButton.ButtonSeries.NEXT_FEATURED
    )
    button3.setButtonShape(GButton.Shapes.oval)
    button3.setLocation(110, 220)
    button3.setSize(100, 100)
    frame.add(button3)

    var button4 = GButton(
        "OKKKK",
        GButton.ButtonSeries.OK_FEATURED
    )
    button4.setLocation(10, 330)
    button4.setSize(160, 80)
    frame.add(button4)

    var gPasswordField = GpasswordField(Color(52, 88, 133))
    gPasswordField.setLocation(10, 330)
    gPasswordField.setSize(250, 50)

    button4.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            frame.remove(button4)
            frame.add(gPasswordField)
            gPasswordField.setPassword("123")
            frame.repaint()
        }
    })

    button1.addMouseListener(object :MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            println(gPasswordField.getPassword())
        }
    })

    frame.contentPane.background = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_0_STATIC)
    frame.isVisible = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
}