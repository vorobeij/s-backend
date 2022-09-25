package ru.vorobeij.backend.sub.routing.db.utils

import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.database.DatabaseProvider

fun Application.setupDatabase(block: Transaction.() -> Unit) {
    val dbProvider: DatabaseProvider by inject()
    transaction(db = dbProvider.database) {
        block.invoke(this)
    }
}
