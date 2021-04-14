package com.shaadidemo.domain

import androidx.lifecycle.LiveData
import com.shaadidemo.ShaadiApplication
import com.shaadidemo.domain.model.Result
import com.shaadi.assignment.data.local.db.entity.InboxUser
import com.shaadi.assignment.data.local.db.typeconverters.UserStatus
import io.reactivex.Single

class DataRepository {

    private val networkAPI = ShaadiApplication.dataComponent.getNetworkApi()
    private val databaseService = ShaadiApplication.dataComponent.getDatabaseService()

    fun fetchInboxList(count: String): Single<List<Result>> =
        networkAPI.getUserList(count).map {
            it.results
        }

    fun saveInboxList(inboxList: List<InboxUser>): Single<List<Long>> {
        return databaseService.inboxUserDao().insert(inboxList)
    }

    fun getAll(): LiveData<List<InboxUser>> =
        databaseService.inboxUserDao().getAll()

    fun setUserStatus(userStatus: UserStatus, id: Long) =
        databaseService.inboxUserDao().updateUserStatus(userStatus, id)

}