package org.example.kmpmovie.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(dataModule + coroutineModule + viewModelModule)
    }
}