package com.example.odsas.students_module.presentation.home_screen
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odsas.commons.BOOKING_APPOINTMENT_ROOT_REF
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.presentation.states.BookingState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val repository: HomeRepository
): ViewModel() {

    private val _fetchingTasksState: MutableLiveData<Resource<List<BookingItemModel>>> = MutableLiveData()
    val fetchingTasksState: LiveData<Resource<List<BookingItemModel>>> get() = _fetchingTasksState

    private val _bookingListState = mutableStateOf(BookingState())
    val bookingListState: State<BookingState> = _bookingListState

    private val _allAppointmentAnalysisListState = mutableStateOf(BookingState())
    val allAppointmentAnalysisListState: State<BookingState> = _allAppointmentAnalysisListState

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    init {
        getAllBookings(
            auth.currentUser?.uid!!,
            BOOKING_APPOINTMENT_ROOT_REF
        )
        getAllAppointmentAnalysis(
            auth.currentUser?.uid!!,
            BOOKING_APPOINTMENT_ROOT_REF
        )
    }

    //fetch all booked appointment
    fun getAllBookings(
        userId: String,
        bookingRootRef: String
    ){
        viewModelScope.launch (){

            val result =  repository.getAllBookings(userId, bookingRootRef)

            try {
                result.collect {
                    _fetchingTasksState.postValue(it)
//                    _bookingListState.value = BookingState(bookingList = it)
                }

            }catch (e: Exception){
                // Resource.Error(e, null)
               // _fetchingTasksState.postValue(Resource.Error(e.message.toString(), null))
                _bookingListState.value = BookingState(error = e.message.toString())
            }

            result.collect(){ res ->
                when (res) {
                    is Resource.Success -> {
                        _bookingListState.value = BookingState(bookingList = res.data)

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


    //fetch all booked appointment
    fun getAllAppointmentAnalysis(
        userId: String,
        bookingRootRef: String
    ){
        viewModelScope.launch (){

            val result =  repository.getAllAppointmentAnalysis(userId, bookingRootRef)

            try {
                result.collect {
                    _fetchingTasksState.postValue(it)
//                    _bookingListState.value = BookingState(bookingList = it)
                }

            }catch (e: Exception){
                // Resource.Error(e, null)
               // _fetchingTasksState.postValue(Resource.Error(e.message.toString(), null))
                _allAppointmentAnalysisListState.value = BookingState(error = e.message.toString())
            }

            result.collect(){ res ->
                when (res) {
                    is Resource.Success -> {
                        _allAppointmentAnalysisListState.value = BookingState(bookingList = res.data)

                    }
                    is Resource.Error -> {
                        _allAppointmentAnalysisListState.value = BookingState(error = res.errorMessage.toString())
                    }
                    is Resource.Loading -> {
                        _allAppointmentAnalysisListState.value = BookingState(isLoading = true)
                    }
                }
            }
        }
    }


}