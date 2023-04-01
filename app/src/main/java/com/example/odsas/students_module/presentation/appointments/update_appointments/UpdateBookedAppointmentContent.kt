package com.example.odsas.students_module.presentation.appointments.update_appointments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.odsas.R
import com.example.odsas.commons.BOOKING_APPOINTMENT_ROOT_REF
import com.example.odsas.commons.convertDateAndTimeToMilliseconds
import com.example.odsas.commons.getCurrentTime
import com.example.odsas.students_module.domain.model.DropDownItemsModel
import com.example.odsas.students_module.presentation.appointments.SharedViewModel
import com.example.odsas.students_module.presentation.screens.Screens
import com.example.odsas.ui.theme.CustomBlue
import com.example.odsas.ui.theme.CustomWhite
import com.google.firebase.auth.FirebaseAuth
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BookingContent(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val reasons = listOf<DropDownItemsModel>(
        DropDownItemsModel("Exams"),
        DropDownItemsModel("Fees"),
        DropDownItemsModel("De registration"),
        DropDownItemsModel("Consultation"),
        DropDownItemsModel("Others"),
    )

    val bookedAppointmentDetails = sharedViewModel.bookedAppointmentDetails

    val context = LocalContext.current

//@TODO Reason for appointment******** Start

    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mReasons = reasons // listOf<MyItems>() //listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            readOnly = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(CustomBlue),
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 4.dp)
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },

            label = {Text("Reason for appointment")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier
                        .clickable { mExpanded = !mExpanded }
                        .size(40.dp), tint = CustomBlue)
            },
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){mTextFieldSize.width.toDp()})
        ) {
            mReasons.forEach { label ->
                DropdownMenuItem(onClick = {
                    mSelectedText = label.title
                    mExpanded = false
                }) {
                    Text(text = label.title)
                }
            }
        }


    }

//@TODO Reason for appointment******** Ends

// @TODO Calender******** Start
    Spacer(modifier = Modifier.height(20.dp))

    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

//    DATE_FORMAT_7 = EEE, MMM d, ''yy
//    The output will be -: Wed, Dec 5, '18
//    val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")// HH:mm:ss")
//    var y = ""
//    var m = ""
//    var d =""
//    val date = LocalDate.parse("$y-$m-$d 09:00:00",firstApiFormat)//"2019-08-07 09:00:00" , firstApiFormat)



    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->

           // y = mYear.toString(); m = mMonth.toString(); d = mDate.toString()

            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"

        }, mYear, mMonth, mDay
    )


    //date picker container
    Card(elevation = 10.dp, modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 1.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(elevation = 5.dp, modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .fillMaxWidth()
                .clickable {
                    mDatePickerDialog.show()

                }) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text ="Please select a date",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )

                    IconButton(
                        onClick = { mDatePickerDialog.show() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.calendar),
                            contentDescription = "calender",
                            tint = CustomBlue,
                            modifier = Modifier
                                .size(20.dp)
                                .padding(start = 0.dp)
                        )
                    }
                }
            }



            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Spacer(modifier = Modifier.size(5.dp))

                Text(
                    text = "Selected date: ${mDate.value}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 7.dp),
                    color = CustomBlue
                )

                // Adding a space of 100dp height
                Spacer(modifier = Modifier.size(10.dp))

            }


        }

    }

//@TODO Calender********  Ends

//@TODO Time Picker********  Start
    Spacer(modifier = Modifier.height(20.dp))

