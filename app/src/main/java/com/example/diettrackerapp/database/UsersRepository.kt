package com.example.diettrackerapp.database

class UsersRepository(private val userDao: UsersDao) {
    val allUser = userDao.loadAll()

    fun insert(users: Users){
        userDao.insertUser(users)
    }
    fun update(users:Users) {
        userDao.updateUser(users)
    }
}