package com.gandalgom.sample.navigation

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment?
                ?: return

        // Set up Action Bar
        val navController = host.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val dest: String = try {
                resources.getResourceName(destination.id)
            } catch (e: Resources.NotFoundException) {
                destination.id.toString()
            }

            Toast.makeText(
                this@MainActivity,
                "Navigated to $dest",
                Toast.LENGTH_SHORT,
            ).show()
            Log.d("MainActivity", "Navigated to $dest")
        }
    }
}