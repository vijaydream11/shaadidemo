package com.shaadidemo.presentation.utility

import com.shaadi.assignment.data.local.db.entity.InboxUser
import com.shaadi.assignment.data.local.db.typeconverters.UserStatus
import com.shaadidemo.domain.model.Result

object UtilsMapper {

    fun mapList(resultList: List<Result>): List<InboxUser> {
        val inboxUserList = mutableListOf<InboxUser>()
        resultList.forEach {
            inboxUserList.add(InboxUser( 0,it.name.first + " " + it.name.last,it.dob.age, it.picture.large, UserStatus.PENDING))
        }
        return inboxUserList
    }

}