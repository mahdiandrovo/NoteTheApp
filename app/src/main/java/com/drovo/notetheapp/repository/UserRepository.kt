package com.drovo.notetheapp.repository

import androidx.lifecycle.LiveData
import com.drovo.notetheapp.data.UserDao
import com.drovo.notetheapp.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}