package ru.vorobeij.backend.sub

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals
import ru.vorobeij.backend.sub.plugins.configureRouting

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun `test serialization`() = testApplication {
        application {
            configureRouting()
        }
        client.get("/json/kotlinx-serialization").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("""{"hello":"world"}""", bodyAsText())
        }
    }
}
