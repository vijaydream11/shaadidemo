package com.shaadidemo.data.api.retrofit

import com.shaadidemo.ShaadiApplication
import com.shaadidemo.data.api.ApiHelper
import com.shaadidemo.domain.model.InboxResponse
import io.reactivex.Single

class RetrofitManager(
    private var networkAPI: NetworkAPI = ShaadiApplication.dataComponent.getNetworkApi()
) : ApiHelper {

    override fun getUserList(pageNo: String): Single<InboxResponse> {
        return networkAPI.getUserList(pageNo)
    }

}