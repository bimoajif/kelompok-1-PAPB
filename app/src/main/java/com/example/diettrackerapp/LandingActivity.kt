package com.example.diettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.diettrackerapp.database.UserDatabase
import com.example.diettrackerapp.database.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LandingActivity : AppCompatActivity() {

    val db by lazy {
        UserDatabase.getInstance(this)
    }

    private var userId = 0

    private lateinit var buttonStart : Button
    private lateinit var editHeight : EditText
    private lateinit var editWidth : EditText
    private lateinit var editAge : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        buttonStart = findViewById(R.id.btnStartApp)
        editHeight = findViewById(R.id.heightText)
        editWidth = findViewById(R.id.widthText)
        editAge = findViewById(R.id.ageText)
        checkNumberOfUser()
    }

    private fun setUpListener() {
        buttonStart.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().insertUser(
                    Users(
                        userId,
                        editHeight.text.toString().toInt(),
                        editWidth.text.toString().toInt(),
                        editAge.text.toString().toInt()
                    )
                )
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkNumberOfUser() {
        CoroutineScope(Dispatchers.IO).launch {
            var userList : List<Users> = db.userDao().loadAll()
            if (userList.size >= 1){
                var user1: Users = userList.get(0)
                editHeight.setText(user1.height.toString())
                editWidth.setText(user1.width.toString())
                editAge.setText(user1.age.toString())
                updateTheNote()
            } else {
                setUpListener()
            }
        }
    }

    private fun updateTheNote() {
        buttonStart.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().updateUser(
                    Users(
                        1,
                        editHeight.text.toString().toInt(),
                        editWidth.text.toString().toInt(),
                        editAge.text.toString().toInt()
                    )
                )
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
