package com.example.diettrackerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.diettrackerapp.database.UserDatabase
import com.example.diettrackerapp.database.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditProfileActivity : AppCompatActivity() {
    val db by lazy {
        UserDatabase.getInstance(this)
    }

    private lateinit var buttonUpdate : Button
    private lateinit var updateHeight : EditText
    private lateinit var updateWidth : EditText
    private lateinit var updateAge : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        buttonUpdate = findViewById(R.id.btnUpdate)
        updateHeight = findViewById(R.id.heightUpdate)
        updateWidth = findViewById(R.id.widthUpdate)
        updateAge = findViewById(R.id.ageUpdate)
        setUpListener()
    }
    private fun setUpListener() {
        buttonUpdate.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().updateUser(
                    Users(
                        1,
                        updateHeight.text.toString().toInt(),
                        updateWidth.text.toString().toInt(),
                        updateAge.text.toString().toInt()
                    )
                )
            }
            Toast.makeText(getApplicationContext(),"Data berhasil diubah",Toast.LENGTH_SHORT).show()
            finish()
        }
    }


}