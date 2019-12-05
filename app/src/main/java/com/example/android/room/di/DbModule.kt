package com.example.android.room.di

import androidx.room.Room
import com.example.android.room.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(),
                AppDatabase::class.java,
                "indiaNic.db"
            )
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<AppDatabase>().getAppDao()
    }
}