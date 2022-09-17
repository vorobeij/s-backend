package ru.vorobeij.backend.sub.routing.topic

import ru.vorobeij.backend.sub.routing.topic.data.TopicResponseBody

class TopicService {

    suspend fun edit(): TopicResponseBody = TopicResponseBody("test topics service")
}
