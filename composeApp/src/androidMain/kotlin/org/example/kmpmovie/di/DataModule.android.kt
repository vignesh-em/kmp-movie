package org.example.kmpmovie.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.endpoint
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

actual val httpClientModule = module {
    single {
        HttpClient(CIO) {
            engine {
                maxConnectionsCount = 1000

                endpoint {
                    maxConnectionsPerRoute = 100
                    pipelineMaxSize = 20
                    keepAliveTime = 5000
                    connectTimeout = 5000
                    connectAttempts = 5
                }
            }

            install(ContentNegotiation) {
                json(json)
            }
        }
    }
}