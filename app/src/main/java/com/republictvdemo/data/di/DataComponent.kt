package com.republictvdemo.data.di

import android.content.Context
import com.republictvdemo.data.api.ApiHelper
import com.republictvdemo.data.api.retrofit.NetworkAPI
import com.republictvdemo.data.api.retrofit.di.RetrofitModule
import com.republictvdemo.view.di.module.ContextModule
import com.republictvdemo.view.di.module.GsonModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, RetrofitModule::class, GsonModule::class, ContextModule::class])
interface DataComponent {

    fun getApiHelper(): ApiHelper

    fun getNetworkApi(): NetworkAPI

    fun getContext(): Context
}