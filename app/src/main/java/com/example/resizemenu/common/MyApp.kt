package com.example.resizemenu.common

import android.app.Application
import com.example.resizemenu.di.appModule
import com.example.resizemenu.di.repositoryModule
import com.example.resizemenu.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MyApp)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }



}