package ru.vorobeij.backend.sub.plugins

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.routing.topic.TopicController
import ru.vorobeij.backend.sub.routing.topic.topic
import ru.vorobeij.backend.sub.routing.video.recommendations.VideoRecommendationsController
import ru.vorobeij.backend.sub.routing.video.search.VideoSearchController
import ru.vorobeij.backend.sub.routing.video.video

fun Application.configureRouting() {

    val topicController: TopicController by inject()
    val videoSearchController: VideoSearchController by inject()
    val videoRecommendationsController: VideoRecommendationsController by inject()

    routing {
        topic(topicController)
        video(videoSearchController, videoRecommendationsController)
    }
}
