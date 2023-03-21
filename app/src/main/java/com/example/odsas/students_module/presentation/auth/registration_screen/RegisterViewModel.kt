package com.example.odsas.students_module.presentation.auth.registration_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: RegisterRepository
) : ViewModel() {

    //listen for the auth state and registration state
    var firestoreRegState : MutableLiveData<String> = repository._firestoreRegState

    fun registerUser(
        userEmail: String,
        userPassword: String,
        usersRootRef: String,
    ): Task<AuthResult> {
        return repository.registerUser(userEmail, userPassword, usersRootRef)
    }


}