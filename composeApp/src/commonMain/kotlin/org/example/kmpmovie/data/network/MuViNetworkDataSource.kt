package org.example.kmpmovie.data.network

interface MuViNetworkDataSource {
    suspend fun getSearchResults(query: String, page: Int): List<NetworkMovieSearchResult>
}