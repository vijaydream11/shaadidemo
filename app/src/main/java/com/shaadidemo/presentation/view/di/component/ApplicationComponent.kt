package com.shaadidemo.view.di.component

import com.google.gson.Gson
import com.shaadidemo.view.di.module.ApplicationModule
import com.shaadidemo.view.di.module.GsonModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

}