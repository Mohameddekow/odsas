package com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel
import com.example.odsas.students_module.presentation.appointments.components.AppointmentsTab
import com.example.odsas.students_module.presentation.appointments.successful_appointment_screen.SuccessfulAppointmentItem
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar

@Composable
fun UpcomingAppointmentScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 6.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenTitleBar(title = "Appointment screen", navController = navController)

        AppointmentsTab(
            navController = navController,
            items = listOf(
                AppointmentsTabItemModel(title = "Upcoming"),
                AppointmentsTabItemModel(title = "Successful"),
            ),
            // modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 0 //none is selected at the start
        )
        Spacer(modifier = Modifier.height(10.dp))

        UpcomingAppointmentItem("2 days", "Sun, Jan 19, 08.00am - 09.00am")
        Spacer(modifier = Modifier.height(2.dp))
        UpcomingAppointmentItem("4 days", "Tuesday, March 14, 09.30am - 10.00am")
    }

//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Text(text = "Upcoming appointment Screen", modifier = Modifier)
//    }
}

