package com.example.diettrackerapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "dietprogram_table")
data class DietProgram (
    @PrimaryKey(autoGenerate = true)
    val programId : Int,

    @ColumnInfo(name = "program_name")
    val name : String,

    @ColumnInfo(name = "program_description")
    val description : String
)