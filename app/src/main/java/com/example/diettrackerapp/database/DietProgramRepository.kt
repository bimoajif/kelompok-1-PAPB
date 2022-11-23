package com.example.diettrackerapp.database

class DietProgramRepository(private val dao : DietProgramDao) {
    val dietprograms = dao.getAllProgram()

    suspend fun insert(dietProgram: DietProgram){
        dao.insertProgram(dietProgram)
    }

    suspend fun update(dietProgram: DietProgram){
        dao.updateProgram(dietProgram)
    }

    suspend fun delete(dietProgram: DietProgram) {
        dao.deleteProgram(dietProgram)
    }

    suspend fun deleteAll(dietProgram: DietProgram) {
        dao.deleteAllProgram()
    }
}