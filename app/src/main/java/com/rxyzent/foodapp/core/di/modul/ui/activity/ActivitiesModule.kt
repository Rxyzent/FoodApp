package com.rxyzent.foodapp.core.di.modul.ui.activity

import com.rxyzent.foodapp.core.di.modul.ui.main.MainActivityModule
import com.rxyzent.foodapp.core.di.modul.ui.main.MainFragmentProviders
import com.rxyzent.foodapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector(
        modules = [MainActivityModule::class, MainFragmentProviders::class]
    )
    fun provideMainActivity(): MainActivity

}