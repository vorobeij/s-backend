package ru.vorobeij.backend.sub

import io.ktor.server.application.*
import io.ktor.server.netty.*
import ru.vorobeij.backend.sub.plugins.configureRouting
import ru.vorobeij.backend.sub.plugins.configureSerialization

@Suppress("unused")  // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureRouting()
}

fun main(args: Array<String>): Unit = EngineMain.main(args)
