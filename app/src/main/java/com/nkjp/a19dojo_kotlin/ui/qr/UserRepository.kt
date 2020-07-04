package com.nkjp.a19dojo_kotlin.ui.qr

class UserRepository(private val userDao: UserDao) {

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}