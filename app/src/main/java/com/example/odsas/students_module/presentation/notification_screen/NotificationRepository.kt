package com.example.odsas.students_module.presentation.notification_screen
import android.util.Log
import com.example.odsas.commons.Resource
import com.example.odsas.students_module.domain.model.BookingItemModel
import com.example.odsas.students_module.domain.model.NotificationItemModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class NotificationRepository
@Inject
constructor(
    private val fireStoreDb: FirebaseFirestore
){

    suspend fun addNotificationToFireStore(
        date: String,
        time: String,
        userId: String,
        notificationRootRef: String,
        currentTimeMillis: Long,
    ): Flow<Resource<Void?>> = flow{

        emit(Resource.Loading(null))

        try {
            var taskResult: Void? = null
            var errorMsg : Exception? = null

            val task = fireStoreDb.collection(notificationRootRef).document(userId).collection(userId) // from taskRet/uid/uid
                .document() //auto generated document ref
                .set(NotificationItemModel(date, time, System.currentTimeMillis()))


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


    suspend fun getAllNotification(
        userId: String,
        notificationRootRef: String
    ): Flow<Resource<List<NotificationItemModel>>> = flow{
        emit(Resource.Loading(null))

        try {

            val snapshots = fireStoreDb.collection(notificationRootRef).document(userId).collection(userId)
                .orderBy("currentTimeMillis", Query.Direction.DESCENDING)
                .get()
                .await()

            val retrievedTasks = snapshots.toObjects(NotificationItemModel::class.java)

            emit(Resource.Success(retrievedTasks))

            Log.d("Notifix Re", retrievedTasks.toString())

        }catch (e:Exception){
            emit(Resource.Error(e.message.toString(), null))
        }

    }
}