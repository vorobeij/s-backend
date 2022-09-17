package ru.vorobeij.backend.sub.routing.video.search

import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchRequestBody

class VideoSearchController(
    private val videoSearchService: VideoSearchService
) {

    suspend fun search(call: ApplicationCall) {
        val body: VideoSearchRequestBody = call.receive()
        call.respond(videoSearchService.search(body))
    }
}
