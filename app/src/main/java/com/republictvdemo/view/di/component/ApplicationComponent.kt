package com.republictvdemo.view.di.component

import com.google.gson.Gson
import com.republictvdemo.view.di.module.ApplicationModule
import com.republictvdemo.view.di.module.GsonModule
import com.republictvdemo.view.navigator.ActivityNavigator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, GsonModule::class])
interface ApplicationComponent {

    fun getActivityNavigator(): ActivityNavigator

    fun getGson(): Gson

}