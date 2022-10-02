package com.example.papb_tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import timber.log.Timber
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())
        Timber.i("onCreate Called")
        Toast.makeText(applicationContext,"onCreate Called",Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()

        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()

        Timber.i("onResume Called")
        Toast.makeText(applicationContext,"onResume Called",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()

        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()

        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Timber.i("onDestroy Called")
        Toast.makeText(applicationContext,"onDestroy Called",Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()

        Timber.i("onRestart Called")
    }
}