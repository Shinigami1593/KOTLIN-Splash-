package com.example.splashandbuttonnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.splashandbuttonnavigation.databinding.ActivityTabAndViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabAndViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityTabAndViewBinding
    var heading = arrayOf("Message","Status","Call")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTabAndViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragmentManager : FragmentManager = supportFragmentManager
        binding.viewPager.adapter = TabAdapter(fragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout,binding.viewPager){
            tabs,position -> tabs.text = heading[position]
        }.attach()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}