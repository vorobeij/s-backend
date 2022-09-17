package ru.vorobeij.backend.sub.routing.topic

import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

class TopicController(
    private val topicService: TopicService
) {

    suspend fun edit(call: ApplicationCall) {
        call.respond(topicService.edit())
    }
}
