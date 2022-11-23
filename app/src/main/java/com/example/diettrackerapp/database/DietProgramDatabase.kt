package com.example.diettrackerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DietProgram::class], version = 1)
abstract class DietProgramDatabase : RoomDatabase() {
    abstract val DietProgramDAO : DietProgramDao


    companion object {
        @Volatile
        private var INSTANCE : DietProgramDatabase? = null
            fun getInstance(context: Context):DietProgramDatabase{
                synchronized(this){
                    var instance:DietProgramDatabase? = INSTANCE
                        if (instance==null){
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                DietProgramDatabase::class.java,
                                "dietprogram_database"
                            ).build()
                        }
                    return instance
                }
            }
    }


}
