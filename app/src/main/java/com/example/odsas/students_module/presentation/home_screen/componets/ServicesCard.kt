
package com.example.odsas.students_module.presentation.home_screen.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.odsas.ui.theme.CustomBlack
import com.example.odsas.ui.theme.CustomWhite
import com.example.odsas.R
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue

@Composable
fun ServicesCard(navController: NavHostController) {
    Card(
        elevation = 15.dp,
        modifier = Modifier
            .padding(vertical = 1.dp,)
            .fillMaxWidth(0.95f),
    ) {
        Column(modifier = Modifier.padding(1.dp)) {

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Services",
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(0.99f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {


                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            //click event
                            navController.navigate(Screens.BookAppointmentScreen.route) {
                                popUpTo(Screens.BookAppointmentScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.fee),
                        contentDescription = "fee",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(40.dp),
                        tint = CustomBlue
                    )

                    Text(
                        text = "Fees",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }




                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            //click event
                            navController.navigate(Screens.BookAppointmentScreen.route) {
                                popUpTo(Screens.BookAppointmentScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.note),
                        contentDescription = "Exam",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(40.dp),
                        tint = CustomBlue
                    )

                    Text(
                        text = "Exam",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }




                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            //click event
                            navController.navigate(Screens.BookAppointmentScreen.route) {
                                popUpTo(Screens.BookAppointmentScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .padding(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.remove_folder),
                        contentDescription = "de-registration",
                        modifier = Modifier
                            .padding(4.dp)
                            .size(40.dp),
                        tint = CustomBlue
                    )

                    Text(
                        text = "De-registration",
                        modifier = Modifier.padding(4.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


            }
        }



    }
}

