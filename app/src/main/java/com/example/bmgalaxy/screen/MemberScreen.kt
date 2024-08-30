package com.example.bmgalaxy.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmgalaxy.User
import com.example.bmgalaxy.UserRole
import com.example.bmgalaxy.composables.InfoCard
import com.example.bmgalaxy.composables.UserCard
import com.example.bmgalaxy.ui.theme.BmGalaxyTheme
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MemberScreen(user: User) {
    Column {
        UserCard(user = user)
        InfoCard(header = "Address", content = user.address)
        InfoCard(header = "Date Of Joining", content = user.doj)
        InfoCard(header = "Due Date", content = user.dueDate)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMemberInfo() {
    val user = User(
        id = "20510",
        name = "Venkatesh",
        contact = "8807161938",
        address = "PP Garden Aminjikarai, Chennai, Tamil Nadu, India. This address is deliberately made long to test the layout.",
        doj = LocalDate.of(2023, 8, 30),
        dueDate = LocalDate.of(2024, 8, 30),
        role = UserRole.MEMBER,
        isActive = true
    )
    BmGalaxyTheme {
        MemberScreen(user)
    }
}
