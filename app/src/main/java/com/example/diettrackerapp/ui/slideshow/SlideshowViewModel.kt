package com.example.diettrackerapp.ui.slideshow

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diettrackerapp.MainActivity
import com.example.diettrackerapp.database.UserDatabase
import com.example.diettrackerapp.database.Users
import com.example.diettrackerapp.databinding.FragmentSlideshowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SlideshowViewModel(application: Application) : ViewModel() {

    val db by lazy {
        UserDatabase.getInstance(application)
    }

    var userId = 1

//    private lateinit var _user: Users
//    var user: Users = _user

    fun getUserData() : Users{
        lateinit var user: Users
        CoroutineScope(Dispatchers.IO).launch {
            var user1: Users = db.userDao().loadAll().get(0)
            user = user1
        }
        return user
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text
}