package ru.vorobeij.backend.sub

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import ru.vorobeij.backend.sub.plugins.configureRouting
import ru.vorobeij.backend.sub.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
