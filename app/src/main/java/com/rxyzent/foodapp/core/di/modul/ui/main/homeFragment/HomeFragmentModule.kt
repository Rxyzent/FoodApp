package com.rxyzent.foodapp.core.di.modul.ui.main.homeFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rxyzent.foodapp.core.di.annotation.ViewModelKey
import com.rxyzent.foodapp.core.helper.ViewModelProviderFactory
import com.rxyzent.foodapp.ui.main.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeFragmentModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindPhoneVM(vm: HomeViewModel): ViewModel

}