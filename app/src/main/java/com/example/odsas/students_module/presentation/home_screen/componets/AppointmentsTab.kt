package com.example.odsas.students_module.presentation.home_screen.componets


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue


//Main services emergency and booking tabs
@Composable
fun AppointmentsTab(
    navController: NavHostController,
    items: List<AppointmentsTabItemModel>,
    modifier: Modifier = Modifier,
    activeItemColor: Color = CustomBlue,
    selectedItemIndex: Int
) {

    val context = LocalContext.current
    var selectedItemIndex by remember{ mutableStateOf(selectedItemIndex) }

    Column(
        modifier = modifier.wrapContentHeight().padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Row(
            modifier = modifier
                .clip(RoundedCornerShape(5.dp))
                .background(
                    color = Color.LightGray,//LightGreyBg else Color.Cyan
                )
                .padding(start = 4.dp, top = 0.dp, bottom = 0.dp, end = 4.dp)
                .fillMaxWidth(0.97f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, hcrMainServicesItem ->

                AppointmentsTabItem(
                    modifier = Modifier.weight(0.5f),
                    items = hcrMainServicesItem,
                    activeItemColor = activeItemColor,
                    itemIsSelected = index == selectedItemIndex
                ){
                    selectedItemIndex = index

                    when (selectedItemIndex) {
                        0 -> {
//                            if (navController.currentDestination?.route !== Screens.UpcomingAppointmentScreen.route){
//                                //navigate only if we're not this destination
//                                navController.navigate(Screens.UpcomingAppointmentScreen.route ){
//                                    launchSingleTop = true
//
//                                    popUpTo(Screens.UpcomingAppointmentScreen.route ){
//                                        inclusive = false
//                                    }
//                                }
//                            }

                            Toast.makeText(context, "Upcoming appo", Toast.LENGTH_SHORT).show()
                        }
                        1 -> {
//                            if (navController.currentDestination?.route !== Screens.SuccessfulAppointmentScreen.route){
//                                //navigate only if we're not this destination
//                                navController.navigate(Screens.SuccessfulAppointmentScreen.route){
//                                    launchSingleTop = true
//
//                                    popUpTo(Screens.SuccessfulAppointmentScreen.route){
//                                        inclusive = true
//                                    }
//                                }
//                            }
                            Toast.makeText(context, "Successful appo", Toast.LENGTH_SHORT).show()

                        }
                    }
                }
            }
        }
    }

}
