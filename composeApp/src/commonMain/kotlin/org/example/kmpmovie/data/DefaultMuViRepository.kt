package org.example.kmpmovie.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import org.example.kmpmovie.data.network.MuViNetworkDataSource
import org.example.kmpmovie.data.network.asExternalModel

class DefaultMuViRepository(
    private val networkDataSource: MuViNetworkDataSource,
    private val ioDispatcher: CoroutineDispatcher,
) : MuViRepository {
    override suspend fun getSearchResults(query: String) = flow {
        networkDataSource.getSearchResults(query, 1)
            .map { result -> result.asExternalModel() }
            .let { results -> emit(results) }
    }
}
