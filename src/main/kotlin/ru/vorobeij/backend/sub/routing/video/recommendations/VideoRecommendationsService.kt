package ru.vorobeij.backend.sub.routing.video.recommendations

import ru.vorobeij.backend.sub.routing.video.recommendations.data.VideoRecommendationsResponseBody
import ru.vorobeij.backend.sub.routing.video.recommendations.data.VideoWatchedResponseBody

class VideoRecommendationsService {

    suspend fun getRecommendations(userId: String, page: Int): VideoRecommendationsResponseBody {
        TODO("Not implemented")
    }

    suspend fun getWatchedHistory(userId: String, page: Int): VideoWatchedResponseBody {
        TODO("Not yet implemented")
    }
}
