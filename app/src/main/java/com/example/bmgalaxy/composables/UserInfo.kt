package com.example.bmgalaxy.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InfoCard(header: String, content: Any?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header
            Text(
                text = header,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Yellow,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            // Content
            Text(
                text = when (content) {
                    is LocalDate -> content.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
                    else -> content?.toString() ?: "N/A"
                },
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewInfoCard() {
    Column {
        InfoCard(
            header = "Address",
            content = "PP Garden Aminjikarai, Chennai, Tamil Nadu, India. This address is deliberately made long to test the layout."
        )
        InfoCard(
            header = "Date Of Joining",
            content = LocalDate.of(2023, 8, 30)
        )
    }
}
