package com.example.android.room.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.android.room.base.BaseViewModel

class ActivityMainViewModel : BaseViewModel() {

    var title: MutableLiveData<String> = MutableLiveData("")
}