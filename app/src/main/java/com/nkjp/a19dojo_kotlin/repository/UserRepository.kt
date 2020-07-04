package com.nkjp.a19dojo_kotlin.repository

import com.nkjp.a19dojo_kotlin.model.User
import com.nkjp.a19dojo_kotlin.model.UserDao


class UserRepository(private val userDao: UserDao) {
    fun getUser(): List<User> {
        return userDao.getAllUsers()
    }

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}