package com.example.submissionexpert1.presentation.ui.state.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.submissionexpert1.R
import com.example.submissionexpert1.presentation.common.Size
import com.example.submissionexpert1.presentation.ui.shared.MainButton
import com.example.submissionexpert1.presentation.ui.shared.MainText

@Preview(showSystemUi = true)
@Composable
fun MainError(
  message : String = "Koneksi Internet mu tergangguk!",
  onRetry : () -> Unit = {}
) {
  Column(
    modifier = Modifier
      .fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(
      8.dp,
      alignment = Alignment.CenterVertically
    ),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = painterResource(
        R.drawable.error
      ),
      contentDescription = "Error",
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .fillMaxWidth()
        .clip(
          MaterialTheme.shapes.extraLarge
        ),
    )
    MainText(
      text = message,
      textSize = Size.Large,
      textAlign = TextAlign.Center
    )
    
    Spacer(
      modifier = Modifier.height(8.dp)
    )
    MainButton(
      text = "Coba Lagi",
      modifier = Modifier.fillMaxWidth(),
      onClick = onRetry
    )


  }

}