
lazy val commonSettings = Seq(
  organization := "com.meetup.lagosscala",
  version := "0.0.1",
  scalaVersion := "2.12.1"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "Data Munging Kata", 
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
