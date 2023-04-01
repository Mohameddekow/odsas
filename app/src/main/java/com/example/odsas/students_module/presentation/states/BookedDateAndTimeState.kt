package com.example.odsas.students_module.presentation.states

import com.example.odsas.students_module.domain.model.BookedDateAndTimeItemModel
import com.example.odsas.students_module.domain.model.BookingItemModel

data class BookedDateAndTimeState(
    val isLoading: Boolean = false,
    val bookedDateAndTimeList: List<BookedDateAndTimeItemModel>? = null,
    val error: String = ""
)