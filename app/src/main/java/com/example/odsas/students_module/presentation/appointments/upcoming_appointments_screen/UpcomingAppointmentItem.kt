package com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.odsas.R
import com.example.odsas.ui.theme.CustomBlack
import com.example.odsas.ui.theme.CustomBlue

@Composable
fun UpcomingAppointmentItem(countDown: String, time: String) {
    Card(
        elevation = 15.dp,
        modifier = Modifier
//            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 1.dp,)
            .fillMaxWidth(0.95f),
    ) {
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {

            //content box
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
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
                                    color = CustomBlack
                                )
                                Text(
                                    text = "Dean, SCI",
                                    modifier = Modifier.padding(4.dp),
                                    color = CustomBlack
                                )
                            }

                        }//image and personal details box ends


                        //count down timer
//                        Box(modifier = Modifier
//                            .clip(RoundedCornerShape(5.dp))
//                            .background(CustomBlue.copy(0.4f))
//                            //.size(30.dp)
//                        )
//                        {
//                            Text(
//                                text = countDown,//"2 days",
//                                modifier = Modifier.padding(4.dp),
//                                color = CustomBlack
//                            )
//                        }

                    }//end of first row


                    Spacer(modifier = Modifier.height(18.dp))
                    //due date and time box
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(CustomBlue.copy(0.4f))
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
                                    tint = Color.White,
                                )
                            }
                            Text(text = time, color = CustomBlack)//text = "Sun, Jan 19, 08.00am - 09.00am", color = CustomBlack)
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
                    tint = CustomBlue,

                    )
            }
        }

    }

}