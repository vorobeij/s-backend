package ru.vorobeij.backend.sub.routing.video

import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import kotlin.test.assertEquals
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import ru.vorobeij.backend.sub.routing.db.utils.schema.recreateYouTubeVideos
import ru.vorobeij.backend.sub.routing.db.utils.setupDatabase
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchRequest
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchResponseBody

internal class RoutingVideoTest : AutoCloseKoinTest() {

    @Test
    fun search() = testApplication {
        application {
            setupDatabase {
                recreateYouTubeVideos()
            }
        }

        val client = createClient {
            this.install(ContentNegotiation) {
                json()
            }
        }
        client
            .post("/video/search") {
                contentType(ContentType.Application.Json)
                setBody(VideoSearchRequest(filters = VideoSearchRequest.Filters(language = "es")))
            }
            .apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals(VideoSearchResponseBody(emptyList(), 0), body())
            }
    }
}
