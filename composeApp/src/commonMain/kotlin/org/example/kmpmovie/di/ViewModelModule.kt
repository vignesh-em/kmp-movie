package org.example.kmpmovie.di

import org.example.kmpmovie.search.SearchResultsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchResultsViewModel(get()) }
}