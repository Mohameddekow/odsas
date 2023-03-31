package com.example.odsas.students_module.presentation.appointments.update_appointments
import android.util.Log
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class UpdateBookedAppointmentsRepository
@Inject
constructor(
    private val firebaseStorage: FirebaseStorage,
    private val auth: FirebaseAuth,
    private val fireStoreDb: FirebaseFirestore
) {


    //update user profile name only
    suspend fun updateAppointment(
        reason: String,
        date: String,
        dateInMilliseconds: Long,
        time: String,
        desc: String,
        userId: String,
        bookingRootRef: String,
        creationTimeMs: Long

    ): Flow<Resource<Void?>> = flow{


        emit(Resource.Loading(null))

        var taskResult: Void? = null
        var errorMsg: Exception? = null

        try {

            val snapshots = fireStoreDb.collection(bookingRootRef)
                .document(userId)
                .collection(userId)

            snapshots
                .whereEqualTo("creationTimeMs" ,creationTimeMs )
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {


                        for (document in task.result) {
    //                        val update: MutableMap<String, Any> = HashMap()
    //                        update["x"] = 0

                            snapshots.document(document.id)//.set(update, SetOptions.merge())
                                .set(BookingItemModel(reason,date, dateInMilliseconds, time, desc, System.currentTimeMillis()))

                        }
                    }
            }

        }catch (e: Exception){
            emit(Resource.Error(e.message.toString(),null))
        }

    }//.flowOn( Dispatchers.IO )

}
