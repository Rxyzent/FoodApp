package com.rxyzent.foodapp.core.di.modul.network

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class RetrofitModule {

    companion object{
        @Provides
        @Singleton
        fun provideRetrofit(
            client: OkHttpClient,
            rxProvider: RxJava3CallAdapterFactory
        ): Retrofit {
            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.spoonacular.com/")
                .addCallAdapterFactory(rxProvider)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideRxFactory(): RxJava3CallAdapterFactory {
            return RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io())
        }
    }

}