package com.example.android.room.di

import com.example.android.room.viewmodel.ActivityDetailViewModel
import com.example.android.room.viewmodel.ActivityMainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel {
        ActivityMainViewModel()
    }
    viewModel {
        ActivityDetailViewModel()
    }
}