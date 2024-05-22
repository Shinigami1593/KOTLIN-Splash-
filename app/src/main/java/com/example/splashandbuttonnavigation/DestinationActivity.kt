package com.example.splashandbuttonnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splashandbuttonnavigation.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {
    lateinit var Binding: ActivityDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        var name : String = intent.getStringExtra("name").toString()
        var phone : String = intent.getStringExtra("phone").toString()

        Binding.textView.text = name
        Binding.textView2.text = phone



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}