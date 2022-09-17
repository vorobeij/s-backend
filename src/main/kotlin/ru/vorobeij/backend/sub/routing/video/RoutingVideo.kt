package ru.vorobeij.backend.sub.routing.video

import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import ru.vorobeij.backend.sub.routing.video.recommendations.VideoRecommendationsController
import ru.vorobeij.backend.sub.routing.video.search.VideoSearchController

internal const val KEY_PAGE = "page"
internal const val KEY_USER_ID = "userId"
internal const val KEY_LANGUAGE = "language"
internal const val KEY_VIDEO_ID = "videoId"

fun Routing.video(
    videoSearchController: VideoSearchController,
    videoRecommendationsController: VideoRecommendationsController
) {
    route("/video") {
        post("/search") { videoSearchController.search(context) }
        get("/recommendations/{$KEY_USER_ID}") { videoRecommendationsController.getRecommendations(context) }
        get("/watched/{$KEY_USER_ID}") { videoRecommendationsController.getWatched(context) }
        post("/add") { TODO("Not implemented") }
        post("/save") { TODO("Not implemented") }
        post("/subtitles/{$KEY_VIDEO_ID}") { TODO("Not implemented") }
        post("/report") { TODO("Not implemented") }
        route("/admin") {
            post("/ban/{$KEY_VIDEO_ID}") { TODO("Not implemented") }
            get("/list/{$KEY_LANGUAGE}") { TODO("Not implemented") }
            post("/approve/{$KEY_VIDEO_ID}") { TODO("Not implemented") }
        }
    }
}
