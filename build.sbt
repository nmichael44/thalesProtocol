import smithy4s.codegen.Smithy4sCodegenPlugin

val scalaVer = "3.7.4"

val catsVersion = "2.13.0"

val log4catsSlf4jVersion = "2.7.1"
val alloyCoreVersion = "0.3.36"

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
