package com.example.odsas.students_module.presentation.home_screen.componets


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.odsas.students_module.domain.model.AppointmentsTabItemModel


@Composable
fun AppointmentsTabItem(
    items: AppointmentsTabItemModel,
    modifier: Modifier,
    activeItemColor: Color,
    itemIsSelected: Boolean,
    onItemClick: () -> Unit,
) {

    Box(
        modifier = modifier
            .padding(top = 5.dp, bottom = 5.dp, end = 4.dp)
            .clip(RoundedCornerShape(3.dp))
            .border(0.1.dp, Color.DarkGray)
            .clip(RoundedCornerShape(6.dp))
            .clickable { onItemClick() }
            .background(
                color = if (itemIsSelected) activeItemColor else Color.Transparent
                // nothing happens
            )
            .padding(5.dp),
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = items.title,
            color = if (itemIsSelected) Color.White else Color.Black,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
        )
    }

}


