package com.example.odsas.students_module.presentation.profile_screen
import android.net.Uri
import android.util.Log
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class ProfileRepository
@Inject
constructor(
    private val firebaseStorage: FirebaseStorage,
    private val auth: FirebaseAuth,
    private val fireStoreDb: FirebaseFirestore
) {


    //fetch user details
//    suspend fun fetchUserDetails(
//        userPathRef: String,
//        userId: String
//    ): Flow<Resource<UserModel>> = flow{
//
////        delay(1000) //delayed for testing only
//
//      try {
//          //start the ui with loading
//          emit(Resource.Loading(null))
//
//
//          //get the snapshot from fireStore
//          val snapshot = fireStoreDb.collection(userPathRef).document(userId)
//              .get()
//              .await()
//
//          //change to object
//          val userDetails = snapshot.toObject(UserModel::class.java)
//
//          Log.d("TAG", "getUserDet: ${userDetails}")
//
//          //emit it to ui as success
//          emit(Resource.Success(userDetails!!))
//      }catch (e: Exception){
//          emit(Resource.Error(e.message.toString(), null))
//      }
//
//
//    }

    //fetch user details
    suspend fun fetchUserDetails(
        userPathRef: String,// = "user_students",
        userId: String,// = "crzL4anJO0bink41bvNGSNEZXfn2"
    ): Flow<Resource<UserModel>> = flow{

//        delay(1000) //delayed for testing only

        try {
            //start the ui with loading
            emit(Resource.Loading(null))


            //get the snapshot from fireStore
            val snapshot = fireStoreDb.collection(userPathRef).document(userId)
                .get()
                .await()

            //change to object
            val userDetails = snapshot.toObject(UserModel::class.java)

            Log.d("TAG", "getUserDet: $userDetails")

            //emit it to ui as success
            emit(Resource.Success(userDetails!!))
        }catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }


    }
}
