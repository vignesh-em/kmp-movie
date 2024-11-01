package org.example.kmpmovie.data.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol

class KtorOmdbService(private val httpClient: HttpClient) : MuViNetworkDataSource {
    override suspend fun getSearchResults(
        query: String,
        page: Int
    ) = httpClient.get {
        url {
            protocol = URLProtocol.HTTPS
            host = "www.omdbapi.com"
            parameters.append("apikey", "b7e0dbb4")
            parameters.append("s", query)
            parameters.append("page", page.toString())
        }
    }
        .body<SearchResponse<NetworkMovieSearchResult>>()
        .results
}