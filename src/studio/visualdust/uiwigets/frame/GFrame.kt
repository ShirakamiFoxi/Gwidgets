package studio.visualdust.uiwigets.frame

import java.awt.Component
import javax.swing.JFrame
import javax.swing.JPanel

class GFrame : JFrame() {
    override fun add(comp: Component?): Component {
        if (comp != null)
            comp.repaint()
        return super.add(comp)
    }
}