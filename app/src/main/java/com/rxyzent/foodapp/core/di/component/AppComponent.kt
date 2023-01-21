package com.rxyzent.foodapp.core.di.component

import android.app.Application
import com.rxyzent.foodapp.core.di.modul.app.AppModule
import com.rxyzent.foodapp.core.di.modul.dataBase.DaoModule
import com.rxyzent.foodapp.core.di.modul.dataBase.DbBuilder
import com.rxyzent.foodapp.core.di.modul.network.ApiModule
import com.rxyzent.foodapp.core.di.modul.network.OkhttpModule
import com.rxyzent.foodapp.core.di.modul.network.RetrofitModule
import com.rxyzent.foodapp.core.di.modul.repo.RepoModule
import com.rxyzent.foodapp.core.di.modul.ui.activity.ActivitiesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApiModule::class,
    AppModule::class,
    OkhttpModule::class,
    RetrofitModule::class,
    ActivitiesModule::class,
    RepoModule::class,
    DbBuilder::class,
    DaoModule::class

])
interface AppComponent:AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application):Builder

        fun build():AppComponent
    }

}