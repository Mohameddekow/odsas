package com.example.odsas.students_module.presentation.appointments.delete_appointment
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.presentation.states.BookingState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DeleteAppointmentsViewModel
@Inject
constructor(
    private val  repository: DeleteAppointmentsRepository
): ViewModel() {

    private val _updateBookedAppointmentState = mutableStateOf(BookingState())
    val updateBookedAppointmentState: State<BookingState> = _updateBookedAppointmentState

    val auth: FirebaseAuth = FirebaseAuth.getInstance()


    //update user profile name only
    fun deleteAppointment(
        userId: String,
        bookingRootRef: String,
        creationTimeMs: Long
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result =
                repository.deleteAppointment(userId, bookingRootRef,creationTimeMs)

//            try {
//                result.collect {
//                    _appointmentListState.postValue(it)
//                }
//            }catch (e: Exception){
//                _appointmentListState.postValue(Resource.Error(e))
//            }

            result.collect() { res ->
                when (res) {
                    is Resource.Success -> {
//                        _updateBookedAppointmentState.value = BookingState(bookingList = res.data)

                        Log.d("update booked Ve", res.data.toString())

                    }
                    is Resource.Error -> {
                        _updateBookedAppointmentState.value =
                            BookingState(error = res.errorMessage.toString())
                    }
                    is Resource.Loading -> {
                        _updateBookedAppointmentState.value = BookingState(isLoading = true)
                    }


                }
            }
        }


    }

}