package ru.vorobeij.backend.sub.routing.topic.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property data
 */
@Serializable
data class TopicResponseBody(
    @SerialName("data") val data: String
)
