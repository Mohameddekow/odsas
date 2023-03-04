package com.example.odsas.students_module.presentation.home_screen.componets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeCard() {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(0.95f),
    ) {
        Box(modifier = Modifier.padding(5.dp), contentAlignment = Alignment.CenterStart){

            Text(text = "Welcome back, Moha", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}