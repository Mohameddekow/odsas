package com.example.odsas.students_module.presentation.auth.registration_screen
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.odsas.students_module.domain.model.UserModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RegisterRepository
@Inject constructor(
    private var auth: FirebaseAuth,
    private var firebaseFirestoreDb: FirebaseFirestore // constructor injection
) {

//    //use field inject
//    @Inject
//    lateinit var auth: FirebaseAuth //
//



    var _firestoreRegState: MutableLiveData<String> = MutableLiveData()

    fun registerUser(
        userName: String,
        regNum: String,
        userEmail: String,
        userPassword: String,
        usersRootRef: String,
    ): Task<AuthResult> {

          return  auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        //add to user firestore
                        if (task.isSuccessful){
                            val uid = auth.currentUser?.uid

                            if (uid != null) {

                                //add the registered user to  firestore
                                firebaseFirestoreDb.collection(usersRootRef).document(uid)
                                    .set(UserModel(userName,regNum, userEmail, userPassword)).addOnCompleteListener {
                                        if (task.isSuccessful) {
                                            Log.d("added to fireStore:", task.isSuccessful.toString())

//                                    _firestoreRegState.value = "adding user to firestore is: ${task.isSuccessful.toString()}"

                                        } else {
                                            _firestoreRegState.postValue("registration failed due to: ${task.exception?.message}")
                                        }
                                    }
                            }
                        }

//                        val currentUser = auth.currentUser
//                        currentUser?.sendEmailVerification()?.addOnCompleteListener { task ->
//
//                            //check if email sending was success then add his details to fireStore
//                            if (task.isSuccessful){
//                                val uid = auth.currentUser?.uid
//
//                                if (uid != null) {
//
//                                    //add the registered user to  firestore
//                                    firebaseFirestoreDb.collection(usersRootRef).document(uid)
//                                        .set(UserModel(userEmail, userPassword)).addOnCompleteListener {
//                                            if (task.isSuccessful) {
//                                                Log.d("added to fireStore:", task.isSuccessful.toString())
//
////                                    _firestoreRegState.value = "adding user to firestore is: ${task.isSuccessful.toString()}"
//
//                                            } else {
//                                                _firestoreRegState.postValue("registration failed due to: ${task.exception?.message}")
//                                            }
//                                        }
//                                }
//                            }
//
//                        }



                    }
                }

    }
}
