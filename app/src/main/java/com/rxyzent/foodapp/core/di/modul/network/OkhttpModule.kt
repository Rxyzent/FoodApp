package com.rxyzent.foodapp.core.di.modul.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
abstract class OkhttpModule {

    companion object{
        @Provides
        @Singleton
        fun getOkhttp(
            interceptor: ChuckerInterceptor
        ): OkHttpClient {
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        }


        @Provides
        @Singleton
        fun getChucker(context: Context): ChuckerInterceptor {
            val collector = ChuckerCollector(
                context = context, showNotification = true, retentionPeriod = RetentionManager.Period.FOREVER
            )
            return ChuckerInterceptor.Builder(context).collector(collector).build()
        }
    }

}