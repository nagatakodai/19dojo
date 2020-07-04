package com.nkjp.a19dojo_kotlin.ui.qr


class UserRepository(private val userDao: UserDao) {
    fun getUser(): List<User> {
        return userDao.getAllUsers()
    }

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}