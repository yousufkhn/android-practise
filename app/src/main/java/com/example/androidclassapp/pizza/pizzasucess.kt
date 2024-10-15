package com.example.androidclassapp.pizza

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R

class pizzasucess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pizzasucess)

        val message = intent.getStringExtra("message")
        val toppings = intent.getStringExtra("toppings")

        val orderSummaryText = findViewById<TextView>(R.id.orderSummaryText)
        orderSummaryText.text = "Your $message pizza with $toppings is in the oven \uD83D\uDE0B"

    }
}