package com.rxyzent.foodapp.core.di.modul.ui.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rxyzent.foodapp.core.di.annotation.ViewModelKey
import com.rxyzent.foodapp.core.helper.ViewModelProviderFactory
import com.rxyzent.foodapp.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchFragmentModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindPhoneVM(vm: SearchViewModel): ViewModel
}