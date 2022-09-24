package ru.vorobeij.backend.sub.routing.db.utils

import io.ktor.server.testing.ApplicationTestBuilder
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.database.DatabaseProvider

fun ApplicationTestBuilder.setupDatabase(block: Transaction.() -> Unit) {
    application {
        val dbProvider: DatabaseProvider by inject()
        transaction(db = dbProvider.database) {
            block.invoke(this)
        }
    }
}
