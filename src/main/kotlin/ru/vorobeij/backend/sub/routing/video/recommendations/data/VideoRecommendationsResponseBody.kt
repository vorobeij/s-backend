package ru.vorobeij.backend.sub.routing.video.recommendations.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.vorobeij.backend.sub.routing.video.data.YouTubeVideoDto

/**
 * @property videos
 * @property page
 */
@Serializable
data class VideoRecommendationsResponseBody(
    @SerialName("videos") val videos: List<YouTubeVideoDto>,
    @SerialName("page") val page: Int
)
