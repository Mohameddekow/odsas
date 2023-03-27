package com.example.odsas.students_module.presentation.states

import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.domain.model.NotificationItemModel

data class NotificationState(
    val isLoading: Boolean = false,
    val notificationList: List<NotificationItemModel>? = null,
    val error: String = ""
)