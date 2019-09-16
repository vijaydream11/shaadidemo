package com.republictvdemo.data.di

import com.republictvdemo.data.api.ApiHelper
import com.republictvdemo.data.api.retrofit.RetrofitManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideApiHelper(): ApiHelper {
        return RetrofitManager()
    }

}

