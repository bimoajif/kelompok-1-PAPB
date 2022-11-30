package com.example.diettrackerapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DietDataDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProgram(dietprogram : DietData) : Long

    @Update
    suspend fun updateProgram(dietprogram : DietData) : Long

    @Delete
    suspend fun deleteProgram(dietprogram : DietData) : Long

    @Query("DELETE FROM diet_tracker_table")
    suspend fun deleteAllProgram()

    @Query("SELECT * FROM diet_tracker_table")
    fun getAllProgram():LiveData<List<DietData>>
}