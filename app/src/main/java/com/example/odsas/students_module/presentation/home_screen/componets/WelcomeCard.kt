package com.example.odsas.students_module.presentation.home_screen.componets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.odsas.students_module.presentation.profile_screen.ProfileViewModel

@Composable
fun WelcomeCard() {
    val profileViewModel: ProfileViewModel = hiltViewModel()
    val state = profileViewModel.userState.value.user

    Card(
        elevation = 10.dp,
        modifier = Modifier
//            .height(60.dp)
            .fillMaxWidth(0.95f),
    ) {
        Box(modifier = Modifier.padding(1.dp), contentAlignment = Alignment.CenterStart){

            Column(
                modifier = Modifier.padding(2.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.height(15.dp))

                Text(text = "Welcome back, ${state?.userName}", fontSize = 24.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(15.dp))

                SearchBar()
            }

        }
    }
}