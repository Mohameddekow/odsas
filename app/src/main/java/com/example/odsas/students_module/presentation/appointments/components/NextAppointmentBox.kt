package com.example.odsas.students_module.presentation.appointments.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.presentation.appointments.SharedViewModel
import com.example.odsas.students_module.presentation.home_screen.HomeViewModel
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite


@Composable
fun NextAppointmentBox(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    val homeViewModel: HomeViewModel = hiltViewModel()

    val state = homeViewModel.bookingListState.value.bookingList

    val ctx = LocalContext.current

    Card(
        elevation = 15.dp,
        modifier = Modifier
//            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 1.dp,)
            .fillMaxWidth(0.95f),

    ) {
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.93f)
                    .padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Upcoming appointment",
                    modifier = Modifier.padding(0.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "View all",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            //click event
                            navController.navigate(Screens.UpcomingAppointmentScreen.route) {
                                popUpTo(Screens.UpcomingAppointmentScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .padding(4.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = CustomBlue
                )
            }

            if (state?.size == 0){
                Box(modifier = Modifier.padding(4.dp), contentAlignment = Alignment.Center) {
                    Text(text = "You have no upcoming appointments!",modifier = Modifier.padding(vertical = 10.dp), fontSize = 20.sp, textAlign = TextAlign.Center)
                }
            }else{

                //if there are appointment show it
                //content box
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .shadow(
                            elevation = 30.dp,
                            shape = RoundedCornerShape(2.dp)
                        )
                        .clickable {
                            Toast
                                .makeText(ctx, "navigating....", Toast.LENGTH_LONG)
                                .show()


//                stateZ.updateAppointment(
//                    creationTimeMs = 1680212322346,
//                    date = "30/3/2023",
//                    desc = "nothing ......",
//                    reason = "Fees",
//                    time  = "10:30",
//                    userId = userId!!,
//                    bookingRootRef = BOOKING_APPOINTMENT_ROOT_REF
//                )
                            val appointmentBookedDetails = BookingItemModel(
                                date = state?.get(0)?.date,
                                time = state?.get(0)?.time,
                                reason = state?.get(0)?.reason,
                                desc = state?.get(0)?.desc,
                                creationTimeMs = state?.get(0)?.creationTimeMs,
                            )

                            sharedViewModel.addBookingAppointmentDetails(appointmentBookedDetails)

                            navController.navigate(Screens.UpdateBookedAppointmentScreen.route) {
                                popUpTo(Screens.UpdateBookedAppointmentScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .background(CustomBlue)
                        .padding(10.dp)
                    //.fillMaxWidth(0.95f)
                ) {

                    Column(
                        modifier = Modifier.padding(top = 4.dp, bottom = 10.dp, end = 10.dp, start = 10.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                modifier = Modifier
                                    //.fillMaxWidth()
                                    .padding(3.dp),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.Top
                            ) {

                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(null) //profile image
                                        .crossfade(true)
                                        .build(),
                                    placeholder = painterResource(R.drawable.dr_mutua),
                                    contentDescription = "image",
                                    modifier = Modifier
                                        .size(70.dp)
                                        .alpha(1f)
                                        .clip(RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop,
                                    fallback = painterResource(id = R.drawable.dr_mutua)
                                )

                                Column(
                                    modifier = Modifier.padding(start = 10.dp, top = 3.dp),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = "Dr. Makau Mutua",
                                        modifier = Modifier.padding(4.dp),
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = CustomWhite
                                    )
                                    Text(
                                        text = "Dean, SCI",
                                        modifier = Modifier.padding(4.dp),
                                        color = CustomWhite
                                    )
                                }

                            }//image and personal details box ends


                            //count down timer
//                        Box(modifier = Modifier
//                            .clip(RoundedCornerShape(5.dp))
//                            .background(CustomWhite)
//                            //.size(30.dp)
//                        )
//                        {
//                            Text(
//                                text = "30 min",
//                                modifier = Modifier.padding(4.dp),
//                                color = Color.Black
//                            )
//                        }

                        }//end of first row


                        Spacer(modifier = Modifier.height(18.dp))
                        //due date and time box
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(CustomWhite)
                            .padding(start = 6.dp, end = 6.dp, bottom = 6.dp, top = 6.dp)
                            .fillMaxWidth()
                        ) {

                            Row(
                                modifier = Modifier.padding(start = 10.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(
                                    modifier = Modifier.padding(start = 1.dp, top = 1.dp),
                                    onClick = {
//                            navController.navigate(Screens.NotificationScreen.route) {
//                                popUpTo(Screens.NotificationScreen.route) {
//                                    inclusive = true
//                                }
//                            }
                                    }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.calendar),
                                        contentDescription = "calender",
                                        modifier = Modifier
                                            .size(28.dp),
//                tint = Color.White,
                                    )
                                }
                                //Text(text = "Sun, Jan 19, 08.00am - 09.00am")
                                Text(
                                    text  = if(state?.size == 0)
                                    {
                                        "0/0/0000      0:0"

                                    } else if(state?.size != 0){
                                        "${state?.get(0)?.date}      ${state?.get(0)?.time}"
                                    }
                                    else{
                                        "0/0/0000      00:00"
                                    }
                                )
                            }
                        }
                    }


                    Icon(
                        painter = painterResource(id = R.drawable.bells),
                        contentDescription = "notification",
                        modifier = Modifier
                            .size(23.dp)
                            .align(Alignment.TopEnd)
                            .padding(4.dp),
                        tint = CustomWhite,

                        )
                }
            }

        }

    }

    Spacer(modifier = Modifier.height(10.dp))

}

