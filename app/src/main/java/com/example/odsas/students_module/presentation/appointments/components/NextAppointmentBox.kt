package com.example.odsas.students_module.presentation.appointments.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.odsas.R
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlack
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite


@Composable
fun NextAppointmentBox(navController: NavHostController) {

    Card(
        elevation = 15.dp,
        modifier = Modifier
//            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 1.dp,)
            .fillMaxWidth(0.95f),
    ) {
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(0.93f).padding(vertical = 15.dp),
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

            //content box
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .shadow(
                        elevation = 30.dp,
                        shape = RoundedCornerShape(2.dp)
                    )
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
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(CustomWhite)
                            //.size(30.dp)
                        )
                        {
                            Text(
                                text = "30 min",
                                modifier = Modifier.padding(4.dp),
                                color = Color.Black
                            )
                        }

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
                            Text(text = "Sun, Jan 19, 08.00am - 09.00am")
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

    Spacer(modifier = Modifier.height(10.dp))

}

