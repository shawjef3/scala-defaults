organization := "me.jeffshaw.default"

name := "scala-defaults"

version := "0.1"

scalaVersion := "2.12.6"

crossScalaVersions := Seq(
  "2.11.12",
  "2.10.6"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

publishMavenStyle := true

licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(GitHubHosting("shawjef3", "scala-defaults", "shawjef3@gmail.com"))

developers := List(
  Developer(id="shawjef3", name="Jeff Shaw", email="shawjef3@gmail.com", url=url("https://www.jeffshaw.me/"))
)
