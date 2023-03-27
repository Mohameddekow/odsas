package com.example.odsas.students_module.presentation.notification_screen
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odsas.commons.BOOKING_APPOINTMENT_ROOT_REF
import com.example.odsas.commons.NOTIFICATION_ROOT_REF
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.presentation.states.BookingState
import com.example.odsas.students_module.presentation.states.NotificationState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NotificationViewModel
@Inject
constructor(
    private val repository: NotificationRepository
): ViewModel(){

    private val _addingNotificationState: MutableLiveData<Resource<Void?>> = MutableLiveData()
    val addingNotificationState: LiveData<Resource<Void?>> get() = _addingNotificationState


    private val _bookingListState = mutableStateOf(NotificationState())
    val bookingListState: State<NotificationState> = _bookingListState

    private val _fetchingTasksState: MutableLiveData<Resource<List<BookingItemModel>>> = MutableLiveData()
    val fetchingTasksState: LiveData<Resource<List<BookingItemModel>>> get() = _fetchingTasksState

    private val _notificationListState = mutableStateOf(NotificationState())
    val notificationListState: State<NotificationState> = _notificationListState

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    init {
        getAllNotifications(
            auth.currentUser?.uid!!,
            NOTIFICATION_ROOT_REF
        )
    }


    fun addNotificationToFireStore(
        date: String,
        time: String,
        userId: String,
        notificationRootRef: String,
        currentTimeMillis: Long,
    ){
        viewModelScope.launch(Dispatchers.IO){
            val result = repository.addNotificationToFireStore(date, time, userId, notificationRootRef,currentTimeMillis)

            _bookingListState.value = NotificationState(isLoading = true)
            try {
                result.collect {
                    _addingNotificationState.postValue(it)
                }
            }catch (e: Exception){
                _addingNotificationState.postValue(Resource.Error(e.message.toString()))

                _bookingListState.value = NotificationState(error = e.message.toString())

            }
        }
    }



    //fetch all tasks
    fun getAllNotifications(
        userId: String,
        notificationRootRef: String
    ){
        viewModelScope.launch (){

            val result =  repository.getAllNotification(userId, notificationRootRef)

//            try {
//                result.collect {
//                    _fetchingTasksState.postValue(it)
////                    _bookingListState.value = BookingState(bookingList = it)
//                }
//
//            }catch (e: Exception){
//                // Resource.Error(e, null)
//               // _fetchingTasksState.postValue(Resource.Error(e.message.toString(), null))
//                _bookingListState.value = BookingState(error = e.message.toString())
//            }

            result.collect(){ res ->
                when (res) {
                    is Resource.Success -> {
                        _notificationListState.value = NotificationState(notificationList = res.data)

                    }
                    is Resource.Error -> {
                        _notificationListState.value = NotificationState(error = res.errorMessage.toString())
                    }
                    is Resource.Loading -> {
                        _notificationListState.value = NotificationState(isLoading = true)
                    }
                }
            }
        }
    }



}