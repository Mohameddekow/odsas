package com.example.odsas.students_module.presentation.notification_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen.UpcomingAppointmentItem
import com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen.UpcomingViewModel
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar
import com.example.odsas.ui.theme.CustomBlack

@Composable
fun NotificationScreen(navController: NavHostController) {
    val notificationViewModel: NotificationViewModel = hiltViewModel()

    val state = notificationViewModel.notificationListState.value

////    val upcomingViewModel: UpcomingViewModel = hiltViewModel()
//
//    val state = upcomingViewModel.bookingListState.value


//    Column(
//        modifier = Modifier.padding(4.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {}

    Card(elevation = 10.dp, modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()) {

        ScreenTitleBar("Notification screen", navController )
    }


        //Text(text = state.notificationList.toString())

    Box(
        modifier = Modifier.fillMaxSize().padding(top = 60.dp),
        contentAlignment = Alignment.TopCenter
    ) {

            LazyColumn(
                contentPadding = PaddingValues(start = 4.dp, end = 4.dp, top = 15.dp, bottom = 70.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {

                state.notificationList?.let {
                    items(it){ item ->
                        //UpcomingAppointmentItem(countDown = "30 Min", time = "${item.date}    ${item.time}")

                        Card(elevation = 5.dp, modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                            .fillMaxWidth()) {
                            NotificationItem(time = "${item.date} at ${item.time}")
                        }
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





//        Card(elevation = 5.dp, modifier = Modifier
//            .padding(horizontal = 10.dp, vertical = 4.dp)
//            .fillMaxWidth()) {
//            NotificationItem(time = "Wednesday, 15th March ")
//        }
//
//        Card(elevation = 5.dp, modifier = Modifier
//            .padding(horizontal = 10.dp, vertical = 4.dp)
//            .fillMaxWidth()) {
//            NotificationItem(time = "Monday, 20th March ")
//        }
//
//        Card(elevation = 5.dp, modifier = Modifier
//            .padding(horizontal = 10.dp, vertical = 4.dp)
//            .fillMaxWidth()) {
//            NotificationItem(time = "Tuesday, 21th March ")
//        }
//
//        Card(elevation = 5.dp, modifier = Modifier
//            .padding(horizontal = 10.dp, vertical = 4.dp)
//            .fillMaxWidth()) {
//            NotificationItem(time = "Friday, 24th March ")
//        }



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