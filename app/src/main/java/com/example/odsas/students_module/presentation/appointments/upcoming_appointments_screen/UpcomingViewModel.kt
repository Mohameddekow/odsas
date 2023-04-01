package com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odsas.commons.BOOKED_DATE_TIME_ROOT_REF
import com.example.odsas.commons.BOOKING_APPOINTMENT_ROOT_REF
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.presentation.appointments.SharedViewModel
import com.example.odsas.students_module.presentation.states.BookedDateAndTimeState
import com.example.odsas.students_module.presentation.states.BookingState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class UpcomingViewModel
@Inject
constructor(
    private val repository: UpcomingRepository,
): ViewModel() {


    private val _bookingListState = mutableStateOf(BookingState())
    val bookingListState: State<BookingState> = _bookingListState

    private val _bookedDateAndTimeState = mutableStateOf(BookedDateAndTimeState())
    val bookedDateAndTimeState: State<BookedDateAndTimeState> = _bookedDateAndTimeState

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    init {
        getAllBookings(
            auth.currentUser?.uid!!,
            BOOKING_APPOINTMENT_ROOT_REF
        )

        getAllBookedDateAndTime(
            auth.currentUser?.uid!!,
            BOOKED_DATE_TIME_ROOT_REF
        )
    }

    //fetch all tasks
    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllBookings(
        userId: String,
        bookingRootRef: String
    ){
        viewModelScope.launch (){

            val result =  repository.getAllBookings(userId, bookingRootRef)

            result.collect(){ res ->
                when (res) {
                    is Resource.Success -> {
                        _bookingListState.value = BookingState(bookingList = res.data)

                        Log.d("Notifix Ve", res.data.toString())

                    }
                    is Resource.Error -> {
                        _bookingListState.value = BookingState(error = res.errorMessage.toString())
                    }
                    is Resource.Loading -> {
                        _bookingListState.value = BookingState(isLoading = true)
                    }
                }
            }
        }
    }






    //  //fetch all booked dates and time
    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllBookedDateAndTime(
        userId: String,
        bookedDateTimeRootRef: String
    ){
        viewModelScope.launch (){

            val result =  repository.getAllBookedDateAndTime(userId, bookedDateTimeRootRef)

            result.collect(){ res ->
                when (res) {
                    is Resource.Success -> {
                        _bookedDateAndTimeState.value = BookedDateAndTimeState(bookedDateAndTimeList = res.data)

                        Log.d("Notifix Ve", res.data.toString())

                    }
                    is Resource.Error -> {
                        _bookedDateAndTimeState.value = BookedDateAndTimeState(error = res.errorMessage.toString())
                    }
                    is Resource.Loading -> {
                        _bookedDateAndTimeState.value = BookedDateAndTimeState(isLoading = true)
                    }
                }
            }
        }
    }




}