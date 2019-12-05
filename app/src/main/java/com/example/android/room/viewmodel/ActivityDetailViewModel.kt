package com.example.android.room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.room.base.BaseViewModel
import com.example.android.room.db.dao.UserDao
import com.example.android.room.model.User
import com.example.android.room.view.detail.DetailScreenStates
import org.koin.core.inject

class ActivityDetailViewModel : BaseViewModel() {

    private val userDao: UserDao by inject()

     var error: MutableLiveData<String> = MutableLiveData("")
     var user: MutableLiveData<User> = MutableLiveData()
     var state: MutableLiveData<DetailScreenStates> =
        MutableLiveData(DetailScreenStates.Initial)

    fun state() : LiveData<DetailScreenStates> = state

     fun onSaveClicked(user: User) {
        if (user.title == null || user.title!!.isBlank()) {
            error.value = ("Title cannot be blank")
            return
        }
        state.value = (DetailScreenStates.Loading)

        if (userDao.getUserById(user.id) != null) {
            userDao.updateUser(user.id, user.title!!)
        } else {
            userDao.insert(user)
        }
         state.value = (DetailScreenStates.Success(user))
    }
}