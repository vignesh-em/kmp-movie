package org.example.kmpmovie.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual val httpClientModule = module {
    single {
        HttpClient(Js) {
            engine {
                dispatcher = Dispatchers.Default
            }

            install(ContentNegotiation) {
                json(json)
            }
        }
    }
}