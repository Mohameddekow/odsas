package com.example.odsas.commons

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDate

const val NOTIFICATION_ROOT_REF = "notifications"
const val BOOKING_APPOINTMENT_ROOT_REF = "booking_appointment"

const val PICK_IMAGE_CODE = 1234

const val TASK_ROOT_REF = "tasks"
const val USERS_ROOT_REF = "user_students"

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentTime(): String {
    val current = LocalDate.now()
    val y = current.year
    val m = current.monthValue
    val d = current.dayOfMonth

    return "$d-$m-$y"
}



class Time(internal var hours: Int, internal var minutes: Int, internal var seconds: Int)

//fun main(args: Array<String>) {
//    val start = Time(12, 34, 55)
//    val stop = Time(8, 12, 15)
//    val diff: Time
//
//    diff = difference(start, stop)
//
//    print("TIME DIFFERENCE: ${start.hours}:${start.minutes}:${start.seconds} - ")
//    print("${stop.hours}:${stop.minutes}:${stop.seconds} ")
//    print("= ${diff.hours}:${diff.minutes}:${diff.seconds}")
//}

fun getTimeDifference(start: Time, stop: Time): Time {
    val diff = Time(0, 0, 0)

    if (stop.seconds > start.seconds) {
        --start.minutes
        start.seconds += 60
    }

    diff.seconds = start.seconds - stop.seconds
    if (stop.minutes > start.minutes) {
        --start.hours
        start.minutes += 60
    }

    diff.minutes = start.minutes - stop.minutes

    diff.hours = start.hours - stop.hours

    return diff
}