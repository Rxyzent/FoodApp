package com.rxyzent.foodapp.core.di.modul.dataBase

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rxyzent.foodapp.core.dataProvider.db.MyDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class DbBuilder {

    companion object {
        @Provides
        @Singleton
        fun provideDb(context: Context): MyDataBase {
                return Room.databaseBuilder (
                    context,
                    MyDataBase::class.java, "user_db.db"
                ).allowMainThreadQueries()
                    .build()

        }
    }
}