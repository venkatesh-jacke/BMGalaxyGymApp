package com.example.bmgalaxy.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmgalaxy.ButtonWidth
import com.example.bmgalaxy.R
import com.example.bmgalaxy.composables.ButtonView
import com.example.bmgalaxy.composables.CircularImageView
import com.example.bmgalaxy.composables.TextFieldWithIcons
import com.example.bmgalaxy.ui.theme.BmGalaxyTheme

@Composable
fun LoginScreen() {
    val TAG = "LoginScreen"

    // State variables to hold text field values
    var memberId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    val logo = painterResource(id = R.drawable.logo)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Added padding for better layout
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        CircularImageView(imagePainter = logo)

        Spacer(modifier = Modifier.height(32.dp)) // Space between image and text fields

        // Member ID text field
        TextFieldWithIcons(
            text = memberId,
            labelText = "Member ID",
            leadingIcon = Icons.Default.AccountCircle,
            onValueChange = { memberId = it }
        )
        Spacer(modifier = Modifier.height(16.dp)) // Added space between text fields

        // Password text field
        TextFieldWithIcons(
            text = password,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            isSecureField = true,
            onValueChange = { password = it }
        )

        Spacer(modifier = Modifier.height(24.dp)) // Added space before button

        // Login button
        ButtonView(text = "Login", action = {
            Toast.makeText(
                context,
                "Member ID: $memberId\nPassword: $password",
                Toast.LENGTH_SHORT
            ).show()
            Log.d(TAG, "Member ID: $memberId\nPassword: $password")
        }, width = ButtonWidth.Custom)
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLoginScreen() {
    BmGalaxyTheme {
        LoginScreen()
    }

}