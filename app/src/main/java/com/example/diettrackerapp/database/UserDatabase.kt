package com.example.diettrackerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UsersDao

    companion object {
        @Volatile
        private var INSTANCE : UserDatabase? = null
        fun getInstance(context: Context):UserDatabase{
            synchronized(this){
                var instance:UserDatabase? = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "userData_database"
                    ).build()
                }
                return instance
            }
        }
    }

}