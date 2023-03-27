package com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel
import com.example.odsas.students_module.presentation.appointments.components.AppointmentsTab
import com.example.odsas.students_module.presentation.appointments.successful_appointment_screen.SuccessfulAppointmentItem
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar
import com.example.odsas.ui.theme.CustomBlack

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

        AllUpcomingApp(navController)

//        UpcomingAppointmentItem("2 days", "Sun, Jan 19, 08.00am - 09.00am")
//        Spacer(modifier = Modifier.height(2.dp))
//        UpcomingAppointmentItem("4 days", "Tuesday, March 14, 09.30am - 10.00am")
    }

//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Text(text = "Upcoming appointment Screen", modifier = Modifier)
//    }
}

@Composable
fun AllUpcomingApp(
    navController: NavHostController,
) {

    val upcomingViewModel: UpcomingViewModel = hiltViewModel()

    val state = upcomingViewModel.bookingListState.value

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        LazyColumn(
            contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 70.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            state.bookingList?.let {
                items(it){ item ->
                    UpcomingAppointmentItem(countDown = "30 Min", time = "${item.date}    ${item.time}")

                }
            }

        }


        //show error if any
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = CustomBlack,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .align(Alignment.TopCenter)
            )
        }

        //load shimmer
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }

}