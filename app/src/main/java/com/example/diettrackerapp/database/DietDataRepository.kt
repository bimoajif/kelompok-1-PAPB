package com.example.diettrackerapp.database

import androidx.lifecycle.LiveData

class DietDataRepository(private val dao : DietDataDao) {
    val allPrograms: LiveData<List<DietData>> = dao.getAllProgram()

    suspend fun insert(dietData: DietData){
        dao.insertProgram(dietData)
    }

    suspend fun update(dietData: DietData){
        dao.updateProgram(dietData)
    }

    suspend fun delete(dietData: DietData) {
        dao.deleteProgram(dietData)
    }

    suspend fun deleteAll(dietData: DietData) {
        dao.deleteAllProgram()
    }
}