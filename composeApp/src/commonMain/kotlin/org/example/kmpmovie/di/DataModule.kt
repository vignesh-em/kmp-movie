package org.example.kmpmovie.di

import kotlinx.serialization.json.Json
import org.example.kmpmovie.data.DefaultMuViRepository
import org.example.kmpmovie.data.MuViRepository
import org.example.kmpmovie.data.network.KtorOmdbService
import org.example.kmpmovie.data.network.MuViNetworkDataSource
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<MuViRepository> { DefaultMuViRepository(get(), get(named("io"))) }
    single<MuViNetworkDataSource> { KtorOmdbService(get()) }
}

expect val httpClientModule: Module

val json = Json {
    ignoreUnknownKeys = true
}