name := """demo-project"""

version := "0.1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  filters,
  // Automatically translate plain English stories to BDD test cases
  "org.scalatest" % "scalatest_2.11" % "2.2.0",
  "org.specs2" % "specs2_2.11" % "3.3.1",
  "com.typesafe.play" % "play-specs2_2.11" % "2.4.2",
  // "org.scalatestplus" % "play_2.11" % "1.4.0-M3",
  "info.cukes" % "cucumber-scala_2.11" % "1.2.2",

  // AWS KCL and KPL
  // "com.amazonaws" % "amazon-kinesis-producer" % "0.9.0",
  "com.amazonaws" % "amazon-kinesis-client" % "1.4.0",
  // Gilt Gfc Kinesis
  "com.gilt" % "gfc-kinesis_2.11" % "0.0.10",

  // msgpack
  "org.msgpack" %% "msgpack-scala" % "0.6.11",
  // snappy
  "org.xerial.snappy" % "snappy-java" % "1.1.1.3",

  // swagger
  // "org.slf4j" % "slf4j-api" % "1.6.4",
  // "com.wordnik" %% "swagger-jaxrs" % "1.3.12",
  // "javax.ws.rs" % "jsr311-api" % "1.1.1",
  // "org.mockito" % "mockito-core" % "1.9.5" % "test"
  "pl.matisoft" %% "swagger-play24" % "1.4"
)

resolvers += "Sonatype-Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += Resolver.file("Local repo", file("./lib/.ivy2/local"))(Resolver.ivyStylePatterns)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
// routesGenerator := InjectedRoutesGenerator

// Play2-cucumber integration
cucumberSettings

cucumberFeaturesLocation := "./test/BDD/features"

cucumberStepsBasePackage := "features.steps"
