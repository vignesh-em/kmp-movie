package org.example.kmpmovie.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ScreenResultScreen(
    onResultItemClick: (movieId: String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchResultsViewModel = koinViewModel()
) {
    Column(modifier = Modifier.padding(horizontal = 8.dp)) {

        val query by viewModel.searchQuery.collectAsState()

        TextField(
            value = query ?: "",
            onValueChange = viewModel::updateSearchQuery,
            suffix = {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        viewModel.clearSearchResults()
                    }
                )
            },
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth()
        )

        val searchResults by viewModel.searchResultFlow.collectAsState()

        LazyColumn {
            items(
                count = searchResults.size
            ) { index ->
                searchResults[index].let { movie ->
                    Text(
                        movie.title,
                        modifier = Modifier
                            .clickable { onResultItemClick(movie.movieId) }
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}