package com.example.android.room.view.main

import androidx.databinding.ViewDataBinding
import com.example.android.room.R
import com.example.android.room.base.BaseActivity
import com.example.android.room.databinding.ActivityMainBinding
import com.example.android.room.viewmodel.ActivityMainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, ActivityMainViewModel>(R.layout.activity_main) {

    private var myBinding: ActivityMainBinding? = null
    override val viewModel: ActivityMainViewModel by viewModel()

    override fun dataBinding(binding: ViewDataBinding) {
        myBinding = binding as? ActivityMainBinding?
    }

    override fun otherStuffs() {

    }
}
