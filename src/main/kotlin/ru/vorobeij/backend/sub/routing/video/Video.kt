package ru.vorobeij.backend.sub.routing.video

import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Routing.video(
    controller: VideoController
) {
    route("/video") {
        get("/search") { controller.search(context) }
    }
}
