package com.republictvdemo.data.api.retrofit

import com.republictvdemo.RepublicTVApplication
import com.republictvdemo.data.api.ApiHelper
import com.republictvdemo.data.api.retrofit.entity.UserListResponse
import io.reactivex.Single

class RetrofitManager(
    private var networkAPI: NetworkAPI = RepublicTVApplication.dataComponent.getNetworkApi()
) : ApiHelper {
    override fun getUserList(pageNo: Int): Single<UserListResponse> {
        return networkAPI.getUserList(pageNo)
    }

}