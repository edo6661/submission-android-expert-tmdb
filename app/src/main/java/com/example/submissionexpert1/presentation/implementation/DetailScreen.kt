package com.example.submissionexpert1.presentation.implementation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(
  modifier : Modifier = Modifier,
  id : String
) {
  Column(
    modifier = modifier,
  ) {
    Text(
      text = "DEtail $id"
    )
  }
}