package com.example.androidclassapp.ca2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_page)

        val name = intent.getStringExtra("name")
        val gender = intent.getStringExtra("gender")

        val nameTextView = findViewById<TextView>(R.id.nameid)
        val genderTextView = findViewById<TextView>(R.id.genderid)

        nameTextView.text = name
        genderTextView.text = gender

        Toast.makeText(this,"Welcome to CA2 App",Toast.LENGTH_SHORT).show()
    }
}