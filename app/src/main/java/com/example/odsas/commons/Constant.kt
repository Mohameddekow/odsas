package com.example.odsas.commons

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.odsas.R
import com.example.odsas.students_module.domain.model.BottomNavigationMenuItemModel
import com.google.firebase.auth.FirebaseAuth

const val NOTIFICATION_ROOT_REF = "notifications"
const val BOOKING_APPOINTMENT_ROOT_REF = "booking_appointment"
const val BOOKED_DATE_TIME_ROOT_REF = "booked_date_time"

const val PICK_IMAGE_CODE = 1234

const val TASK_ROOT_REF = "tasks"
const val USERS_ROOT_REF = "user_students"

val userId: String = FirebaseAuth.getInstance().currentUser!!.uid

val menuItems = if (userId == "k1iKECY65ChCW8tYifazvMPz2zZ2"){
    listOf(
        BottomNavigationMenuItemModel(title = "home", iconId = R.drawable.home),
        //BottomNavigationMenuItemModel(title = "book appointment", iconId = R.drawable.book_appointment),
        BottomNavigationMenuItemModel(title = "analysis", iconId = R.drawable.analysis)
    )
}else {
    listOf(
        BottomNavigationMenuItemModel(title = "home", iconId = R.drawable.home),
        BottomNavigationMenuItemModel(title = "book appointment", iconId = R.drawable.book_appointment),
        //BottomNavigationMenuItemModel(title = "analysis", iconId = R.drawable.analysis)
    )
}








@Composable
fun CustomDialog(
    showDialog: MutableState<Boolean>,
    onPerformAction: () -> Unit,
    onDismissAction: () -> Unit,
) {
    Dialog(
        onDismissRequest = { showDialog.value = false }) {
        CustomDialogUI(
            showDialog = showDialog,
            onPerformAction = onPerformAction,
            onDismissAction = onDismissAction,
        )
    }


}


//Layout
@Composable
fun CustomDialogUI(
    modifier: Modifier = Modifier,
    showDialog: MutableState<Boolean>,
    onPerformAction: () -> Unit,
    onDismissAction: () -> Unit,

    ){
    Card(
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(10.dp),
        // modifier = modifier.size(280.dp, 240.dp)
        modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .background(Color.White)) {

            //.......................................................................


            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Booking Error",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.h5,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text =  "This date and time had already been booked please select a different date and time",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 3.dp, end = 3.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.subtitle1
                )
            }
            //.......................................................................
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(Color.Blue.copy(0.6f)),
                horizontalArrangement = Arrangement.SpaceAround) {

                TextButton(
                    modifier = Modifier.weight(0.5f),
                    onClick = {
                        //dismiss the dialog
                        onDismissAction()

                        showDialog.value = false
                    }) {

                    Text(
                        "Cancel",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red ,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
                TextButton(
                    modifier = Modifier.weight(0.5f),
                    onClick = {
                        //perform action
                        onPerformAction()

                        showDialog.value = false
                    }) {
                    Text(
                        "Ok",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleAlertDialog() {
    AlertDialog(
        onDismissRequest = { },
        confirmButton = {
            TextButton(onClick = {})
            { Text(text = "OK") }
        },
        dismissButton = {
            TextButton(onClick = {})
            { Text(text = "Cancel") }
        },
        title = { Text(text = "Already Booked date and time",textAlign = TextAlign.Center) },
        text = { Text(text = "This date and time had already been booked \n please select a different date and time", textAlign = TextAlign.Center) }
    )
}


fun convertDateAndTimeToMilliseconds(mDateAndTime: String,): Long {
    var date = Date()
//    val formatter = SimpleDateFormat("dd/MM/yyyy")
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm")
    try {
        date = formatter.parse(mDateAndTime)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return date.time;
}

@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentDate(): String {
    val current = LocalDate.now()
    val y = current.year
    val m = current.monthValue
    val d = current.dayOfMonth

    return "$d/$m/$y}"
}
@RequiresApi(Build.VERSION_CODES.O)
fun getCurrentTime(): String {
    val current = LocalTime.now()
    val h = current.hour
    val m = current.minute
    val s = current.second

    return "$h:$m"
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