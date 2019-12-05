package com.example.android.room.db.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg t: T)

    @Update
    fun update(vararg t: T): Int

    @Delete
    fun delete(vararg t: T): Int
}