package com.example.android.room.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.android.room.model.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("select * from User")
    fun getAllUsers(): List<User>

    @Query("update User set title =:title where id in (:id)")
    fun updateUser(id: Long, title: String)

    @Query("delete from User")
    fun deleteAllUsers()
}