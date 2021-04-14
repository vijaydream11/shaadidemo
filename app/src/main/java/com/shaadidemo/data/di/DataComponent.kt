package com.shaadidemo.data.di

import com.shaadidemo.data.api.ApiHelper
import com.shaadidemo.data.api.retrofit.NetworkAPI
import com.shaadidemo.data.api.retrofit.di.RetrofitModule
import com.shaadi.assignment.data.local.db.DatabaseService
import com.shaadidemo.view.di.module.GsonModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, RetrofitModule::class, GsonModule::class])
interface DataComponent {

    fun getApiHelper(): ApiHelper

    fun getNetworkApi(): NetworkAPI

    fun getDatabaseService(): DatabaseService


}