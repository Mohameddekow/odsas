package com.example.odsas.students_module.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.home_screen.componets.*


@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize(),){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TopBar(navController = rememberNavController())

            Spacer(modifier = Modifier.height(10.dp))

            WelcomeCard()

            Spacer(modifier = Modifier.height(10.dp))

            SearchBar()

            Spacer(modifier = Modifier.height(10.dp))

            ServicesCard()

            Spacer(modifier = Modifier.height(10.dp))

            NextAppointmentBox()

            Spacer(modifier = Modifier.height(10.dp))

//            AppointmentsTab(
//                navController = navController,
//                items = listOf(
//                    AppointmentsTabItemModel(title = "Upcoming"),
//                    AppointmentsTabItemModel(title = "Successful"),
//                ),
//                // modifier = Modifier.align(Alignment.BottomCenter),
//                selectedItemIndex = -1 //none is selected at the start
//            )

        }



        BottomNavigationMenu(
            navController = navController,
            items = listOf(
                BottomNavigationMenuItemModel(title = "home", iconId = R.drawable.home),
                BottomNavigationMenuItemModel(title = "book appointment", iconId = R.drawable.book_appointment),
                BottomNavigationMenuItemModel(title = "analysis", iconId = R.drawable.analysis)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 0
        )
    }
}