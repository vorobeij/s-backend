package ru.vorobeij.backend.sub.plugins

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json

class SerializationFeature : Feature {

    override val module = null

    override fun Application.install() {
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
            })
        }
    }
}
