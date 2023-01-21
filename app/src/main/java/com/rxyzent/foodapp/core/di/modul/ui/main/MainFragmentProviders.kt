package com.rxyzent.foodapp.core.di.modul.ui.main

import com.rxyzent.foodapp.core.di.modul.ui.main.detailFragment.DetailFragmentModule
import com.rxyzent.foodapp.core.di.modul.ui.main.favoriteFragment.FavoriteFragmentModule
import com.rxyzent.foodapp.core.di.modul.ui.main.homeFragment.HomeFragmentModule
import com.rxyzent.foodapp.core.di.modul.ui.main.search.SearchFragmentModule
import com.rxyzent.foodapp.ui.detail.DetailFragment
import com.rxyzent.foodapp.ui.favorite.FavoriteFragment
import com.rxyzent.foodapp.ui.main.HomeFragment
import com.rxyzent.foodapp.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainFragmentProviders {

    @ContributesAndroidInjector(modules = [
        HomeFragmentModule::class
    ])
    fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [
        DetailFragmentModule::class
    ])
    fun provideDetailFragment():DetailFragment

    @ContributesAndroidInjector(modules = [
        SearchFragmentModule::class
    ])
    fun provideSearchFragment():SearchFragment

    @ContributesAndroidInjector(modules = [
        FavoriteFragmentModule::class
    ])
    fun provideFavoriteFragment(): FavoriteFragment


}