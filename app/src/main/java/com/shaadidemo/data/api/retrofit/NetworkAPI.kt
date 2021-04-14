package com.shaadidemo.data.api.retrofit

import com.shaadidemo.domain.model.InboxResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    @GET("api")
    fun getUserList(@Query("results") result: String): Single<InboxResponse>

}