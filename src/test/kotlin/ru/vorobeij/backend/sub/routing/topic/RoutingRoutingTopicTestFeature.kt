package ru.vorobeij.backend.sub.routing.topic

import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.assertEquals
import org.junit.Test
import org.koin.test.AutoCloseKoinTest

internal class RoutingRoutingTopicTestFeature : AutoCloseKoinTest() {

    @Test
    fun `topic edit`() = testApplication {
        client
            .post("/topic/edit")
            .apply {
                assertEquals(HttpStatusCode.OK, status)
                assertEquals("""{"data":"test topics service"}""", bodyAsText())
            }
    }
}
