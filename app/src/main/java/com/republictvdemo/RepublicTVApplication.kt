package com.republictvdemo

import android.app.Application
import com.republictvdemo.data.di.DaggerDataComponent
import com.republictvdemo.data.di.DataComponent
import com.republictvdemo.view.di.component.ApplicationComponent
import com.republictvdemo.view.di.component.DaggerApplicationComponent
import com.republictvdemo.view.di.module.ContextModule

class RepublicTVApplication : Application() {

    companion object {
        lateinit var dataComponent: DataComponent
        val component: ApplicationComponent = DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder().contextModule(ContextModule(this)).build()

    }
}