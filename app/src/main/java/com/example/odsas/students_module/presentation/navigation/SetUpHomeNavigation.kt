package com.example.odsas.students_module.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.odsas.students_module.presentation.home_screen.HomeScreen
import com.example.odsas.students_module.presentation.screens.Screens

@Composable
fun SetUpHomeNavigation() {

    val navHostController: NavHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route
    ) {


        /****
         *for the enterTransition, the entering destination is the target — the one you are applying the enterTransition to.
         * The opposite applies to the exitTransition: the initial screen is the one you are applying the exit transition to.
         *****/

        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(
                navHostController = navHostController,
            )
        }
    }
}