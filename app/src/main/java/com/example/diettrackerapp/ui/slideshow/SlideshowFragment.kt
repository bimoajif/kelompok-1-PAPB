package com.example.diettrackerapp.ui.slideshow

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.diettrackerapp.EditProfileActivity
import com.example.diettrackerapp.MainActivity
import com.example.diettrackerapp.ProfileActivity
import com.example.diettrackerapp.R
import com.example.diettrackerapp.database.UserDatabase
import com.example.diettrackerapp.database.Users
import com.example.diettrackerapp.databinding.FragmentSlideshowBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SlideshowFragment() : Fragment() {

//    val db by lazy {
//        UserDatabase.getInstance(mainActivity)
//    }
//
//    private var userId = 0
//
//    private lateinit var buttonStart : Button
//    private lateinit var editHeight : EditText
//    private lateinit var editWidth : EditText
//    private lateinit var editAge : EditText

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        buttonStart = findViewById(R.id.btnStartApp)
//        editHeight = findViewById(R.id.heightText)
//        editWidth = findViewById(R.id.widthText)
//        editAge = findViewById(R.id.ageText)

//        val slideshowViewModel by lazy {
//            ViewModelProvider(this).get(SlideshowViewModel()::class.java)
//        }


        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        binding.btnUpdate.setOnClickListener {
//            val intent = Intent(activity, ProfileActivity::class.java)
//            startActivity(intent)
//        }
        val intent = Intent(activity, EditProfileActivity::class.java)
        startActivity(intent)



//        CoroutineScope(Dispatchers.IO).launch {
//            var user : Users = slideshowViewModel.user1
//            binding.heightUpdate.setText(user.height.toString())
////            editWidth.setText(user1.width.toString())
////            editAge.setText(user1.age.toString())
////            updateTheNote()
//
//        }
//        slideshowViewModel.getUserData()
//        var user: Users = slideshowViewModel.getUserData()
//        binding.heightUpdate.setText(user.height.toString())

//        val height: EditText = binding.heightUpdate
//        height.setText(slideshowViewModel.user1.height)

//        val textView: TextView = binding.textSlideshow
//        slideshowViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    private fun updateTheNote() {
//        binding.btnUpdate.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                db.userDao().updateUser(
//                    Users(
//                        1,
//                        binding.heightUpdate.text.toString().toInt(),
//                        binding.widthUpdate.text.toString().toInt(),
//                        binding.ageUpdate.text.toString().toInt()
//                    )
//                )
//            }
//        }
//    }
}