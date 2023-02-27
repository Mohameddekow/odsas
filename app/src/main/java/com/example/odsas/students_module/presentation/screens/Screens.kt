package com.example.odsas.students_module.presentation.screens


sealed class Screens(val route: String) {
    object HomeScreen : Screens(route = "home_screen")
    object BookAppointmentScreen : Screens(route = "book_appointment_screen")
    object AnalysisScreen : Screens(route = "analysis_screen")
}
