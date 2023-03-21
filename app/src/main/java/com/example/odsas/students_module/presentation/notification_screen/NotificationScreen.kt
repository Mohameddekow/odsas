package com.example.odsas.students_module.presentation.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar

@Composable
fun NotificationScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(elevation = 10.dp, modifier = Modifier.padding(4.dp).fillMaxWidth()) {

            ScreenTitleBar("Notification screen", navController )
        }

        Card(elevation = 5.dp, modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .fillMaxWidth()) {
            NotificationItem(time = "Wednesday, 15th March ")
        }

        Card(elevation = 5.dp, modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .fillMaxWidth()) {
            NotificationItem(time = "Monday, 20th March ")
        }

        Card(elevation = 5.dp, modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .fillMaxWidth()) {
            NotificationItem(time = "Tuesday, 21th March ")
        }

        Card(elevation = 5.dp, modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .fillMaxWidth()) {
            NotificationItem(time = "Friday, 24th March ")
        }

    }

}


@Composable
fun NotificationItem(time: String,) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text ="Booked an appointment with Dr. Makau Mutua on ${time}",
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}