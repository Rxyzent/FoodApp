package com.rxyzent.foodapp.core.di.modul.network

import com.rxyzent.foodapp.core.dataProvider.api.SpoonacularApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
abstract class ApiModule {

    companion object{

        @Provides
        @Singleton
        fun provideNewApi(retrofit: Retrofit): SpoonacularApi {
            return retrofit.create(SpoonacularApi::class.java)
        }

    }
}