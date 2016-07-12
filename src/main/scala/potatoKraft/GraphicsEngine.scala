package potatoKraft

import org.scalajs.dom
import org.denigma.threejs._
import scala.scalajs.js
import js.DynamicImplicits.number2dynamic

class GraphicsEngine(parent: dom.html.Div) {

  val VIEWSIZE = 900

  val renderer = new WebGLRenderer()

  val scene = new Scene()

  val camera = new OrthographicCamera()
  camera.near = -VIEWSIZE.toDouble
  camera.far = VIEWSIZE.toDouble
  sceneAdd(camera)

  parent.appendChild(renderer.domElement)


  def sceneAdd(obj: Object3D): Unit = scene.add(obj)
  def sceneRemove(obj: Object3D): Unit = scene.remove(obj)

  def renderLoop(time: Double): Unit = {
    js.Dynamic.global.requestAnimationFrame(renderLoop _)
    renderer.render(scene, camera)
  }
  
  def windowResize(evt: dom.UIEvent): Unit = {
    parent.style.width = (js.Dynamic.global.innerWidth - 18) + "px"
    parent.style.height = (js.Dynamic.global.innerHeight - 18) + "px"

    val width = parent.clientWidth.toDouble;
    val height = parent.clientHeight.toDouble;

    val aspectRatio = width/height
    val viewportSize = aspectRatio*VIEWSIZE

    renderer.setSize(width, height)

    camera.left = -viewportSize/2.0
    camera.right = viewportSize/2.0
    camera.top = -VIEWSIZE/2.0
    camera.left = VIEWSIZE/2.0
  }
}
