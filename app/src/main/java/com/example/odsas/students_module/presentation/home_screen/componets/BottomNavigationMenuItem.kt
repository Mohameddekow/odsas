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



@Composable
fun BottomNavigationMenuItem(
    items: BottomNavigationMenuItemModel,
    activeItemColor: Color,
    itemIsSelected: Boolean,
    onItemClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onItemClick() }
            .background(
                color =if (itemIsSelected) Color.Blue.copy(0.6f) else  Color.Transparent
                // nothing happens
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = painterResource(id = items.iconId),
            contentDescription = items.title,
            modifier = Modifier
                .size(30.dp),
            tint = if (itemIsSelected) Color.Black else Color.White
        )
    }

}