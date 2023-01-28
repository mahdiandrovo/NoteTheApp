package com.drovo.notetheapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drovo.notetheapp.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{

        private var INSTANCE: UserDatabase? = null

        //making it singleton
        fun getDatabase(context: Context): UserDatabase{
            val tempINSTANCE = INSTANCE
            if (tempINSTANCE != null){
                return tempINSTANCE
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    name = "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}