package com.shaadidemo.data.di

import androidx.room.Room
import com.shaadidemo.ShaadiApplication
import com.shaadidemo.data.api.ApiHelper
import com.shaadidemo.data.api.retrofit.RetrofitManager
import com.shaadi.assignment.data.local.db.DatabaseService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(var application: ShaadiApplication) {

    @Singleton
    @Provides
    fun provideApiHelper(): ApiHelper {
        return RetrofitManager()
    }

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
        Room.databaseBuilder(
            application, DatabaseService::class.java,
            "shaadi-db"
        ).build()


}

