package com.example.odsas.students_module.domain.model

data class BookingItemModel(
    val reason: String? = null,
    val date: String? = null,
    var time: String? = null,
    val desc: String? = null,

    val creationTimeMs: Long? = null,
)
