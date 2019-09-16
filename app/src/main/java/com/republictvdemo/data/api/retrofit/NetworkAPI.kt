package com.republictvdemo.data.api.retrofit

import com.republictvdemo.data.api.retrofit.entity.UserListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    @GET("api")
    fun getUserList(@Query("results") result: Int): Single<UserListResponse>

}