package com.example.android.room.view.main

import android.content.Intent
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.room.R
import com.example.android.room.base.BaseActivity
import com.example.android.room.constants.Constants
import com.example.android.room.databinding.ActivityMainBinding
import com.example.android.room.db.dao.UserDao
import com.example.android.room.model.User
import com.example.android.room.view.detail.DetailActivity
import com.example.android.room.viewmodel.ActivityMainViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity :
    BaseActivity<ActivityMainBinding, ActivityMainViewModel>(R.layout.activity_main),
    View.OnClickListener {

    private var myBinding: ActivityMainBinding? = null
    override val viewModel: ActivityMainViewModel by viewModel()
    private val userDao: UserDao by inject()
    private var userListAdapter: UserListAdapter? = null

    override fun dataBinding(binding: ViewDataBinding) {
        myBinding = binding as? ActivityMainBinding?
    }

    override fun otherStuffs() {
        setRecyclerView()
        setViewListener(myBinding!!.viewFabAdd, myBinding!!.viewFabDelete)
    }

    private fun setViewListener(vararg views: View) {
        if (!views.isNullOrEmpty()) {
            views.forEach { view -> view.setOnClickListener(this) }
        }
    }

    private fun setRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        userListAdapter = UserListAdapter(this, userDao.getAllUsers() as ArrayList<User>)
        myBinding?.viewRv?.layoutManager = layoutManager
        myBinding?.viewRv?.adapter = userListAdapter
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.view_fab_add -> startActivityForResult(
                Intent(this, DetailActivity::class.java),
                Constants.DETAIL
            )
            R.id.view_fab_delete -> deleteAllRecords()
        }
    }

    private fun deleteAllRecords() {
        userListAdapter?.setList(ArrayList())
        userDao.deleteAllUsers()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        userListAdapter?.setList(userDao.getAllUsers() as ArrayList<User>)
    }
}
