package com.example.diettrackerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DietData::class], version = 1)
abstract class DietDataDatabase : RoomDatabase() {
    abstract val DietDataDao : DietDataDao

    companion object {
        @Volatile
        private var INSTANCE : DietDataDatabase? = null
        fun getInstance(context: Context):DietDataDatabase{
            synchronized(this){
                var instance:DietDataDatabase? = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DietDataDatabase::class.java,
                        "userData_database"
                    ).build()
                }
                return instance
            }
        }
    }

}
