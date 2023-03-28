package com.example.odsas.students_module.presentation.profile_screen
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odsas.commons.Resource
import com.example.odsas.commons.USERS_ROOT_REF
import com.example.odsas.students_module.domain.model.UserModel
import com.example.odsas.students_module.presentation.states.NotificationState
import com.example.odsas.students_module.presentation.states.UserState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception


@HiltViewModel
class ProfileViewModel
@Inject
constructor(
    private val  repository: ProfileRepository
): ViewModel() {

    private val _userDetails: MutableLiveData<Resource<UserModel>> = MutableLiveData()
    val userDetails: LiveData<Resource<UserModel>> get() = _userDetails

    private val _userNameUpdatingState: MutableLiveData<Resource<Void?>> = MutableLiveData()
    val userNameUpdatingState: LiveData<Resource<Void?>> get() = _userNameUpdatingState

    private val _updatingAllProfileDetailsState: MutableLiveData<Resource<Void?>> = MutableLiveData()
    val updatingAllProfileDetailsState: LiveData<Resource<Void?>> get() = _updatingAllProfileDetailsState


    private val _userState = mutableStateOf(UserState())
    val userState: State<UserState> = _userState


    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    init {
        fetchUserDetails(
            USERS_ROOT_REF,
            auth.currentUser?.uid!!,
        )
    }


    //fetch user details
    fun fetchUserDetails(
        userPathRef: String,
        userId: String
    ){
        viewModelScope.launch (){

            val result =  repository.fetchUserDetails(userPathRef, userId)

//            try {
//                result.collect {
//                    _userDetails.postValue(it)
//                    _userState.value = UserState(user = it)
//                }
//
//            }catch (e: Exception){
//                // Resource.Error(e, null)
//                _userDetails.postValue(Resource.Error(e.message.toString(), null))
//
//                _userState.value = UserState(error = e.message.toString())
//
//            }


            result.collect(){ res ->
                when (res) {
                    is Resource.Success -> {
                        _userState.value = UserState(user = res.data)
                    }
                    is Resource.Error -> {
                        _userState.value = UserState(error = res.errorMessage.toString())

                    }
                    is Resource.Loading -> {
                        _userState.value = UserState(isLoading = true)

                    }
                }
            }

        }
    }


}
