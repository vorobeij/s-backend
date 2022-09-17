package ru.vorobeij.backend.sub.routing.video

import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.testApplication
import kotlin.test.assertEquals
import org.junit.Test
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchRequestBody
import ru.vorobeij.backend.sub.routing.video.search.data.VideoSearchResponseBody

internal class RoutingVideoTest {

    @Test
    fun search() = testApplication {
        val client = createClient {
            this.install(ContentNegotiation) {
                json()
            }
        }
        client
            .get("/video/search") {
                contentType(ContentType.Application.Json)
                setBody(VideoSearchRequestBody())
            }
            .apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals(VideoSearchResponseBody(emptyList(), 0), body())
            }
    }
}
