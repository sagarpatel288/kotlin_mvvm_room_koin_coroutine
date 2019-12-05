package com.example.android.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.room.db.dao.UserDao
import com.example.android.room.model.User

@Database(entities = [(User::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppDao(): UserDao
}