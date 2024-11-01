package org.example.kmpmovie.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val coroutineModule = module {
    single<CoroutineDispatcher>(named("io")) { Dispatchers.Default }
}