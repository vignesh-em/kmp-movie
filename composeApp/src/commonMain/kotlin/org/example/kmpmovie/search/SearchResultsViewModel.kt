package org.example.kmpmovie.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.example.kmpmovie.data.MovieSearchResult
import org.example.kmpmovie.data.MuViRepository

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class SearchResultsViewModel(private val repository: MuViRepository) : ViewModel() {
    private val _searchQuery = MutableStateFlow<String?>(null)
    val searchQuery: StateFlow<String?> = _searchQuery

    val searchResultFlow = _searchQuery
        .debounce(700)
        .flatMapLatest { query ->
            if (query.isNullOrBlank()) {
                flow { emit(emptyList<MovieSearchResult>()) }
            } else {
                repository.getSearchResults(query)
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList<MovieSearchResult>())

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun clearSearchResults() {
        _searchQuery.value = null
    }
}