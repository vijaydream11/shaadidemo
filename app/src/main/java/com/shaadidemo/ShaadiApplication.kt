package com.shaadidemo

import android.app.Application
import com.facebook.stetho.Stetho
import com.shaadidemo.data.di.DaggerDataComponent
import com.shaadidemo.data.di.DataComponent
import com.shaadidemo.data.di.DataModule
import com.shaadidemo.view.di.component.ApplicationComponent
import com.shaadidemo.view.di.component.DaggerApplicationComponent

class ShaadiApplication : Application() {

    companion object {
        lateinit var dataComponent: DataComponent
        val component: ApplicationComponent = DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder().dataModule(DataModule(this)).build()
        Stetho.initializeWithDefaults(this);

    }
}