package studio.visualdust.uiwidgets.imageView

import studio.visualdust.uiwidgets.common.UIwidgets
import studio.visualdust.uiwidgets.theme.FlavorResource
import java.awt.*
import java.awt.image.BufferedImage
import javax.swing.JPanel

/**
 * @author MiyaAkasaki <VisualDust@outlook.com>
 * @version 0.0.0.1
 * Update on 20191024.
 */
class GImagePaenl : UIwidgets, JPanel {
    override var bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_1_STATIC)
    override var fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_1_STATIC)
    override var onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_1_FOCUSED)
    override var onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_1_FOCUSED)
    override var activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_1_PRESSED)
    override var activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_1_PRESSED)
    override var nowBG = bgColor
    override var nowFG = fgColor

    var image: Image
        set(value) {
            field = value
            this.repaint()
        }

    enum class PaintingType {
        STRETCH, AUTO_FIT_SMALLER_SIDE, AUTO_FIT_BIGGER_SIDE, WIDTH_FIT, HEIGHT_FIT
    }

    var defaultPaintingType = PaintingType.STRETCH
    var paintingType = defaultPaintingType

    constructor(image: Image) {
        this.image = image
    }

    constructor(image: Image, paintingType: PaintingType) {
        this.image = image
        this.paintingType = paintingType
    }

    init {
        this.layout = null
    }

    var maxWidth = this.width
    var maxHeight = this.height
    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        if (g != null) {
            maxWidth = this.width
            maxHeight = this.height
            var bi = image as BufferedImage
            var g2d = g as Graphics2D
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            when (this.paintingType) {
                PaintingType.STRETCH -> g2d.drawImage(image, 0, 0, maxWidth, maxHeight, this)
                PaintingType.AUTO_FIT_SMALLER_SIDE -> if (bi.width / this.width > bi.height / this.height)
                    paintingType = PaintingType.HEIGHT_FIT
                else paintingType = PaintingType.WIDTH_FIT
                PaintingType.AUTO_FIT_BIGGER_SIDE -> if (bi.width / this.width < bi.height / this.height)
                    paintingType = PaintingType.HEIGHT_FIT
                else paintingType = PaintingType.WIDTH_FIT
                PaintingType.WIDTH_FIT -> g2d.drawImage(
                    image,
                    0,
                    (this.height - bi.height) / 2,
                    this.width,
                    this.width / bi.width * bi.height,
                    this
                )
                PaintingType.HEIGHT_FIT -> g2d.drawImage(
                    image,
                    (this.width - bi.width) / 2,
                    0,
                    this.height / bi.height * bi.width,
                    this.height,
                    this
                )
            }
        }
    }

    override fun setSize(d: Dimension) {
        super.setSize(d.width, d.height)
    }

    override fun setSize(width: Int, height: Int) {
        super.setSize(width, height)
    }

    override fun refreshUI() {
        bgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_1_STATIC)
        fgColor = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_1_STATIC)
        onActiveBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_1_FOCUSED)
        onActiveFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_1_FOCUSED)
        activedBG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_BG_1_PRESSED)
        activedFG = FlavorResource.getColor(FlavorResource.Companion.colorEnum.CONTAINER_FG_1_PRESSED)
        nowBG = bgColor
        nowFG = fgColor
    }
}