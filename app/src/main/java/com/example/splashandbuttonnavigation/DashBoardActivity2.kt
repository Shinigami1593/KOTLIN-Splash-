package com.example.splashandbuttonnavigation

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splashandbuttonnavigation.databinding.ActivityDashBoard2Binding
import com.google.android.material.navigation.NavigationView

class DashBoardActivity2 : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding : ActivityDashBoard2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashBoard2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

        var toggle = ActionBarDrawerToggle(
            this, binding.main,
            binding.toolBar, R.string.open_drawer, R.string.open_drawer
        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.home -> {
                title = "Home"
                supportFragmentManager.beginTransaction().
                replace(R.id.frame, HomeFragment()).commit()
            }
            R.id.search->supportFragmentManager.beginTransaction().
            replace(R.id.frame, SearchFragment()).commit()

            R.id.profile ->  supportFragmentManager.beginTransaction().
            replace(R.id.frame, ProfileFragment()).commit()

            R.id.notification -> supportFragmentManager.beginTransaction().
            replace(R.id.frame, NotificationFragment()).commit()

        }
        binding.main.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (binding.main.isDrawerOpen(GravityCompat.START)) {
            binding.main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed() // Move this line inside the else block
        }
    }
}