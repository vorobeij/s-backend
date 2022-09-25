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
import ru.vorobeij.backend.sub.database.tables.YouTubeVideos
import ru.vorobeij.backend.sub.routing.db.utils.schema.insert
import ru.vorobeij.backend.sub.routing.db.utils.schema.recreateYouTubeVideos
import ru.vorobeij.backend.sub.routing.db.utils.setupDatabase
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchRequest
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchResponseBody

class RoutingVideoSearchIntegrationTest : AutoCloseKoinTest() {

    @Test
    fun `empty string search should return all videos from DB`() = testApplication {
        application {
            setupDatabase {
                recreateYouTubeVideos()
                YouTubeVideos.insert(title = "video 1", language = "en")
                YouTubeVideos.insert(title = "video 2", language = "es")
                YouTubeVideos.insert(title = "video 3", language = "ru")
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
                setBody(VideoSearchRequest(filters = VideoSearchRequest.Filters(language = "en")))
            }
            .apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals(1, body<VideoSearchResponseBody>().videos.size)
            }
    }
}
