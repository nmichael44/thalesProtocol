import smithy4s.codegen.Smithy4sCodegenPlugin

val scalaVer = "3.8.3"

val catsVersion = "2.13.0"

val alloyCoreVersion = "0.3.38"

ThisBuild / organization := "com.neo"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scalaVer

lazy val root = project
  .in(file("."))
  .enablePlugins(Smithy4sCodegenPlugin)
  .settings(
    name := "thalesProtocol",
    exportJars := true,
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % catsVersion,
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s" % smithy4sVersion.value,
      "com.disneystreaming.alloy" % "alloy-core" % alloyCoreVersion,
    )
  )

addCommandAlias("fmt", "scalafmtAll")
addCommandAlias("z", "Test/compile")
addCommandAlias("pl", "publishLocal")
