package ru.vorobeij.backend.sub.routing.db.utils.schema

import org.jetbrains.exposed.sql.Transaction
import ru.vorobeij.backend.sub.database.tables.YouTubeVideos

// todo move schema to the main code?

internal fun Transaction.recreateYouTubeVideos() {
    exec(YouTubeVideos.dropStatement().joinToString(" "))
    exec(YouTubeVideos.createStatement().joinToString(" "))
}
