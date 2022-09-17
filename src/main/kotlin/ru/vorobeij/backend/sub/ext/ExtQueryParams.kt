package ru.vorobeij.backend.sub.ext

import io.ktor.server.application.ApplicationCall
import ru.vorobeij.backend.sub.routing.video.KEY_PAGE

fun ApplicationCall.page() = request.queryParameters[KEY_PAGE].toIntOr(0)
