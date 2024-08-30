package com.example.bmgalaxy.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmgalaxy.ui.theme.BmGalaxyTheme

@Composable
fun TextWithIcon(text: String, icon: ImageVector, tintColor: Color = Color.White) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = icon, // Use a phone icon
            contentDescription = "Phone Icon",
            tint = tintColor, // Change icon color to black
            modifier = Modifier.size(20.dp) // Icon size
        )
        Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp, // Slightly smaller font for contact
                color = Color.Yellow // Different color for less emphasis
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTextWithIcon() {
    BmGalaxyTheme {
        Column {
            TextWithIcon(text = "+91 8807161938", icon = Icons.Filled.Phone)
            TextWithIcon(text = "Active", icon = Icons.Filled.Album, tintColor = Color.Green)
        }
    }
}