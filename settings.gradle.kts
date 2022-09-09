pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
    plugins {
        kotlin("jvm") version "1.7.10"
        id("io.ktor.plugin") version "2.1.1"
        id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
    }
}

plugins {
    id("de.fayard.refreshVersions").version("0.40.2")
}

refreshVersions {
    rejectVersionIf {
        val unstableRegex = Regex("(alpha|beta|rc)\\d*", RegexOption.IGNORE_CASE)
        candidate.value.contains(unstableRegex)
    }
}
rootProject.name = "s-backend"
include(
    "app"
)
