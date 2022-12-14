package com.example.diettrackerapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "diet_tracker_table")
data class DietData (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "diet_id")
    val dietId : Int,

    @ColumnInfo(name = "eat_time")
    val eat_time : String,

    @ColumnInfo(name = "food_list")
    val food_list : String,

    @ColumnInfo(name = "calories")
    val calories : Int
)