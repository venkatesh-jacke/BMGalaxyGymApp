package com.example.bmgalaxy.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmgalaxy.R
import com.example.bmgalaxy.User
import com.example.bmgalaxy.UserRole
import com.example.bmgalaxy.ui.theme.BmGalaxyTheme
import java.time.LocalDate

@Composable
fun UserCard(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)) // Border with rounded corners
            .clip(RoundedCornerShape(8.dp)) // Clip the box to match the rounded corners
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), // Add elevation
            colors = CardDefaults.cardColors(containerColor = Color.Black), // Set background color to black
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start, // Align to start
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp) // Padding inside the card
            ) {
                CircularImageView(imagePainter = painterResource(id = R.drawable.jacke))

                Spacer(modifier = Modifier.width(16.dp)) // Space between image and text

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start, // Align text to start
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = user.name,
                        style = TextStyle(
                            fontSize = 20.sp, // Adjust font size
                            fontWeight = FontWeight.Bold, // Make the text bold
                            color = Color.White // Set text color to white for contrast against black background
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp)) // Space between texts

                    // ID
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "ID: ",
                            style = TextStyle(
                                fontSize = 16.sp, // Font size for label
                                color = Color.White // Color for label
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp)) // Space between label and value
                        Text(
                            text = user.id,
                            style = TextStyle(
                                fontSize = 16.sp, // Font size for value
                                color = Color.Yellow // Color for value
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp)) // Space between ID and address

                    TextWithIcon(text = user.contact, icon = Icons.Filled.Phone)

                    Spacer(modifier = Modifier.height(4.dp)) // Space between ID and address

                    TextWithIcon(
                        text = if (user.isActive) "Active" else "Not Active",
                        icon = Icons.Filled.Album,
                        tintColor = if (user.isActive) Color.Green else Color.Red,
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUserView() {
    val user = User(
        id = "20510",
        name = "Venkatesh",
        contact = "8807161938",
        address = "PP Garden Aminjikarai",
        doj = LocalDate.of(2023, 8, 30),
        dueDate = LocalDate.of(2024, 8, 30),
        role = UserRole.MEMBER,
        isActive = true
    )
    BmGalaxyTheme {
        UserCard(user)
    }
}

