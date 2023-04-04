package com.example.odsas.students_module.presentation.appointments.successful_appointment_screen
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.odsas.commons.Resource
import com.example.odsas.commons.convertDateAndTimeToMilliseconds
import com.example.odsas.commons.getCurrentDate
import com.example.odsas.commons.getCurrentTime
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject


class SuccessfulRepository
@Inject
constructor(
    private val fireStoreDb: FirebaseFirestore
){

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getAllBookings(
        userId: String,
        bookingRootRef: String
    ): Flow<Resource<List<BookingItemModel>>> = flow{
        emit(Resource.Loading(null))

        val currentDate = getCurrentDate()
        val currentTime = getCurrentTime()

        val currentDateInMilliseconds = convertDateAndTimeToMilliseconds(mDateAndTime = "${getCurrentDate()} ${getCurrentTime()}")

        Log.d("timz", currentTime)
        try {

            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
                .orderBy("dateInMilliseconds", Query.Direction.DESCENDING)//order by date
                .whereLessThan("dateInMilliseconds", currentDateInMilliseconds.toLong())
                .get()
                .await()

//            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
//                .orderBy("date", Query.Direction.DESCENDING)//order by date
//                .whereLessThan("date", currentDate)//show booking b4 today
////                .orderBy("time", Query.Direction.ASCENDING)//order by time
////                .whereLessThan("time", currentTime)//show booking b4 this exact time
//                .get()
//                .await()

            val retrievedTasks = snapshots.toObjects(BookingItemModel::class.java)

            Log.d("succ test", retrievedTasks.toString())
            emit(Resource.Success(retrievedTasks))

        }catch (e: Exception){
            emit(Resource.Error(e.message.toString(), null))
        }

    }

}