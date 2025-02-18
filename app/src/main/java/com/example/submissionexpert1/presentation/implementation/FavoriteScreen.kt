package com.example.submissionexpert1.presentation.implementation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.submissionexpert1.presentation.ui.shared.movie.MovieGrid
import com.example.submissionexpert1.presentation.viewmodel.FavoriteEvent
import com.example.submissionexpert1.presentation.viewmodel.FavoriteViewModel


private const val LOAD_MORE_THRESHOLD = 3

@Composable
fun FavoriteScreen(
  modifier : Modifier = Modifier,
  onNavigateDetail : (String) -> Unit,
  viewModel : FavoriteViewModel = hiltViewModel(),

  ) {
  val uiState by viewModel.uiState.collectAsState()

  val movieState by viewModel.movieState.collectAsState()

  val onEvent = { event : FavoriteEvent -> viewModel.onEvent(event) }
  val movies = if (uiState.isRefreshing) {
    movieState.dataBeforeRefresh?.results ?: emptyList()
  } else {
    movieState.data?.results ?: emptyList()
  }

  val gridState = rememberLazyGridState()

  val reachedBottom by remember {
    derivedStateOf {
      val layoutInfo = gridState.layoutInfo
      val totalItemsCount = layoutInfo.totalItemsCount
      val lastVisibleItemIndex =
        (gridState.firstVisibleItemIndex + layoutInfo.visibleItemsInfo.size)

      totalItemsCount > 0 && lastVisibleItemIndex > (totalItemsCount - LOAD_MORE_THRESHOLD)
    }
  }


  LaunchedEffect(reachedBottom) {
    if (reachedBottom && ! uiState.isLoadingMore && ! uiState.isRefreshing) {
      viewModel.onEvent(FavoriteEvent.OnLoad)
    }
  }
  LaunchedEffect(
    key1 = uiState.isLoading,
  ) {
    gridState.scrollToItem(0)
  }





  Column(
    modifier = modifier.padding(
      horizontal = 16.dp
    ),
  ) {

    MovieGrid(
      movies = movies,
      gridState = gridState,
      onNavigateDetail = onNavigateDetail,
      alert = uiState.alert,
      isLoading = uiState.isLoading,
      isRefreshing = uiState.isRefreshing,
      isLoadingMore = uiState.isLoadingMore,
      error = uiState.error,
      onDismissedAlert = { onEvent(FavoriteEvent.OnDismissedAlert) },
      onLoad = { onEvent(FavoriteEvent.OnLoad) },
      onRefresh = { onEvent(FavoriteEvent.OnRefresh) },
      isTopSectionExist = false,
      column = 2
    )
  }

}