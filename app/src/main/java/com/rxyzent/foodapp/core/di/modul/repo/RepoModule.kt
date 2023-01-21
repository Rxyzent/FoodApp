package com.rxyzent.foodapp.core.di.modul.repo

import com.rxyzent.foodapp.core.dataProvider.api.SpoonacularApi
import com.rxyzent.foodapp.core.repo.DetailRepo
import com.rxyzent.foodapp.core.repo.HomeRepo
import com.rxyzent.foodapp.core.repo.SearchRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun provideHomeRepo(
        api: SpoonacularApi
    ):HomeRepo{
        return HomeRepo(api)
    }

    @Singleton
    @Provides
    fun provideSearchRepo(
        api: SpoonacularApi
    ):SearchRepo{
        return SearchRepo(api)
    }


    @Singleton
    @Provides
    fun provideDetailRepo(
        api: SpoonacularApi
    ):DetailRepo{
        return DetailRepo(api)
    }

}