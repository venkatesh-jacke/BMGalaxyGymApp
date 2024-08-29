package com.example.bmgalaxy.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmgalaxy.ButtonWidth
import com.example.bmgalaxy.ui.theme.BmGalaxyTheme

@Composable
fun ButtonView(
    text: String,
    action: () -> Unit,
    modifier: Modifier = Modifier, // Default modifier is empty
    width: ButtonWidth = ButtonWidth.Full // Default width is Full
) {
    Button(
        onClick = { action() },
        modifier = modifier.then(
            when (width) {
                ButtonWidth.Full -> Modifier.fillMaxWidth()
                ButtonWidth.Half -> Modifier.fillMaxWidth(0.5f) /// Adjust this as needed
                ButtonWidth.Custom -> Modifier.width(100.dp) // Example for custom width
            }
        )
    ) {
        Text(text = text)
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewButtonView(){
    BmGalaxyTheme {
        ButtonView(text = "Button", action = { })
    }
}
