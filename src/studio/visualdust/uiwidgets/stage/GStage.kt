package studio.visualdust.uiwidgets.stage

import java.awt.Component
import java.awt.Graphics
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

class GStage : JFrame() {
    var glassPane = JPanel()
    var sences = Vector<GSence>()
    var senceOnDisplay: GSence? = GSence()

    init {
        glassPane.setLocation(0, 0)
        this.add(glassPane)
        this.setGlassPane(glassPane)
    }

    open fun addSence(sence: GSence): Int {
        sences.add(sence)
        return sences.size - 1
    }

    open fun switchSence(index: Int): Boolean {
        if (sences.size - 1 < index) return false
        var targetSence = sences.elementAt(index)
        this.removeAll()
        senceOnDisplay?.isOnDisplay = false
        senceOnDisplay = targetSence
        targetSence.isOnDisplay = true
        this.add(targetSence)
        return true
    }

    open fun switchSence(sence: GSence): Boolean {
        if (!sences.contains(sence))
            return switchSence(this.addSence(sence))
        else if (sences.contains(sence) && !sence.equals(senceOnDisplay))
            return switchSence(sences.indexOf(sence))
        return true
    }

    open fun removeSence(index: Int): Boolean {
        if (sences.size - 1 < index) return false
        if (sences.elementAt(index).isOnDisplay) {
            this.remove(sences.elementAt(index))
            senceOnDisplay = null
        }
        sences.removeElementAt(index)
        return true
    }

    open fun removeSence(sence: GSence): Boolean {
        if (!sences.contains(sence)) return false
        return removeSence(sences.indexOf(sence))
    }

    override fun paintComponents(g: Graphics?) {
        super.paintComponents(g)
        glassPane.setSize(this.size)
    }

    override fun add(comp: Component?): Component {
//        if (comp != null)
//            comp.repaint()
        return super.add(comp)
    }
}