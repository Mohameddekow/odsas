package com.example.odsas.students_module.presentation.appointments.upcoming_appointments_screen
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.odsas.commons.*
import com.example.odsas.students_module.domain.model.BookedDateAndTimeItemModel
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
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


        try {

            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
                .orderBy("dateInMilliseconds", Query.Direction.ASCENDING)//order by date
                .whereGreaterThan("dateInMilliseconds", currentDateInMilliseconds.toLong())
                .get()
                .await()

            val retrievedTasks = snapshots.toObjects(BookingItemModel::class.java)

            emit(Resource.Success(retrievedTasks))

        }catch (e: Exception){
            emit(Resource.Error(e.message.toString(), null))
        }

    }



    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getAllBookedDateAndTime(
        userId: String,
        bookedDateTimeRootRef: String
    ): Flow<Resource<List<BookedDateAndTimeItemModel>>> = flow{
        emit(Resource.Loading(null))

        val currentDate = getCurrentDate()


        try {

            val snapshots = fireStoreDb.collection(bookedDateTimeRootRef).document(userId).collection(userId)
                .orderBy("date", Query.Direction.ASCENDING)//order by date
                .whereGreaterThanOrEqualTo("date", currentDate)
                .get()
                .await()

            val retrievedTasks = snapshots.toObjects(BookedDateAndTimeItemModel::class.java)

            emit(Resource.Success(retrievedTasks))

        }catch (e: Exception){
            emit(Resource.Error(e.message.toString(), null))
        }

    }



}