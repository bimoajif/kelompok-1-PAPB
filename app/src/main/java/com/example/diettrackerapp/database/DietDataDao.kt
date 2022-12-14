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
    @Query("SELECT * FROM diet_tracker_table")
    fun loadAllDietData(): List<DietData>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDietData(dietData: DietData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateDietData(dietData: DietData)
}