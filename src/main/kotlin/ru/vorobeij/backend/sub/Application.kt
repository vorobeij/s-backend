package ru.vorobeij.backend.sub

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

@Suppress("unused")  // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    install(Koin) {
        slf4jLogger()
        modules(features.mapNotNull { it.module })
    }

    features.forEach {
        with(it) { install() }
    }
}

fun main(args: Array<String>): Unit = EngineMain.main(args)
