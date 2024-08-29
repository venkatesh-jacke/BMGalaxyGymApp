package com.example.bmgalaxy.composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.Visibility
import com.example.bmgalaxy.screen.LoginScreen
import com.example.bmgalaxy.ui.theme.BmGalaxyTheme


@Composable
fun TextFieldWithIcons(
    text: String = "",
    labelText: String,
    placeholder: String = "",
    isSecureField: Boolean = false,
    leadingIcon: ImageVector,
    onValueChange:(String)->Unit={}
) {
    // Manage text state
    var textState by remember { mutableStateOf(TextFieldValue(text)) }

    // Manage visibility state for secure text input
    var isPasswordVisible by remember { mutableStateOf(!isSecureField) }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
            onValueChange(it.text)
        },
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = "icon")
        },
        trailingIcon = {
            if (isSecureField) {
                val icon = if (isPasswordVisible) {
                    Icons.Filled.Lock
                } else {
                    Icons.Filled.Clear
                }
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Icon(imageVector = icon, contentDescription = "Toggle password visibility")
                }
            }
        },
        label = {
            Text(text = labelText)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = if (isSecureField && !isPasswordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextFieldWithIcons() {
    // Example preview with secure text field
    BmGalaxyTheme {
        TextFieldWithIcons(
            labelText = "Password",
            placeholder = "Enter your password",
            isSecureField = true,
            leadingIcon = Icons.Default.Lock
        )
    }
}
