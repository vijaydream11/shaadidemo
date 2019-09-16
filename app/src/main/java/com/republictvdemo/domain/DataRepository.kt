package com.republictvdemo.domain

import com.republictvdemo.RepublicTVApplication
import com.republictvdemo.data.api.retrofit.entity.UserModel
import com.republictvdemo.domain.dto.UserDTO
import io.reactivex.Single

class DataRepository {

    private val apiHelper = RepublicTVApplication.dataComponent.getApiHelper()

    fun getUserList(): Single<ArrayList<UserDTO>> {
        return apiHelper
            .getUserList(10)
            .flatMap { userListResponse ->
                var userDTOList = ArrayList<UserDTO>()
                val userList: ArrayList<UserModel>? = userListResponse.userList
                if (!userList.isNullOrEmpty()) {
                    for (user in userList) {
                        val userDTO = UserDTO()
                        userDTO.userEmail = user.userEmail
                        user.userName?.let {
                            userDTO.firstName = user.userName!!.first
                            userDTO.lastName = user.userName!!.last
                        }

                        user.userLocation?.let {
                            userDTO.street = user.userLocation!!.street
                            userDTO.city = user.userLocation!!.city
                            userDTO.state = user.userLocation!!.state
                            userDTO.postcode = user.userLocation!!.postcode
                        }

                        user.userProfile?.let {
                            userDTO.profileLarge = user.userProfile!!.large
                            userDTO.profileMedium = user.userProfile!!.medium
                            userDTO.profileThumbnail = user.userProfile!!.thumbnail
                        }
                        userDTOList.add(userDTO)
                    }
                }
                return@flatMap Single.just(userDTOList)
            }
    }

}