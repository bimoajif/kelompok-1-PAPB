package com.example.diettrackerapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DietProgramDao {
    @Insert
    suspend fun insertProgram(dietprogram : DietProgram) : Long

    @Update
    suspend fun updateProgram(dietprogram : DietProgram) : Long

    @Delete
    suspend fun deleteProgram(dietprogram : DietProgram) : Long

    @Query("DELETE FROM dietprogram_table")
    suspend fun deleteAllProgram()

    @Query("SELECT * FROM dietprogram_table")
    fun getAllProgram():LiveData<List<DietProgram>>
}