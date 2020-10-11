name := "scala-language-tester"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scalatest" % "scalatest_2.13" % "3.1.2" % "test"
)
