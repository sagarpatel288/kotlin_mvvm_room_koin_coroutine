package com.example.android.room.view.detail

import com.example.android.room.model.User

sealed class DetailScreenStates {

    object Initial : DetailScreenStates()
    object Loading : DetailScreenStates()
    data class Success(var user: User) : DetailScreenStates()
    data class Fail(var user: User) : DetailScreenStates()
}