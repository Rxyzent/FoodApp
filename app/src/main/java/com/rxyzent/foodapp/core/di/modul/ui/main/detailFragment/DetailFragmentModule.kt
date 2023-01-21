package com.rxyzent.foodapp.core.di.modul.ui.main.detailFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rxyzent.foodapp.core.di.annotation.ViewModelKey
import com.rxyzent.foodapp.core.helper.ViewModelProviderFactory
import com.rxyzent.foodapp.ui.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailFragmentModule{

    @Binds
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindPhoneVM(vm: DetailViewModel): ViewModel
}