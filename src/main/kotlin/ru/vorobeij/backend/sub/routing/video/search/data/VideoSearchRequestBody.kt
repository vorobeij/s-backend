package ru.vorobeij.backend.sub.routing.video.search.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property query
 * @property filters
 * @property page
 */
@Serializable
data class VideoSearchRequestBody(
    @SerialName("query") val query: String = "",
    @SerialName("filters") val filters: Filters = Filters(),
    @SerialName("page") val page: Int = 0
) {

    /**
     * @property difficulty if not specified, show all levels
     */
    @Serializable
    data class Filters(
        @SerialName("difficulty") val difficulty: List<Int> = (1..5).toList()
    )
}
