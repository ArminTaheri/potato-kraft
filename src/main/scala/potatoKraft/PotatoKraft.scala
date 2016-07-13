package potatoKraft

import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object PotatoKraft extends js.JSApp {
  def main(): Unit = {} // 

  @JSExport
  def run(view: dom.html.Div): Unit = {
    val graphics = new GraphicsEngine(view)

    js.Dynamic.global.requestAnimationFrame(graphics.renderLoop _)
    js.Dynamic.global.onresize = graphics.windowResize _
  }
}
