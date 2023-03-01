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
import com.example.odsas.ui.theme.CustomBlack
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite


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
                color =if (itemIsSelected) CustomBlue.copy(0.6f) else  Color.Transparent
                // nothing happens
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = painterResource(id = items.iconId),
            contentDescription = items.title,
            modifier = Modifier
                .size(23.dp),
            tint = if (itemIsSelected) CustomWhite else CustomBlack
        )
    }

}