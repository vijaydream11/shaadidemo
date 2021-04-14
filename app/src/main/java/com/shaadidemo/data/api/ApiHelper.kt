package com.shaadidemo.data.api

import com.shaadidemo.domain.model.InboxResponse
import io.reactivex.Single

interface ApiHelper {

    fun getUserList(result: String): Single<InboxResponse>
}