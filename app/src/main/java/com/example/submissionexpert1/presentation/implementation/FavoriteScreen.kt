package com.example.submissionexpert1.presentation.implementation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoriteScreen(
  modifier : Modifier = Modifier,
  onNavigateDetail : (String) -> Unit
) {
  Column(
    modifier = modifier,
  ) {
    Text(
      text = "Memek"
    )
  }
}