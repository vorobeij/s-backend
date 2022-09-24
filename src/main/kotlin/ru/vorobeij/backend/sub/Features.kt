package ru.vorobeij.backend.sub

import ru.vorobeij.backend.sub.database.DatabaseFeature
import ru.vorobeij.backend.sub.logging.LoggingFeature
import ru.vorobeij.backend.sub.plugins.Feature
import ru.vorobeij.backend.sub.plugins.RoutingTopicFeature
import ru.vorobeij.backend.sub.plugins.SerializationFeature
import ru.vorobeij.backend.sub.routing.video.RoutingVideoFeature

val features: List<Feature> = listOf(
    DatabaseFeature(),
    LoggingFeature(),
    SerializationFeature(),
    RoutingTopicFeature(),
    RoutingVideoFeature()
)
