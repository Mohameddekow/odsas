package com.example.odsas.students_module.presentation.book_appointment_screen.componets
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odsas.R
import com.example.odsas.students_module.presentation.notification_screen.NotificationItem
import com.example.odsas.ui.theme.CustomBlue
import java.util.*


// Creating a composable function to
// create two Images and a spacer between them
// Calling this function as content
// in the above function
@Composable
fun MyCalender(){
 
    // Fetching the Local Context
    val mContext = LocalContext.current
   
    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int
 
    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()
 
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
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )


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
                    contentDescription = "desc",
                    tint = CustomBlue,
                    modifier = Modifier.size(20.dp).padding(start = 0.dp)
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