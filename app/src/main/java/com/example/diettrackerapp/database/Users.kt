package com.example.diettrackerapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Int,

    @ColumnInfo(name = "height")
    val height: Int,

    @ColumnInfo(name = "width")
    val width: Int,

    @ColumnInfo(name = "age")
    val age: Int
)