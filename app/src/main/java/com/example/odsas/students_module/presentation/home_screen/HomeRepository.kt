package com.example.odsas.students_module.presentation.home_screen
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


class HomeRepository
@Inject
constructor(
    private val fireStoreDb: FirebaseFirestore
){

    suspend fun getAllBookings(
        userId: String,
        bookingRootRef: String
    ): Flow<Resource<List<BookingItemModel>>> = flow{
        emit(Resource.Loading(null))

        val currentDateInMilliseconds = convertDateAndTimeToMilliseconds(mDateAndTime = "${getCurrentDate()} ${getCurrentTime()}")

        try {

//            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
//                .orderBy("date", Query.Direction.ASCENDING)
//                .get()
//                .await()

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


    suspend fun getAllAppointmentAnalysis(
        userId: String,
        bookingRootRef: String
    ): Flow<Resource<List<BookingItemModel>>> = flow{
        emit(Resource.Loading(null))

        val currentDateInMilliseconds = convertDateAndTimeToMilliseconds(mDateAndTime = "${getCurrentDate()} ${getCurrentTime()}")

        try {

//            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
//                .orderBy("date", Query.Direction.ASCENDING)
//                .get()
//                .await()

            val snapshots = fireStoreDb.collection(bookingRootRef).document(userId).collection(userId)
                .orderBy("dateInMilliseconds", Query.Direction.ASCENDING)//order by date
                //.whereGreaterThan("dateInMilliseconds", currentDateInMilliseconds.toLong())
                .get()
                .await()

            val retrievedTasks = snapshots.toObjects(BookingItemModel::class.java)

            emit(Resource.Success(retrievedTasks))

        }catch (e: Exception){
            emit(Resource.Error(e.message.toString(), null))
        }

    }

}