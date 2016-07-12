enablePlugins(ScalaJSPlugin)

name := "Potato Kraft"

scalaVersion := "2.11.8"

scalaJSUseRhino in Global := false


resolvers += sbt.Resolver.bintrayRepo("denigma", "denigma-releases")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.denigma" %%% "threejs-facade" % "0.0.74-0.1.6",
  "com.github.japgolly.fork.scalaz" %%% "scalaz-core" % "7.2.0",
  "com.github.japgolly.fork.scalaz" %%% "scalaz-effect" % "7.2.0",
  "com.github.japgolly.fork.scalaz" %%% "scalaz-iteratee" % "7.2.0",
  "com.github.japgolly.fork.scalaz" %%% "scalaz-scalacheck-binding" % "7.2.0"
)
