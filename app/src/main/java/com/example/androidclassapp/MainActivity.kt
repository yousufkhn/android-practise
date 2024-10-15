package com.example.androidclassapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.ca1.CA1
import com.example.androidclassapp.calculator.CalculatorApp
import com.example.androidclassapp.flipkart.FlipkartMain
import com.example.androidclassapp.flowerapp.WelcomePage
import com.example.androidclassapp.foodibles.Foodibles
import com.example.androidclassapp.lpuapp.LpuHome
import com.example.androidclassapp.pizza.PizzaApp
import com.example.androidclassapp.snackbar.SnackbarHome
import com.example.androidclassapp.spinnerapp.SpinnerApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val calculatorCard = findViewById<androidx.cardview.widget.CardView>(R.id.calculatorCard)
        val pizzaCard = findViewById<androidx.cardview.widget.CardView>(R.id.pizzaCard)
        val flowerCard = findViewById<androidx.cardview.widget.CardView>(R.id.buyFlowerCard)
        val spinnerCard = findViewById<androidx.cardview.widget.CardView>(R.id.spinnerCard)
        val ca1Card = findViewById<androidx.cardview.widget.CardView>(R.id.ca1Card)
        val flipkartCard = findViewById<androidx.cardview.widget.CardView>(R.id.flipkartCard)
        val snackbarCard = findViewById<androidx.cardview.widget.CardView>(R.id.snackbarCard)
        val lpuCard = findViewById<androidx.cardview.widget.CardView>(R.id.lpuDepartmentsCard)
        val foodiblesCard = findViewById<androidx.cardview.widget.CardView>(R.id.foodiblesCard)

        calculatorCard.setOnClickListener {
            val intent = Intent(this, CalculatorApp::class.java)
            startActivity(intent)
        }

        pizzaCard.setOnClickListener {
            val intent = Intent(this, PizzaApp::class.java)
            startActivity(intent)
        }

        flowerCard.setOnClickListener {
            val intent = Intent(this, WelcomePage::class.java)
            startActivity(intent)
        }

        spinnerCard.setOnClickListener {
            val intent = Intent(this, SpinnerApp::class.java)
            startActivity(intent)
        }

        ca1Card.setOnClickListener {
            val intent = Intent(this, CA1::class.java)
            startActivity(intent)
        }
        flipkartCard.setOnClickListener {
            val intent = Intent(this, FlipkartMain::class.java)
            startActivity(intent)
        }
        snackbarCard.setOnClickListener {
            val intent = Intent(this,SnackbarHome::class.java)
            startActivity(intent)
        }
        lpuCard.setOnClickListener {
            val intent = Intent(this, LpuHome::class.java)
            startActivity(intent)
        }
        foodiblesCard.setOnClickListener {
            val intent = Intent(this, Foodibles::class.java)
            startActivity(intent)
        }


    }
}