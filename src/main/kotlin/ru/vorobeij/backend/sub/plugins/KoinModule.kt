package ru.vorobeij.backend.sub.plugins

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.vorobeij.backend.sub.routing.topic.TopicController
import ru.vorobeij.backend.sub.routing.topic.TopicService
import ru.vorobeij.backend.sub.routing.video.recommendations.VideoRecommendationsController
import ru.vorobeij.backend.sub.routing.video.recommendations.VideoRecommendationsService
import ru.vorobeij.backend.sub.routing.video.search.VideoSearchController
import ru.vorobeij.backend.sub.routing.video.search.VideoSearchService

val koinModule = module {
    factoryOf(::TopicService)
    factoryOf(::TopicController)
    factoryOf(::VideoSearchService)
    factoryOf(::VideoSearchController)
    factoryOf(::VideoRecommendationsService)
    factoryOf(::VideoRecommendationsController)
}
