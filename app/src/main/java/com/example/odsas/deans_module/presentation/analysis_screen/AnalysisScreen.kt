package com.example.odsas.deans_module.presentation.analysis_screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.example.odsas.students_module.presentation.home_screen.componets.BottomNavigationMenu

@Composable
fun AnalysisScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center){
        Text(text = "Analysis Screen", modifier = Modifier)

        BottomNavigationMenu(
            navController = navController,
            items = listOf(
                BottomNavigationMenuItemModel(title = "home", iconId = R.drawable.home),
                BottomNavigationMenuItemModel(title = "book appointment", iconId = R.drawable.book_appointment),
                BottomNavigationMenuItemModel(title = "analysis", iconId = R.drawable.analysis)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedItemIndex = 2
        )
    }
}