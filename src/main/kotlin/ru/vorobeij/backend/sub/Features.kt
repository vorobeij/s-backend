package ru.vorobeij.backend.sub

import ru.vorobeij.backend.sub.plugins.Feature
import ru.vorobeij.backend.sub.plugins.RoutingTopicFeature
import ru.vorobeij.backend.sub.plugins.SerializationFeature
import ru.vorobeij.backend.sub.routing.video.RoutingVideoFeature

val features: List<Feature> = listOf(
    SerializationFeature(),
    RoutingTopicFeature(),
    RoutingVideoFeature()
)
