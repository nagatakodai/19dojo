package com.nkjp.a19dojo_kotlin.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nkjp.a19dojo_kotlin.model.User

@Dao
interface UserDao{
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)
}