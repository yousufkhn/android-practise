package com.example.androidclassapp.flipkart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R

class FlipkartMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flipkart_main)

        val userId = findViewById<EditText>(R.id.userId)
        val userPassword = findViewById<EditText>(R.id.userId)


        val flipkartLoginBtn = findViewById<Button>(R.id.loginButton)

        flipkartLoginBtn.setOnClickListener {

            if(userId.text.toString() !="" && userPassword.text.toString() != ""){
                val intent = Intent(this, FlipkartHome::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please enter your credentials", Toast.LENGTH_SHORT).show()
            }

        }
    }
}