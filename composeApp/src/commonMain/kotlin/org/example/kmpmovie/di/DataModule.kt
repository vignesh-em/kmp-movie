package org.example.kmpmovie.di

import org.example.kmpmovie.data.DefaultMuViRepository
import org.example.kmpmovie.data.MuViRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<MuViRepository> { DefaultMuViRepository(get(named("io"))) }
}