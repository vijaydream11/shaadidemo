package com.republictvdemo.view.navigator

import android.app.Activity
import android.os.Bundle
import com.republictvdemo.view.activity.UserDetailsActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityNavigator @Inject constructor() {

    fun navigateToUserDetail(activity: Activity, bundle: Bundle){
        activity.startActivity(UserDetailsActivity.getCallingIntent(activity, bundle))
    }

}