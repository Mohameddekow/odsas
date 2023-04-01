package com.example.odsas.students_module.presentation.book_appointment_screen
import android.util.Log
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookedDateAndTimeItemModel
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class BookingRepository
@Inject
constructor(
    private val fireStoreDb: FirebaseFirestore
){

    suspend fun addBookingToFireStore(
        reason: String,
        date: String,
        dateInMilliseconds: Long,
        time: String,
        desc: String,
        userId: String,
        bookingRootRef: String,
    ): Flow<Resource<Void?>> = flow{

        emit(Resource.Loading(null))

        try {
            var taskResult: Void? = null
            var errorMsg : Exception? = null

            val task = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId) // from taskRet/uid/uid
                .document() //auto generated document ref
                .set(BookingItemModel(reason, date,dateInMilliseconds, time, desc, System.currentTimeMillis()))


            task.addOnSuccessListener {
                taskResult = it
            }.await()

            task.addOnFailureListener {
                errorMsg = it
            }

            Log.d("TAG", "getTaskAdded : ${task.isSuccessful}")

            if (task.isSuccessful){
                emit(Resource.Success(taskResult))
            }else{
                emit(Resource.Error(errorMsg.toString(), null))
            }

        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }

    }



    suspend fun addBookedDateAndTimeToFireStore(
        date: String,
        time: String,
        userId: String,
        bookedDateTimeRootRef: String,
    ): Flow<Resource<Void?>> = flow{

        emit(Resource.Loading(null))

        try {
            var taskResult: Void? = null
            var errorMsg : Exception? = null

            val task = fireStoreDb.collection(bookedDateTimeRootRef).document(userId).collection(userId) // from taskRet/uid/uid
                .document() //auto generated document ref
                .set(BookedDateAndTimeItemModel(date,time))


            task.addOnSuccessListener {
                taskResult = it
            }.await()

            task.addOnFailureListener {
                errorMsg = it
            }

            Log.d("TAG", "getTaskAdded : ${task.isSuccessful}")

            if (task.isSuccessful){
                emit(Resource.Success(taskResult))
            }else{
                emit(Resource.Error(errorMsg.toString(), null))
            }

        }catch (e:Exception){
            emit(Resource.Error(e.message.toString()))
        }

    }

}