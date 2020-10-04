package com.example.mvvmlist

import android.app.Application
import com.example.mvvmlist.di.networkModule
import com.example.mvvmlist.di.repositoryModule
import com.example.mvvmlist.di.sharedPrefModule
import com.example.mvvmlist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            koin.loadModules(listOf(repositoryModule,networkModule, sharedPrefModule, viewModelModule))
            koin.createRootScope()
        }
    }
}