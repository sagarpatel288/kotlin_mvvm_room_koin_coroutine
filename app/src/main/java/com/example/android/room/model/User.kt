package com.example.android.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class User(var title: String?, @PrimaryKey(autoGenerate = true) var id: Long) : Parcelable