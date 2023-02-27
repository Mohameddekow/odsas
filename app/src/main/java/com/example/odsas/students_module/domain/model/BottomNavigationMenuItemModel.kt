package com.example.odsas.students_module.domain.model

import androidx.annotation.DrawableRes


data class BottomNavigationMenuItemModel(
    val title: String,
    @DrawableRes
    val iconId: Int,
)

