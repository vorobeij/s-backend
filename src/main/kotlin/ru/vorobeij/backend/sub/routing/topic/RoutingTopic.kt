package ru.vorobeij.backend.sub.routing.topic

import io.ktor.server.routing.Routing
import io.ktor.server.routing.post
import io.ktor.server.routing.route

fun Routing.topic(
    controller: TopicController
) {
    route("/topic") {
        post("/edit") { controller.edit(context) }
    }
}
