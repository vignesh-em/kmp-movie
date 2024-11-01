package org.example.kmpmovie.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultMuViRepository(
    private val ioDispatcher: CoroutineDispatcher,
) : MuViRepository {
    override suspend fun getSearchResults(query: String): Flow<List<MovieSearchResult>> {
        return flow { emit(emptyList()) }
    }
}
