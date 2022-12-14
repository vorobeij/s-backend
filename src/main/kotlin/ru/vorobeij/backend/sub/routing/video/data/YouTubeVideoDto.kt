package ru.vorobeij.backend.sub.routing.video.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id
 * @property title
 * @property description
 * @property channelTitle
 * @property subsUriString
 * @property previewUrl
 * @property channelId
 * @property sourceLang
 * @property durationMs
 * @property openedAtTs
 * @property publishedAtTs
 * @property difficulty
 * @property autogeneratedSubtitles
 * @property banned
 * @property reportedTimes
 * @property requiresModeration
 * @property seekPositionPercent
 */
@Serializable
data class YouTubeVideoDto(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("channelTitle") val channelTitle: String,
    @SerialName("subsUriString") val subsUriString: String,
    @SerialName("previewUrl") val previewUrl: String,
    @SerialName("channelId") val channelId: String,
    @SerialName("sourceLang") val sourceLang: String,
    @SerialName("durationMs") val durationMs: Long,
    @SerialName("openedAtTs") val openedAtTs: Long,
    @SerialName("publishedAtTs") val publishedAtTs: Long,
    @SerialName("difficulty") val difficulty: Int,
    @SerialName("autogeneratedSubtitles") val autogeneratedSubtitles: Boolean,
    @SerialName("banned") val banned: Boolean,
    @SerialName("reportedTimes") val reportedTimes: Long,
    @SerialName("requiresModeration") val requiresModeration: Boolean,
    @SerialName("seekPositionPercent") val seekPositionPercent: Float = 0.0f
)
