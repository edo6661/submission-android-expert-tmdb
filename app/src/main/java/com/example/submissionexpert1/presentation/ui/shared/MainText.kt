package com.example.submissionexpert1.presentation.ui.shared

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.example.submissionexpert1.presentation.common.Size

@Composable
fun MainText(
  modifier : Modifier = Modifier,
  style : TextStyle = TextStyle.Default,
  text : String,
  textSize : Size = Size.Small,
  color : Color = MaterialTheme.colorScheme.onSurface,
  fontWeight : FontWeight = FontWeight.Normal,
  isEllipsis : Boolean = false,
  maxLines : Int = Int.MAX_VALUE,
  textAlign : TextAlign = TextAlign.Start,
  textDecoration : TextDecoration = TextDecoration.None,
  onClick : (() -> Unit)? = null
) {
  val textSizeValue = when (textSize) {
    Size.Small      -> MaterialTheme.typography.labelSmall
    Size.Medium     -> MaterialTheme.typography.bodySmall
    Size.Large      -> MaterialTheme.typography.headlineSmall
    Size.ExtraLarge -> MaterialTheme.typography.titleSmall
  }
  val textStyle = style.copy(
    color = color,
    fontWeight = fontWeight
  )
  val finalStyle = textStyle.merge(textSizeValue)

  val finalModifier = if (onClick != null) {
    modifier.clickable { onClick() }
  } else {
    modifier
  }

  Text(
    text = text,
    style = finalStyle,
    modifier = finalModifier,
    maxLines = maxLines,
    overflow = if (isEllipsis) TextOverflow.Ellipsis else TextOverflow.Clip,
    textAlign = textAlign,
    textDecoration = textDecoration,
  )
}