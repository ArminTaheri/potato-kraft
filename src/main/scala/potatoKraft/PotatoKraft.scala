package potatoKraft

import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object PotatoKraft extends js.JSApp {
  var graphics: GraphicsEngine = null
  var window: dom.Window = null

  @JSExport
  def init(win: dom.Window, view: dom.html.Div): Unit = {
    window = win
    graphics = new GraphicsEngine(view)
  }

  def main(): Unit = {
    if (graphics == null || window == null) {
      throw new Exception("Must call PotatoKraft.init before main." )
    }

    js.Dynamic.global.requestAnimationFrame(graphics.renderLoop _)
    graphics.windowResize(null)
    window.onresize = graphics.windowResize _
  }
}
