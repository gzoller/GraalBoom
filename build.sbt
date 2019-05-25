ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"

val scalaTest    = "org.scalatest"      %% "scalatest"      % "3.0.8-RC2"
val graalvm      = "org.graalvm.sdk"    % "graal-sdk"       % "1.0.0-rc16"
val graaljs      = "org.graalvm.js"     % "js-scriptengine" % "1.0.0-rc16"
val graaljs2     = "org.graalvm.js"     % "js"              % "1.0.0-rc16"


val basicSettings = Seq(
  parallelExecution := false,
  Test / parallelExecution := false,
  resolvers += "Bintray Releases" at "http://dl.bintray.com/blocke/releases/",
)

lazy val root = (project in file("."))
  .settings(basicSettings: _*)
  .settings(
    name := "graalboom",
    libraryDependencies ++= Seq(graalvm, graaljs, graaljs2, scalaTest % Test)
  )