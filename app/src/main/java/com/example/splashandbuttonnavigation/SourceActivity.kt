package com.example.splashandbuttonnavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.splashandbuttonnavigation.databinding.ActivitySourceBinding

class SourceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            //activity to activity
//            var intent = Intent(this@SourceActivity,
//                DestinationActivity::class.java)
//
//            var name: String = binding.newName.text.toString()
//            var phone: String = binding.newNumber.text.toString()
//
//            intent.putExtra("name", name)
//            intent.putExtra("phone", phone)
//            startActivity(intent)
//            finish()
            //ACTIVITY TO FRAGMENT//
            var a = binding.num1.text.toString().toInt()
            var b = binding.num2.text.toString().toInt()

            var bundle = Bundle()
            bundle.putInt("first",a)
            bundle.putInt("second",b)

            var destinationFragment = DestinationFragment()

            destinationFragment.arguments = bundle

//            var fragmentManager : FragmentManager = supportFragmentManager
//            var fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
            supportFragmentManager.beginTransaction().replace(R.id.frameLayoutDataPass,destinationFragment).commit()

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}