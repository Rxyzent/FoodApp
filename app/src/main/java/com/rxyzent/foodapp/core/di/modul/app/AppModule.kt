package com.rxyzent.foodapp.core.di.modul.app

import android.app.Application
import android.content.Context
import com.rxyzent.foodapp.core.di.modul.network.OkhttpModule
import com.rxyzent.foodapp.core.di.modul.network.RetrofitModule
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class, OkhttpModule::class])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun context(application: Application): Context


}