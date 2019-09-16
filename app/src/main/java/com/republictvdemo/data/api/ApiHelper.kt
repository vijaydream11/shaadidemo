package com.republictvdemo.data.api

import com.republictvdemo.data.api.retrofit.entity.UserListResponse
import io.reactivex.Single

interface ApiHelper {

    fun getUserList(result: Int): Single<UserListResponse>
}