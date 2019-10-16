package studio.visualdust.uiwigets.stage

import java.awt.Dimension

class ComponentConfig {
    var locXRatio = 0.00000
    var locYRatio = 0.00000
    var widthRatio = 0.00000
    var heightRatio = 0.00000

    enum class BindSides {
        LEFT, RIGHT, TOP, BOTTOM, MID, POINT
    }

    enum class BindTypes {
        NULL, SIZE_BIND, SIDE_BIND
    }

    var bindPoint = Dimension(-1, -1)
    var bindType = BindTypes.NULL

    constructor(bindType: BindTypes){
        this.bindType=bindType
    }

    constructor() {
        this.bindType=BindTypes.NULL
    }

    constructor(
        locXRatio: Double,
        locYRatio: Double,
        widthRatio: Double,
        heightRatio: Double
    ) {
        this.locXRatio = locXRatio
        this.locYRatio = locYRatio
        this.widthRatio = widthRatio
        this.heightRatio = heightRatio
    }
}