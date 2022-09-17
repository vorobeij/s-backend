package ru.vorobeij.backend.sub.routing.video.data

import kotlinx.serialization.Serializable

/**
 * @property data
 */
@Serializable
data class SearchResponseBody(
    val data: String
)
