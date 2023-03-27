package com.example.odsas.students_module.presentation.book_appointment_screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.commons.USERS_ROOT_REF
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.home_screen.componets.BottomNavigationMenu
import com.example.odsas.students_module.presentation.home_screen.componets.ScreenTitleBar
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite

@Composable
fun BookAppointmentScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        //Text(text = "Book appointment Screen", modifier = Modifier)

        Card(elevation = 10.dp, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {

            ScreenTitleBar(title = "Booking screen", navController = navController)
        }



        Column(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 6.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(90.dp))

            BookingContent(navController)

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

