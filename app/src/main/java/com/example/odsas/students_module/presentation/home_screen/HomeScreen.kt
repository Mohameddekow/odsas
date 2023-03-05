package com.example.odsas.students_module.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.appointments.components.AppointmentsTab
import com.example.odsas.students_module.presentation.appointments.components.NextAppointmentBox
import com.example.odsas.students_module.presentation.home_screen.componets.*


@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize(),){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            TopBar(navController = navController)

            Spacer(modifier = Modifier.height(15.dp))
            WelcomeCard()

            Spacer(modifier = Modifier.height(20.dp))
            ServicesCard(navController = navController)

            Spacer(modifier = Modifier.height(20.dp))
            NextAppointmentBox(navController = navController)

            Spacer(modifier = Modifier.height(10.dp))


        }



        BottomNavigationMenu(
            navController = navController,
            items = listOf(
                BottomNavigationMenuItemModel(title = "home", iconId = R.drawable.home),
                BottomNavigationMenuItemModel(title = "book appointment", iconId = R.drawable.book_appointment),
                BottomNavigationMenuItemModel(title = "analysis", iconId = R.drawable.analysis)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 0
        )
    }
}
