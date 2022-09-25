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
        // "kotlinTestRule",
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
}

ktor {
    fatJar {
        archiveFileName.set("app-fat.jar")
    }

    // https://ktor.io/docs/docker.html#build-run
    docker {
        jreVersion.set(io.ktor.plugin.features.JreVersion.JRE_17)
        localImageName.set("s-backend-docker-image")
        imageTag.set("0.0.1")
        portMappings.set(
            listOf(
                io.ktor.plugin.features.DockerPortMapping(
                    80,
                    8080,
                    io.ktor.plugin.features.DockerPortMappingProtocol.TCP
                )
            )
        )
        // externalRegistry.set(
        //     io.ktor.plugin.features.DockerImageRegistry.dockerHub(
        //         appName = provider { "ktor-app" },
        //         username = providers.environmentVariable("DOCKER_HUB_USERNAME"),
        //         password = providers.environmentVariable("DOCKER_HUB_PASSWORD")
        //     )
        // )
    }
}

dependencies {
    implementation("ch.qos.logback:logback-classic:_")
    implementation("com.zaxxer:HikariCP:_")
    implementation("io.ktor:ktor-server-call-logging:_")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:_")
    implementation("io.ktor:ktor-server-core-jvm:_")
    implementation("io.ktor:ktor-server-netty-jvm:_")
    implementation("mysql:mysql-connector-java:_")
    implementation("org.postgresql:postgresql:_")
    implementation("org.slf4j:slf4j-nop:_")
    implementation(JetBrains.exposed.core)
    implementation(JetBrains.exposed.dao)
    implementation(JetBrains.exposed.jdbc)
    implementation(Koin.ktor)
    implementation(Koin.slf4j)
    implementation(KotlinX.serialization.json)
    implementation(Ktor.plugins.http)
    implementation(Ktor.plugins.serialization)
    implementation(Ktor.plugins.serialization.kotlinx.json)
    implementation(Ktor.server.hostCommon)
    implementation(Ktor.utils)
    testImplementation("io.ktor:ktor-server-tests-jvm:_")
    testImplementation(Koin.junit4)
    testImplementation(Koin.test)
    testImplementation(Kotlin.test.junit)
    testImplementation(Ktor.client.contentNegotiation)
    testImplementation(Ktor.server.testHost)
    testImplementation(Testing.mockK)
}

apply(from = "$rootDir/jacoco.gradle")