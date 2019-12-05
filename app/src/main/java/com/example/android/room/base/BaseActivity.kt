package com.example.android.room.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.android.room.BR

abstract class BaseActivity<VDB : ViewDataBinding, BVM : BaseViewModel>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {

    abstract val viewModel: BVM
    protected lateinit var binding: VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
        dataBinding(binding)
        otherStuffs()
    }

    abstract fun otherStuffs()

    abstract fun dataBinding(binding: ViewDataBinding)
}