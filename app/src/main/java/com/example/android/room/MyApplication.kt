package com.example.android.room

import android.app.Application
import com.example.android.room.di.dbModule
import com.example.android.room.di.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(dbModule, viewModules))
        }
    }
}