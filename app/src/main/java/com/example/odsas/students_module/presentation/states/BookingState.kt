package com.example.odsas.students_module.presentation.states

import com.example.odsas.students_module.domain.model.BookingItemModel

data class BookingState(
    val isLoading: Boolean = false,
    val bookingList: List<BookingItemModel>? = null,
    val error: String = ""
)