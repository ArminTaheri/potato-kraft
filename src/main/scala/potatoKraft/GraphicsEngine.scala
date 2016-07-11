package potatoKraft

import org.scalajs.dom
import org.denigma.threejs._
import scala.scalajs.js

class GraphicsEngine(parent: dom.html.Div) {
  val renderer = new WebGLRenderer()

  val VIEWSIZE = 900
  val camera = new OrthographicCamera()
  camera.near = -1000
  camera.far = 1000
  camera.position.z = 1.0
  camera.lookAt(new Vector3(0.0, 0.0, -1.0))

  val scene = new Scene()
  sceneAdd(camera)

// test
  parent.appendChild(renderer.domElement)
  val mat = new MeshBasicMaterial()
  mat.color = new Color(1.0, 1.0, 1.0)
  val sphere = new Mesh(new SphereGeometry(100, 16, 16), mat)
  sphere.position.z = -300 
  sceneAdd(sphere)
// end test

  def sceneAdd(obj: Object3D): Unit = scene.add(obj)
  def sceneRemove(obj: Object3D): Unit = scene.remove(obj)

  def renderLoop(time: Double): Unit = {
    js.Dynamic.global.requestAnimationFrame(renderLoop _)
    renderer.render(scene, camera)
    camera.position.z += 0.01
  }
  
  def windowResize(evt: dom.UIEvent): Unit = {
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
