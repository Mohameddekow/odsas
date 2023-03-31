package com.example.odsas.students_module.presentation.screens


sealed class Screens(val route: String) {
    object HomeScreen : Screens(route = "home_screen")
    object BookAppointmentScreen : Screens(route = "book_appointment_screen")
    object UpdateBookedAppointmentScreen : Screens(route = "update_booked_appointment_screen")
    object AnalysisScreen : Screens(route = "analysis_screen")
    object ProfileScreen : Screens(route = "profile_screen")
    object NotificationScreen : Screens(route = "notification_screen")

    object SuccessfulAppointmentScreen : Screens(route = "successful_app_screen")

    object UpcomingAppointmentScreen : Screens(route = "upcoming_app_screen")
    object LoginScreen : Screens(route = "login_screen")
    object RegistrationScreen : Screens(route = "registration_screen")

}
