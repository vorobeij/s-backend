package ru.vorobeij.backend.sub.routing.video.recommendations

import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond
import ru.vorobeij.backend.sub.ext.page
import ru.vorobeij.backend.sub.routing.video.KEY_USER_ID

// todo rename?
class VideoRecommendationsController(
    private val videoRecommendationsService: VideoRecommendationsService
) {

    suspend fun getRecommendations(call: ApplicationCall) {
        val userId: String = call.userId()
        val page: Int = call.page()
        call.respond(videoRecommendationsService.getRecommendations(userId, page))
    }

    suspend fun getWatched(call: ApplicationCall) {
        val userId: String = call.userId()
        val page = call.page()
        call.respond(videoRecommendationsService.getWatchedHistory(userId, page))
    }

    private fun ApplicationCall.userId() = parameters[KEY_USER_ID] ?: throw IllegalArgumentException("userId must be set")
}
