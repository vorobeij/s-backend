package ru.vorobeij.backend.sub.routing.video

import ru.vorobeij.backend.sub.routing.video.data.SearchRequestBody
import ru.vorobeij.backend.sub.routing.video.data.SearchResponseBody

class VideoService {

    suspend fun search(body: SearchRequestBody): SearchResponseBody = SearchResponseBody(body.query)
}
