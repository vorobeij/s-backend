package ru.vorobeij.backend.sub

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
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