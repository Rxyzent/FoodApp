package com.rxyzent.foodapp.core.di.modul.dataBase

import com.rxyzent.foodapp.core.dataProvider.db.DbDao
import com.rxyzent.foodapp.core.dataProvider.db.MyDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DaoModule {

    @Provides
    @Singleton
    fun provideDao(db: MyDataBase): DbDao {
        return db.userDao()
    }
}