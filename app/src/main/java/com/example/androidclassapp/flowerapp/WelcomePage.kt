package com.example.androidclassapp.flowerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flowershop_welcomepage)
        val BuyButton = findViewById<Button>(R.id.buyNowButton)

        BuyButton.setOnClickListener {
            val intent = Intent(this, FlowerShopPage::class.java)
            startActivity(intent)
        }
    }
}