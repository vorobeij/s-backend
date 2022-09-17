package ru.vorobeij.backend.sub.plugins

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.vorobeij.backend.sub.routing.topic.TopicController
import ru.vorobeij.backend.sub.routing.topic.TopicService
import ru.vorobeij.backend.sub.routing.video.VideoController
import ru.vorobeij.backend.sub.routing.video.VideoService

val koinModule = module {
    factoryOf(::TopicService)
    factoryOf(::TopicController)
    factoryOf(::VideoService)
    factoryOf(::VideoController)
}
