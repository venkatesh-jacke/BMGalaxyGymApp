package com.example.bmgalaxy.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularImageView(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    contentDescription: String? = null,
    size: Dp = 120.dp // Default size
) {
    Image(
        painter = imagePainter,
        contentDescription = contentDescription,
        modifier = modifier
            .size(size)
            .clip(CircleShape) // Clip the image to a circle
            .border(2.dp, Color.Gray, CircleShape) // Optional: add a border around the circle
            .then(modifier)
    )
}
