package com.example.androidclassapp.ca2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R

class CA2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca2)

        val name = findViewById<EditText>(R.id.editTextName)
        val gender = findViewById<EditText>(R.id.editTextGender)

        val button = findViewById<Button>(R.id.submitButton)

        button.setOnClickListener {
            val nameText = name.text.toString()
            val genderText = gender.text.toString()

            val intent = Intent(this, WelcomePage::class.java)
            intent.putExtra("name", nameText)
            intent.putExtra("gender", genderText)
            startActivity(intent)

            Log.i("Tag","Succesfully logged in")

        }

    }
}