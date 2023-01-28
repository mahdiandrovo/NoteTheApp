package com.drovo.notetheapp.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    val readAllData: LiveData<List<User>> = userDao.readAllData()

}