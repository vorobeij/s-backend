pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}

plugins {
    id("de.fayard.refreshVersions").version("0.50.1")
}

refreshVersions {
    rejectVersionIf {
        val unstableRegex = Regex("(alpha|beta|rc)\\d*", RegexOption.IGNORE_CASE)
        candidate.value.contains(unstableRegex)
    }
}
rootProject.name = "s-backend"
