package org.example.kmpmovie.data

import kotlinx.coroutines.flow.Flow

interface MuViRepository {
    suspend fun getSearchResults(query: String): Flow<List<MovieSearchResult>>
}
