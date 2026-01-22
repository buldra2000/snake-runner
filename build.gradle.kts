plugins {
    java
    application
}

repositories {
    mavenCentral()
}

application {
    val main: String? by project
    mainClass.set(main ?: "snakerunner.core.Main")
}