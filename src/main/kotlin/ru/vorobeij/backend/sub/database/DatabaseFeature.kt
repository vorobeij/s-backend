package ru.vorobeij.backend.sub.database

import io.ktor.server.application.Application
import io.ktor.server.application.log
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.ext.inject
import ru.vorobeij.backend.sub.plugins.Feature

class DatabaseFeature : Feature {

    override val module: Module = module {
        singleOf(::DatabaseProvider)
    }

    override fun Application.install() {
        val jdbcUrl = environment.config.property("storage.jdbcURL").getString()
        val driverClassName = environment.config.property("storage.driverClassName").getString()
        val username = environment.config.property("storage.POSTGRES_USER").getString()
        val password = environment.config.property("storage.POSTGRES_PASSWORD").getString()
        log.info("jdbcUrl = $jdbcUrl")
        log.info("driverClassName = $driverClassName")
        log.info("username = $username")
        log.info("password = $password")

        val dbProvider: DatabaseProvider by inject()
        dbProvider.init(environment.config)
    }
}
