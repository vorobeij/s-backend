buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
        classpath("com.pinterest:ktlint:_")
        classpath("com.autonomousapps:dependency-analysis-gradle-plugin:_")
        classpath("org.cqfn.diktat:diktat-gradle-plugin:_")
    }
}

apply(plugin = "com.autonomousapps.dependency-analysis")

val javaVersion = JavaVersion.VERSION_14

allprojects {
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_14.toString()
            javaParameters = true
        }
    }
    val implementation by configurations

    dependencies {
        implementation(Kotlin.stdlib.jdk8)
    }

    apply(plugin = "org.cqfn.diktat.diktat-gradle-plugin")
    configure<org.cqfn.diktat.plugin.gradle.DiktatExtension> {
        diktatConfigFile = rootProject.file("diktat-analysis.yml")
        inputs {
            exclude("src/resources/**/*.kt")
            include("src/**/*.kt")
        }
    }
}

apply(from = "./ci/testrules/kotlin-tests-rule.gradle")

tasks.register<GradleBuild>("codeChecks") {
    tasks = listOf(
        "clean",
        // "refreshVersionsMigrate",
        "buildHealth",
        "diktatFix",
        "kotlinTestRule",
        "test"
    )
}

tasks.register<GradleBuild>("buildChecks") {
    tasks = listOf(
        "clean",
        "build"
    )
}

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
    implementation("io.ktor:ktor-serialization-kotlinx-json:_")
    implementation("io.ktor:ktor-server-netty-jvm:_")
    implementation(Ktor.plugins.http)
    implementation(Ktor.plugins.serialization)
    implementation(Ktor.server.hostCommon)
    implementation(Ktor.utils)
    implementation(KotlinX.serialization.json)

    implementation(JetBrains.exposed.core)
    implementation(JetBrains.exposed.dao)
    implementation(JetBrains.exposed.jdbc)
    testImplementation("io.ktor:ktor-server-test-host:_")
    implementation("org.slf4j:slf4j-nop:_")
    implementation(Koin.ktor)
    implementation(Koin.slf4j)
    testImplementation("io.ktor:ktor-client-content-negotiation:_")
    testImplementation("io.ktor:ktor-server-tests-jvm:_")
    testImplementation(Kotlin.test.junit)
    testImplementation(Koin.test)
    testImplementation(Koin.junit4)
    testImplementation(Testing.mockK)
}

apply(from = "$rootDir/jacoco.gradle")