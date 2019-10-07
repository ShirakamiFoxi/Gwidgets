package studio.visualdust.uiwigets.stage

class ComponentConfig {
    var locXRatio = 0.00000
    var locYRatio = 0.00000
    var widthRatio = 0.00000
    var heightRatio = 0.00000

    constructor() {}

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