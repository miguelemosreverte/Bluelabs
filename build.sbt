lazy val root = (project in file("."))
  .settings(
    name := "EEG",
    Compile / mainClass := Some("application.Main"),
    assembly / mainClass := Some("application.Main"),
    assembly / assemblyJarName := "example.jar"
  )
  .aggregate(application)

lazy val domain = project
lazy val infrastructure = project
lazy val application = project.dependsOn(domain, infrastructure)
