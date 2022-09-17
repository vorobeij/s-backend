package ru.vorobeij.backend.sub.plugins

import io.ktor.server.application.Application
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.routing.topic.TopicController
import ru.vorobeij.backend.sub.routing.topic.topic
import ru.vorobeij.backend.sub.routing.video.VideoController
import ru.vorobeij.backend.sub.routing.video.video

fun Application.configureRouting() {

    val topicController: TopicController by inject()
    val videoController: VideoController by inject()

    routing {
        topic(topicController)
        video(videoController)
    }
}
