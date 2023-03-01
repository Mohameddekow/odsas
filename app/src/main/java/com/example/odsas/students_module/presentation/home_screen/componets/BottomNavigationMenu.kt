package com.example.odsas.students_module.presentation.home_screen.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite


@Composable
fun BottomNavigationMenu(
    navController: NavHostController,
    items: List<BottomNavigationMenuItemModel>,
    modifier: Modifier = Modifier,
    activeItemColor : Color = Color.Blue,
    selectedItemIndex: Int
) {

    var selectedItemIndex by remember{ mutableStateOf(selectedItemIndex) }

    Column(
        modifier = modifier.wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Divider(
            color = CustomBlue.copy(0.9f),
            thickness = 0.5.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = modifier
                .background(
                    color = CustomWhite
//                    color = if (!darkTheme) LightModeBackgroundWhite else Color.Black
                )
                .padding(top = 7.dp, bottom = 8.dp, end = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, homeBottomMenuItem ->

                BottomNavigationMenuItem(
                    items = homeBottomMenuItem,
                    activeItemColor  = activeItemColor,
                    itemIsSelected = index == selectedItemIndex
                ){
                    selectedItemIndex = index

                    when (selectedItemIndex) {
                        0 -> {
                            if (navController.currentDestination?.route !== Screens.HomeScreen.route){
                                //navigate only if we're not this destination
                                navController.navigate(Screens.HomeScreen.route){
                                    launchSingleTop = true

                                    popUpTo(Screens.HomeScreen.route){
                                        inclusive = true
                                    }
                                }
                            }


                        }
                        1 -> {
                            if (navController.currentDestination?.route !== Screens.BookAppointmentScreen.route){
                                //navigate only if we're not this destination
                                navController.navigate(Screens.BookAppointmentScreen.route ){
                                    launchSingleTop = true

                                    popUpTo(Screens.BookAppointmentScreen.route ){
                                        inclusive = false
                                    }
                                }
                            }
                        }
                        2 -> {
                            if (navController.currentDestination?.route !== Screens.AnalysisScreen.route) {
                                //navigate only if we're not this destination
                                navController.navigate(Screens.AnalysisScreen.route){

                                    launchSingleTop = true

                                    popUpTo(Screens.AnalysisScreen.route){
                                        inclusive = false
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}


