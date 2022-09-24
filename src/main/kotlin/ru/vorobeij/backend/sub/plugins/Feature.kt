package ru.vorobeij.backend.sub.plugins

import io.ktor.server.application.Application
import org.koin.core.module.Module

interface Feature {
    // todo add dependencies list
    val module: Module?
    fun Application.install()
}
