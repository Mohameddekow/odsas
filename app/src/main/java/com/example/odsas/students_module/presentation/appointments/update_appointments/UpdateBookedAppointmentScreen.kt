package com.example.odsas.students_module.presentation.appointments.update_appointments

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.appointments.SharedViewModel
import com.example.odsas.students_module.presentation.home_screen.componets.BottomNavigationMenu
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UpdateBookedAppointmentScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    Box(modifier = Modifier.fillMaxSize()){
        //Text(text = "Book appointment Screen", modifier = Modifier)

        Card(elevation = 10.dp, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {

            ScreenTitleBar(title = "Re schedule screen", navController = navController)
        }



        Column(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 6.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(90.dp))

            BookingContent(navController, sharedViewModel)

        }


        //bottom navigation
        BottomNavigationMenu(
            navController = navController,
            items = listOf(
                BottomNavigationMenuItemModel(title = "home", iconId = R.drawable.home),
                BottomNavigationMenuItemModel(title = "book appointment", iconId = R.drawable.book_appointment),
                BottomNavigationMenuItemModel(title = "analysis", iconId = R.drawable.analysis)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 1
        )


    }

}

