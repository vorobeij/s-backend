package ru.vorobeij.backend.sub.routing.video.search.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property query
 * @property filters
 * @property page
 */
@Serializable
data class VideoSearchRequest(
    @SerialName("query") val query: String = "",
    @SerialName("filters") val filters: Filters,
    @SerialName("page") val page: Int = 0
) {

    /**
     * @property difficulty if not specified, show all levels
     * @property language
     */
    @Serializable
    data class Filters(
        @SerialName("difficulty") val difficulty: List<Int> = (1..5).toList(),
        @SerialName("language") val language: String
    )
}
