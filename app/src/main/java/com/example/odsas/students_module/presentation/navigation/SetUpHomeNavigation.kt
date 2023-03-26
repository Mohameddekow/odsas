package com.example.odsas.students_module.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.odsas.deans_module.presentation.analysis_screen.AnalysisScreen
import com.example.odsas.students_module.presentation.book_appointment_screen.BookAppointmentScreen
import com.example.odsas.students_module.presentation.home_screen.HomeScreen
import com.example.odsas.students_module.presentation.notification_screen.NotificationScreen
import com.example.odsas.students_module.presentation.profile_screen.ProfileScreen
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.students_module.presentation.appointments.successful_appointment_screen.SuccessfulAppointmentScreen
import com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen.UpcomingAppointmentScreen
import com.example.odsas.students_module.presentation.auth.login_screen.LoginScreen
import com.example.odsas.students_module.presentation.auth.registration_screen.RegistrationScreen

@Composable
fun SetUpHomeNavigation() {

    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
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
                navController = navController,
            )
        }

        composable(
            route = Screens.BookAppointmentScreen.route
        ) {
            BookAppointmentScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.AnalysisScreen.route
        ) {
            AnalysisScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.ProfileScreen.route
        ) {
            ProfileScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.NotificationScreen.route
        ) {
            NotificationScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.SuccessfulAppointmentScreen.route
        ) {
            SuccessfulAppointmentScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.UpcomingAppointmentScreen.route
        ) {
             UpcomingAppointmentScreen(
                navController = navController,
            )
        }

        //Auth
        composable(
            route = Screens.LoginScreen.route
        ) {
             LoginScreen(
                navController = navController,
            )
        }

        composable(
            route = Screens.RegistrationScreen.route
        ) {
             RegistrationScreen(
                navController = navController,
            )
        }
    }
}