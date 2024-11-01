package org.example.kmpmovie.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.kmpmovie.data.MovieSearchResult


@Serializable
data class SearchResponse<T>(
    @SerialName("Search")
    val results: List<T> = emptyList()
)

@Serializable
data class NetworkMovieSearchResult(
    @SerialName("imdbID")
    val movieId: String,
    @SerialName("Title")
    val title: String,
    @SerialName("Poster")
    val posterUrl: String,
    @SerialName("Year")
    val year: String,
)

fun NetworkMovieSearchResult.asExternalModel() = MovieSearchResult(
    movieId = movieId,
    title = title,
    posterUrl = posterUrl,
    year = year
)