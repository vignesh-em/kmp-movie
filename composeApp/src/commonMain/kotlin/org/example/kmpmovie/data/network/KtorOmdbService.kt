package org.example.kmpmovie.data.network

class KtorOmdbService : MuViNetworkDataSource {
    override suspend fun getSearchResults(
        query: String,
        page: Int
    ): List<NetworkMovieSearchResult> {
        return emptyList()
    }
}