//    // Fetching local context
//    val mContext = LocalContext.current
//
//    // Declaring and initializing a calendar
//    val mCalendar = Calendar.getInstance()

    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    // Value for storing time as a string
    val mTime = remember { mutableStateOf("") }


    val currentTime = getCurrentTime()
    // Creating a TimePicker dialog
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            val selectedTime = "$mHour:$mMinute"
            if (selectedTime < currentTime){
                Toast.makeText(context, "Please select upcoming time", Toast.LENGTH_LONG).show()

            }else{
                mTime.value = "$mHour:$mMinute"
            }
        }, mHour, mMinute, false
    )

    //time container Card
    Card(elevation = 10.dp, modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 1.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(elevation = 5.dp, modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .fillMaxWidth()
                .clickable {
                    mTimePickerDialog.show()

                }) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text ="Please select the time",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )

                    IconButton(
                        onClick = { mTimePickerDialog.show() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.time_fast),
                            contentDescription = "calender",
                            tint = CustomBlue,
                            modifier = Modifier
                                .size(20.dp)
                                .padding(start = 0.dp)
                        )
                    }
                }
            }


            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Spacer(modifier = Modifier.size(5.dp))

                Text(
                    text = "Selected time: ${mTime.value}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 7.dp),
                    color = CustomBlue
                )

                // Adding a space of 100dp height
                Spacer(modifier = Modifier.size(10.dp))

            }
        }

    }



//@TODO Time Picker********  Ends

//@TODO Description ********  Start

    Spacer(modifier = Modifier.height(20.dp))

    var desc by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .padding(vertical = 0.dp, horizontal = 3.dp)
            .fillMaxWidth()
            .shadow(1.dp, shape = RoundedCornerShape(0.dp)),

        value = desc,
        onValueChange = {
            desc = it
        },
        placeholder = {
            Text(
                modifier = Modifier,
                text = "Description",
                color = Color.Black
            )
        },
        textStyle = TextStyle(
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        ),
        singleLine = true,
        leadingIcon = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.note),
                    contentDescription = "desc",
                    tint = CustomBlue,
                    modifier = Modifier.size(20.dp)
                )
            }
        } ,
        trailingIcon = {
            IconButton(
                onClick = {
                    desc = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "close icon",
                    tint = Color.Black
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                //search a user
//                navController.navigate(
//                    (Screens.UserDetailsScreen.route + "/$userName")
//                )
            }
        )

    )



    Spacer(modifier = Modifier.height(20.dp))

//    val bookingViewModel: BookingViewModel = hiltViewModel()
//    val notificatiomViewModel: NotificationViewModel = hiltViewModel()

    val updateBookedAppointmentViewModel: UpdateBookedAppointmentsViewModel = hiltViewModel()
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    Box(modifier = Modifier
        .padding(1.dp, 0.dp, 1.dp, 0.dp)
        .fillMaxWidth()) {
        Button(
            onClick = {

                //book
                val userId = auth.currentUser?.uid
                val reason = mSelectedText
                val date =  mDate.value //normal date 1/2/2022
                val dateInMilliseconds = convertDateAndTimeToMilliseconds(mDateAndTime = "${mDate.value} ${mTime.value}") //convert to milliseconds
                val time = mTime.value
                val desc = desc

//                val state = bookingViewModel.bookingListState.value
                val state = updateBookedAppointmentViewModel.updateBookedAppointmentState.value

                //val remainderTime = getTime()

                if (userId != null) {

                    //update appointment
                    bookedAppointmentDetails?.creationTimeMs?.let {
                        updateBookedAppointmentViewModel.updateAppointment(
                            reason = reason,
                            date = date,
                            time = time,
                            desc = desc,
                            dateInMilliseconds = dateInMilliseconds,
                            userId = userId,
                            bookingRootRef = BOOKING_APPOINTMENT_ROOT_REF,
                            creationTimeMs = it
                        )
                    }

//                    bookedAppointmentDetails?.creationTimeMs?.let {
//                        updateBookedAppointmentViewModel.updateAppointment(
//                            reason,
//                            date,
//                            dateInMilliseconds,
//                            time,
//                            desc,
//                            userId,
//                            BOOKING_APPOINTMENT_ROOT_REF,
//                            it
//                        )
//                    }

                }


                Toast.makeText(context, "Booked", Toast.LENGTH_SHORT).show()

                navController.navigate(Screens.HomeScreen.route) {
                    popUpTo(Screens.HomeScreen.route) {
                        inclusive = true
                    }
                }








            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp) ,
            colors = ButtonDefaults.buttonColors(CustomBlue),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Book appointment", color = CustomWhite)
        }
    }

//@TODO Description ********  Ends

}