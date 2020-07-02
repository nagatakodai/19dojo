package com.nkjp.a19dojo_kotlin.ui.qr

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao{
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)
}