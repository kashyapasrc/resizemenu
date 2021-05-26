package com.example.resizemenu.di

import com.example.resizemenu.ui.koin_example.KoinViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


var viewModelModule = module {

    viewModel {
        KoinViewModel(get(),get())
    }
}