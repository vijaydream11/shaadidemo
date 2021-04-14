package com.shaadidemo.view.viewmodel

import com.shaadi.assignment.data.local.db.typeconverters.UserStatus
import com.shaadidemo.presentation.utility.UtilsMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListViewModel : BaseViewModel() {

    val userLiveData = dataRepository.getAll()

    fun getUserList() {
        compositeDisposable.add(
            dataRepository.fetchInboxList("10")
                .map { userDTOList ->
                    UtilsMapper.mapList(userDTOList)
                }
                .flatMap { inboxUsers ->
                    dataRepository.saveInboxList(inboxUsers)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe()
        )
    }

    fun updateUserStatus(userStatus: UserStatus, id: Long) {
        compositeDisposable.add(
            dataRepository.setUserStatus(userStatus, id)
                .subscribeOn(Schedulers.io())
                .subscribe()
        )
    }

}