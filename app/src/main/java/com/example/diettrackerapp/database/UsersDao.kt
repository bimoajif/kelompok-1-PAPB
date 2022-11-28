package com.example.diettrackerapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsersDao {

//    @RewriteQueriesToDropUnusedColumns
//    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM users")
    fun loadAll(): List<Users>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: Users)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(users: Users)
}