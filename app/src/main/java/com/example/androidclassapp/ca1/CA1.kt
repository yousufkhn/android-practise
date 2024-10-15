package com.example.androidclassapp.ca1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R

class CA1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ca1)
            val name = findViewById<EditText>(R.id.nameBox)
            val password = findViewById<EditText>(R.id.passwordBox)

            val loginBtn = findViewById<Button>(R.id.loginButton)

            loginBtn.setOnClickListener {
                if(name.text.toString() != "" && password.text.toString() != ""){
                    Toast.makeText(this,"Welcome Back",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Please enter valid details",Toast.LENGTH_SHORT).show()
                }

            }
    }
}