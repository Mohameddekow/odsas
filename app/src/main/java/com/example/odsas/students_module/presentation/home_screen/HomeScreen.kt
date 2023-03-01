package com.example.odsas.students_module.presentation.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.home_screen.componets.BottomNavigationMenu
import com.example.odsas.students_module.presentation.home_screen.componets.BottomNavigationMenuItem
import com.example.odsas.students_module.presentation.home_screen.componets.SearchBar
import com.example.odsas.students_module.presentation.home_screen.componets.TopBar


@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TopBar(navController = rememberNavController())
            SearchBar()
            Text(text = "Home Screen", modifier = Modifier)
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
