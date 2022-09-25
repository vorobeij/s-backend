package ru.vorobeij.backend.sub.database.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Sentences : Table() {

    val text: Column<String> = varchar("text", 300)
    override val primaryKey = PrimaryKey(text)
    val timestamp: Column<Long> = long("timestamp")
    val sourceLanguage: Column<String> = varchar("sourceLanguage", 300)
    val videoUriString: Column<String> = varchar("videoUriString", 300)
    val timeStartSeconds: Column<Long> = long("timeStartSeconds")
    val timeEndSeconds: Column<Long> = long("timeEndSeconds")
    val audioUriString: Column<String> = varchar("audioUriString", 300)
    val canExtractAudio: Column<Long> = long("canExtractAudio")
    val translation: Column<String> = varchar("translation", 300)
}

object Words : Table() {

    val text: Column<String> = varchar("text", 300)
    override val primaryKey = PrimaryKey(text)
    val timestamp: Column<Long> = long("timestamp")
    val sourceLanguage: Column<String> = varchar("sourceLanguage", 300)
    val translation: Column<String> = varchar("translation", 300)
    val repeated: Column<Long> = long("repeated")
    val repeatedTotalTimes: Column<Long> = long("repeatedTotalTimes")
    val timeToRepeat: Column<Long> = long("timeToRepeat")
    val repeatStage: Column<Long> = long("repeatStage")
    val videoId: Column<String> = varchar("videoId", 300)
}

object SearchHistory : Table() {

    val query: Column<String> = varchar("query", 300)
    override val primaryKey = PrimaryKey(query)
    val timestamp: Column<Long> = long("timestamp")
}

object YouTubeVideos : Table(name = "youtubevideos") {

    val id: Column<String> = varchar("id", 20).uniqueIndex()
    override val primaryKey = PrimaryKey(id)
    val title: Column<String> = varchar("title", 300)
    val description: Column<String> = varchar("description", 300)
    val channelTitle: Column<String> = varchar("channeltitle", 300)
    val subsUriString: Column<String> = varchar("subsuristring", 300)
    val previewUrl: Column<String> = varchar("previewurl", 300)
    val channelId: Column<String> = varchar("channelid", 300)
    val sourceLang: Column<String> = varchar("sourcelang", 300)
    val durationMs: Column<Long> = long("durationms")
    val openedAtTs: Column<Long> = long("openedatts")
    val publishedAtTs: Column<Long> = long("publishedatts")
    val difficulty: Column<Int> = integer("difficulty")
    val autogeneratedSubtitles: Column<Boolean> = bool("autogeneratedsubtitles")
    val banned: Column<Boolean> = bool("banned")
    val requiresModeration: Column<Boolean> = bool("requiresmoderation")
    val language: Column<String> = varchar("language", 10)
}

object VideoMeta : Table() {

    val videoId: Column<String> = varchar("videoId", 300)
    override val primaryKey = PrimaryKey(videoId)
}

object Subtitles : Table() {

    val videoId: Column<String> = varchar("videoId", 300)
    override val primaryKey = PrimaryKey(videoId)
    val subtitles: Column<String> = varchar("subtitles", 300)
}

object Topics : Table() {

    val name: Column<String> = varchar("name", 300)
    override val primaryKey = PrimaryKey(name)
}

object VideoTopic : Table() {

    val id: Column<Long> = long("id")
    override val primaryKey = PrimaryKey(id)
    val videoId: Column<String> = varchar("videoId", 300)
    val topicId: Column<String> = varchar("topicId", 300)
}

object TopicTranslation : Table() {

    val id: Column<Long> = long("id")
    override val primaryKey = PrimaryKey(id)
    val topicId: Column<String> = varchar("topicId", 300)
    val language: Column<String> = varchar("language", 300)
    val name: Column<String> = varchar("name", 300)
}

object UserSettings : Table() {

    val userId: Column<String> = varchar("userId", 300)
    override val primaryKey = PrimaryKey(userId)
    val lanOrig: Column<Long> = long("lanOrig")
    val lanTran: Column<Long> = long("lanTran")
}

object UserTopics : Table() {

    val id: Column<Long> = long("id").autoIncrement()
    override val primaryKey = PrimaryKey(id)
    val userId: Column<String> = varchar("userId", 300)
    val topicId: Column<String> = varchar("topicId", 300)
}

object User : Table() {

    val id: Column<String> = varchar("id", 300)
    override val primaryKey = PrimaryKey(id)
    val name: Column<String> = varchar("name", 300)
    val registerTs: Column<Long> = long("registerTs")
}

object UserWatchHistory : Table() {

    val id: Column<Long> = long("id")
    override val primaryKey = PrimaryKey(id)
    val userId: Column<String> = varchar("userId", 300)
    val videoId: Column<String> = varchar("videoId", 300)
    val watchedTs: Column<Long> = long("watchedTs")
    val seekPositionPercent: Column<Long> = long("seekPositionPercent")
    val saved: Column<Boolean> = bool("saved")
}

object RecommendLess : Table() {

    val id: Column<Long> = long("id")
    override val primaryKey = PrimaryKey(id)
    val userId: Column<String> = varchar("userId", 300)
    val videoId: Column<String> = varchar("videoId", 300)
}

object Language : Table() {

    val id: Column<Long> = long("id")
    override val primaryKey = PrimaryKey(id)
    val displayName: Column<String> = varchar("displayName", 300)
    val inSources: Column<Boolean> = bool("inSources")
    val inTranslates: Column<Boolean> = bool("inTranslates")
}

object Playlist : Table() {

    val id: Column<String> = varchar("id", 300)
    override val primaryKey = PrimaryKey(id)
    val imageUrl: Column<String> = varchar("imageUrl", 300)
    val videosCount: Column<Long> = long("videosCount")
    val title: Column<String> = varchar("title", 300)
    val subtitle: Column<String> = varchar("subtitle", 300)
    val language: Column<String> = varchar("language", 300)
    val timestamp: Column<Long> = long("timestamp")
}

object PlaylistVideo : Table() {

    val playlistId: Column<String> = varchar("playlistId", 300)
    override val primaryKey = PrimaryKey(playlistId)
    val videoId: Column<String> = varchar("videoId", 300)
}

object WordUsages : Table() {

    val word: Column<String> = varchar("word", 300)
    override val primaryKey = PrimaryKey(word)
    val sentence: Column<String> = varchar("sentence", 300)
}

object DailyWordsLearned : Table() {

    val date: Column<String> = varchar("date", 300)
    override val primaryKey = PrimaryKey(date)
    val wordsCount: Column<Long> = long("wordsCount")
}