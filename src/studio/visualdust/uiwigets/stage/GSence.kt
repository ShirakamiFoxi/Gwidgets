package studio.visualdust.uiwigets.stage

import java.awt.Component
import java.awt.Dimension
import java.util.*
import javax.swing.JPanel

class GSence : JPanel {

    var isOnDisplay = false
    var components = Vector<Component>()
    var cptConfigs = Vector<ComponentConfig>()

    var defaultBindType = ComponentConfig.BindTypes.NULL

    constructor() {}

    constructor(bindType: ComponentConfig.BindTypes) {
        this.defaultBindType = bindType
    }

    init {
        this.layout = null
    }

    override fun add(comp: Component): Component {
        return this.add(comp, defaultBindType)
    }

    fun add(comp: Component, bindType: ComponentConfig.BindTypes): Component {
        if (!components.contains(comp)) {
            components.add(comp)
            cptConfigs.add(ComponentConfig(bindType))
        }
        return super.add(comp)
    }

    fun removeComp(comp: Component?) {
        if (components.contains(comp)) {
            cptConfigs.removeElementAt(components.indexOf(comp))
            components.remove(comp)
            super.remove(comp)
        }
    }

    fun removeCompAt(index: Int) {
        if (index < components.size) {
            var targetComp = components.elementAt(index)
            this.remove(targetComp)
            components.removeElementAt(index)
            cptConfigs.removeElementAt(index)
        }
    }

    override fun setSize(d: Dimension) {
        var width = d.width
        var height = d.height
        this.setSize(width, height)
    }

    override fun setSize(width: Int, height: Int) {
//        var targetWidth = width
//        var targetHeight = height
        for (i in 0 until components.size) {
            when (cptConfigs.elementAt(i).bindType) {
                ComponentConfig.BindTypes.SIZE_BIND -> {
                    var targetComp = components.elementAt(i)
                    cptConfigs.setElementAt(
                        ComponentConfig(
                            targetComp.x * 1.0 / this.width,
                            targetComp.y * 1.0 / this.height,
                            targetComp.width * 1.0 / this.width,
                            targetComp.height * 1.0 / this.height
                        ), i
                    )
                    cptConfigs.elementAt(i).bindType = ComponentConfig.BindTypes.SIZE_BIND
                }
            }
        }
        super.setSize(width, height)
        for (i in 0 until components.size) {
            when (cptConfigs.elementAt(i).bindType) {
                ComponentConfig.BindTypes.SIZE_BIND -> {
                    components.elementAt(i).setLocation(
                        (cptConfigs.elementAt(i).locXRatio * this.width).toInt(),
                        (cptConfigs.elementAt(i).locYRatio * this.height).toInt()
                    )
//            println("NowLocation : ${components.elementAt(i).location}")
                    components.elementAt(i).setSize(
                        (cptConfigs.elementAt(i).widthRatio * this.width).toInt(),
                        (cptConfigs.elementAt(i).heightRatio * this.height).toInt()
                    )
//            println("NowSize : ${components.elementAt(i).size}")
                }
            }
        }
    }
}