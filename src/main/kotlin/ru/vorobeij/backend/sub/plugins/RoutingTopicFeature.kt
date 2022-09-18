package ru.vorobeij.backend.sub.plugins

import io.ktor.server.application.Application
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.routing.topic.TopicController
import ru.vorobeij.backend.sub.routing.topic.TopicService

class RoutingTopicFeature : Feature {

    override val module = module(createdAtStart = false) {
        factoryOf(::TopicService)
        factoryOf(::TopicController)
    }

    override fun Application.install() {
        val topicController: TopicController by inject()
        routing {
            route("/topic") {
                post("/edit") { topicController.edit(context) }
            }
        }
    }
}
