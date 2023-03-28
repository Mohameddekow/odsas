package com.example.odsas.students_module.presentation.states

import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.domain.model.UserModel

data class UserState(
    val isLoading: Boolean = false,
    val user: UserModel? = null,
    val error: String = ""
)