package com.example.android.room.view.detail

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.observe
import com.example.android.room.R
import com.example.android.room.base.BaseActivity
import com.example.android.room.constants.Constants
import com.example.android.room.databinding.ActivityDetailBinding
import com.example.android.room.model.User
import com.example.android.room.viewmodel.ActivityDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity :
    BaseActivity<ActivityDetailBinding, ActivityDetailViewModel>(R.layout.activity_detail) {

    override val viewModel: ActivityDetailViewModel by viewModel()
    private var myBinding: ActivityDetailBinding? = null
    override fun dataBinding(binding: ViewDataBinding) {
        myBinding = binding as? ActivityDetailBinding
    }

    override fun otherStuffs() {
        if (intent!!.hasExtra(Constants.PARCEL)) {
            val user: User? = intent!!.getParcelableExtra(Constants.PARCEL) as? User
            if (user != null) {
                viewModel.user.value = (user)
            }
        } else {
            viewModel.user.value = (User(""))
        }
        setObserver()
    }

    private fun setObserver() {
        viewModel.state().observe(this) { state ->
            onChangeState(state)
        }
        viewModel.user.observe(this) { user ->
            onChangeUser(user)
        }
    }

    private fun onChangeUser(user: User?) {
        if (user != null && !user.title.isNullOrEmpty()) {
            viewModel.error.value = null
        }
    }

    private fun onChangeState(state: DetailScreenStates) {
        if (state is DetailScreenStates.Loading) {
            disableViews(myBinding!!.viewFabSave)
        }
        if (state is DetailScreenStates.Success) {
            setResult(Activity.RESULT_OK, Intent())
            finish()
        }
    }

    private fun disableViews(vararg views: View?) {
        if (views.isNotEmpty()) {
            views.forEach { view -> view!!.isEnabled.not() }
        }
    }
}
