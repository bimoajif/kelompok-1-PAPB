package com.example.diettrackerapp.database

import androidx.lifecycle.LiveData

class DietDataRepository(private val dao : DietDataDao) {
    val allDietData = dao.loadAllDietData()

    fun insert(dietData: DietData){
        dao.insertDietData(dietData)
    }
    fun update(dietData: DietData) {
        dao.updateDietData(dietData)
    }
}