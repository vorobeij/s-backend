package ru.vorobeij.backend.sub.routing.video

import io.ktor.server.application.Application
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.plugins.Feature
import ru.vorobeij.backend.sub.routing.video.recommendations.VideoRecommendationsController
import ru.vorobeij.backend.sub.routing.video.recommendations.VideoRecommendationsService
import ru.vorobeij.backend.sub.routing.video.search.VideoSearchController
import ru.vorobeij.backend.sub.routing.video.search.VideoSearchService

class RoutingVideoFeature : Feature {

    override val module: Module = module {
        factoryOf(::VideoSearchService)
        factoryOf(::VideoSearchController)
        factoryOf(::VideoRecommendationsService)
        factoryOf(::VideoRecommendationsController)
    }

    override fun Application.install() {
        val videoSearchController: VideoSearchController by inject()
        val videoRecommendationsController: VideoRecommendationsController by inject()

        routing {
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
    }
}
