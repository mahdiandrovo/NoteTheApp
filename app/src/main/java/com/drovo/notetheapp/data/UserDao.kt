package com.drovo.notetheapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.drovo.notetheapp.model.User

@Dao
interface UserDao {
    //DAO: Data Access Object

    //jodi same user ashe tahole ta ignore korbe
    //may b add korbe na emn kichu
    //not sure yet
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()
}