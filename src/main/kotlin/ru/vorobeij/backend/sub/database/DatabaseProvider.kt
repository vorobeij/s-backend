package ru.vorobeij.backend.sub.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.ApplicationConfig
import org.jetbrains.exposed.sql.Database

class DatabaseProvider {

    private val db: Database by lazy {
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = config.property("storage.jdbcURL").getString()
            driverClassName = config.property("storage.driverClassName").getString()
            username = config.property("storage.POSTGRES_USER").getString()
            password = config.property("storage.POSTGRES_PASSWORD").getString()

            maximumPoolSize = 10
        }
        val dataSource = HikariDataSource(hikariConfig)
        Database.connect(dataSource)
    }
    val database: Database get() = db

    private lateinit var config: ApplicationConfig

    fun init(config: ApplicationConfig) {
        this.config = config
    }
}
