package ru.vorobeij.backend.sub.routing.video.data

import kotlinx.serialization.Serializable

/**
 * @property query
 */
@Serializable
data class SearchRequestBody(
    val query: String
)
