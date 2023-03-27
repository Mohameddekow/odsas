package com.example.odsas.students_module.presentation.book_appointment_screen
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.presentation.states.BookingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BookingViewModel
@Inject
constructor(
    private val repository: BookingRepository
): ViewModel(){

    private val _addingBookingState: MutableLiveData<Resource<Void?>> = MutableLiveData()
    val addingBookingState: LiveData<Resource<Void?>> get() = _addingBookingState


    private val _bookingListState = mutableStateOf(BookingState())
    val bookingListState: State<BookingState> = _bookingListState


    fun addBookingToFireStore(
        reason: String,
        date: String,
        time: String,
        desc: String,
        userId: String,
        bookingRootRef: String,
    ){
        viewModelScope.launch(Dispatchers.IO){
            val result = repository.addBookingToFireStore(reason, date, time, desc, userId, bookingRootRef)

            _bookingListState.value = BookingState(isLoading = true)
            try {
                result.collect {
                    _addingBookingState.postValue(it)
                }
            }catch (e: Exception){
                _addingBookingState.postValue(Resource.Error(e.message.toString()))
                _bookingListState.value = BookingState(error = e.message.toString())

            }
        }
    }



}