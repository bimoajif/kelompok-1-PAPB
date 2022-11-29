package com.example.diettrackerapp.ui.landing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.diettrackerapp.database.UsersDao
import com.example.diettrackerapp.database.UsersRepository

class LandingViewModel(application: Application): AndroidViewModel(application) {
//
    private lateinit var repository: UsersRepository
    private lateinit var userDao: UsersDao

//
//    private var _users : LiveData<List<Users>>
//
//    val users : LiveData<List<Users>>
//        get() = _users

//    init {
//        userDao = UserDatabase.getInstance(application).userDao()
//        repository = UsersRepository(userDao)
//        _users = repository.allUser
//    }
//
//    fun addUser() {
//        repository.insert(Users(160, 45, 23))
//    }
}