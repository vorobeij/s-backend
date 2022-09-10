plugins {
    application
    kotlin("jvm")
    id("io.ktor.plugin")
    id("org.jetbrains.kotlin.plugin.serialization")
}

group = "ru.vorobeij.backend.sub"
version = "0.0.1"

application {
    mainClass.set("ru.vorobeij.backend.sub.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

ktor {
    fatJar {
        archiveFileName.set("app-fat.jar")
    }
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm:_")
    implementation("io.ktor:ktor-server-core-jvm:_")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:_")
    implementation("io.ktor:ktor-server-netty-jvm:_")
    implementation(Ktor.http)
    implementation(Ktor.features.serialization)
    implementation("io.ktor:ktor-server-host-common:_")
    implementation(Ktor.utils)
    implementation(KotlinX.serialization.json)

    testImplementation("io.ktor:ktor-server-tests-jvm:_")
    testImplementation(Kotlin.test.junit)
}

apply(from = "$rootDir/jacoco.gradle")

// https://github.com/autonomousapps/dependency-analysis-android-gradle-plugin/wiki/Customizing-plugin-behavior
// todo move out
dependencyAnalysis {
    issues {
        ignoreKtx(true)
        onAny {
            severity("fail")
            exclude(
                "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
            )
        }
    }
}