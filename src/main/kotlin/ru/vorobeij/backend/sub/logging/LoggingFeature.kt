package ru.vorobeij.backend.sub.logging

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.callloging.CallLogging
import io.ktor.server.plugins.origin
import io.ktor.server.request.httpMethod
import org.slf4j.event.Level
import ru.vorobeij.backend.sub.plugins.Feature

class LoggingFeature : Feature {

    override val module = null

    override fun Application.install() {
        install(CallLogging) {
            level = Level.INFO
            format { call ->
                val status = call.response.status()
                val httpMethod = call.request.httpMethod.value
                val path = call.request.origin.uri
                "$httpMethod $path $status"
            }
        }
    }
}
