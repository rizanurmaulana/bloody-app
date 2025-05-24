package com.example.bloody_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment, R.id.scheduleFragment, R.id.riwayatFragment, R.id.profilFragment -> {
                    val options = NavOptions.Builder()
                        .setLaunchSingleTop(true)
                        .setPopUpTo(navController.graph.startDestinationId, false) // INI penting!
                        .build()
                    try {
                        navController.navigate(item.itemId, null, options)
                        true
                    } catch (e: IllegalArgumentException) {
                        false // tujuan mungkin sudah di stack teratas
                    }
                }
                else -> false
            }
        }

    }
}
