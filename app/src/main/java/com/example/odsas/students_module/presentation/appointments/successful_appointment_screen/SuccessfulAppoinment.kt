package com.example.odsas.students_module.presentation.appointments.successful_appointment_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel
import com.example.odsas.students_module.presentation.appointments.components.AppointmentsTab
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar

@Composable
fun SuccessfulAppointmentScreen(navController: NavHostController) {
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
                selectedItemIndex = 1 //none is selected at the start
            )
        Spacer(modifier = Modifier.height(10.dp))

        SuccessfulAppointmentItem("Sun, Jan 19, 08.00am - 09.00am")
        Spacer(modifier = Modifier.height(2.dp))
        SuccessfulAppointmentItem("Tuesday, March 14, 09.30am - 10.00am")
        Spacer(modifier = Modifier.height(2.dp))
        SuccessfulAppointmentItem("Friday, March 17, 01.00pm - 02.00pm")
    }

}