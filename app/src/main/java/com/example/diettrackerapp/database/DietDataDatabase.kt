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
        fun getDatabase(context: Context):DietDataDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    DietDataDatabase::class.java,
                    "diet_tracker_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
