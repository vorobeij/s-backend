package ru.vorobeij.backend.sub.routing.video

import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import ru.vorobeij.backend.sub.routing.video.data.SearchRequestBody

class VideoController(
    private val videoService: VideoService
) {

    suspend fun search(call: ApplicationCall) {
        val body: SearchRequestBody = call.receive()
        call.respond(videoService.search(body))
    }
}
