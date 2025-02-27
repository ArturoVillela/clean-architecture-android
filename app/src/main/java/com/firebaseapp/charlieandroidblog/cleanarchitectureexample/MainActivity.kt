package com.firebaseapp.charlieandroidblog.cleanarchitectureexample

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

/*
Using Hilt for dependency injection in Android apps can introduce some overhead due to reflection, which can impact app startup time and memory usage,
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnA = findViewById<ImageButton>(R.id.btn_a)
        val btnB = findViewById<ImageButton>(R.id.btn_b)
        val btnC = findViewById<ImageButton>(R.id.btn_c)


        btnA.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView3)
            navController.navigate(R.id.fragmentA)
        }
        btnB.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView3)
            navController.navigate(R.id.fragmentB)
        }
        btnC.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView3)
            navController.navigate(R.id.fragmentC)
        }
    }
}