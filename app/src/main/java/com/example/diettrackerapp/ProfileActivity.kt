package com.example.diettrackerapp
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.diettrackerapp.database.UserDatabase
import com.example.diettrackerapp.database.Users
import com.example.diettrackerapp.databinding.ActivityProfileBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityProfileBinding

    val db by lazy {
        UserDatabase.getInstance(this)
    }

    private lateinit var buttonUpdate : Button
    private lateinit var updateHeight : EditText
    private lateinit var updateWidth : EditText
    private lateinit var updateAge : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = ActivityProfileBinding.inflate(layoutInflater)
         setContentView(binding.root)
        buttonUpdate = findViewById(R.id.btnUpdate)
        updateHeight = findViewById(R.id.heightUpdate)
        updateWidth = findViewById(R.id.widthUpdate)
        updateAge = findViewById(R.id.ageUpdate)
        checkNumberOfUser()
        updateTheNote()

        setSupportActionBar(binding.appBarProfile.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_profile)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_profile)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun checkNumberOfUser() {
        CoroutineScope(Dispatchers.IO).launch {
            var userList : List<Users> = db.userDao().loadAll()
            var user1: Users = userList.get(0)
            updateHeight.setText(user1.height.toString())
            updateWidth.setText(user1.width.toString())
            updateAge.setText(user1.age.toString())
        }
    }

    private fun updateTheNote() {
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
        }
    }

}