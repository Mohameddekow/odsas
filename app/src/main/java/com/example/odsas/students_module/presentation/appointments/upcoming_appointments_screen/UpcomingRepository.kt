package com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.odsas.commons.*
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.*
import javax.inject.Inject


class UpcomingRepository
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

        val currentDateInMilliseconds = convertDateAndTimeToMilliseconds(mDateAndTime = "${getCurrentDate()} ${getCurrentTime()}")
        val currentTime = getCurrentTime()




        try {

            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
                .whereGreaterThan("dateInMilliseconds", currentDateInMilliseconds.toLong())
                .get()
                .await()

            val retrievedTasks = snapshots.toObjects(BookingItemModel::class.java)

            emit(Resource.Success(retrievedTasks))

        }catch (e: Exception){
            emit(Resource.Error(e.message.toString(), null))
        }

    }

}