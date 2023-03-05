package com.example.odsas.students_module.presentation.home_screen.componets

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.odsas.students_module.presentation.screens.Screens

@Composable
fun ScreenTitleBar(title: String, navController: NavHostController) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.padding(start = 1.dp, top = 1.dp),
            onClick = {
                navController.popBackStack()
            }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "menu",
                modifier = Modifier
                    .size(36.dp),
//                tint = Color.White,
            )
        }

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}