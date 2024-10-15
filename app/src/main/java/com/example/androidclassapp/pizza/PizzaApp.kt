package com.example.androidclassapp.pizza

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class PizzaApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pizza_app)

        var radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val onionCheckBox = findViewById<CheckBox>(R.id.onion)
        val tomatoesCheckBox = findViewById<CheckBox>(R.id.tomatoes)
        val oliveCheckBox = findViewById<CheckBox>(R.id.olive)
        val cheeseCheckBox = findViewById<CheckBox>(R.id.cheese)

        val orderButton = findViewById<Button>(R.id.orderButton)

        orderButton.setOnClickListener {
            val selectedSizeId = radioGroup.checkedRadioButtonId

            if(selectedSizeId == -1){
                Toast.makeText(this,"Please select a size", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val selectedSize = findViewById<RadioButton>(selectedSizeId).text.toString()

            val toppings= mutableListOf<String>()

            if (onionCheckBox.isChecked) toppings.add(onionCheckBox.text.toString())
            if (tomatoesCheckBox.isChecked) toppings.add(tomatoesCheckBox.text.toString())
            if (oliveCheckBox.isChecked) toppings.add(oliveCheckBox.text.toString())
            if (cheeseCheckBox.isChecked) toppings.add(cheeseCheckBox.text.toString())

            val toppingsMessage = if (toppings.isNotEmpty()) {
                toppings.joinToString(", ")
            } else {
                "no toppings"
            }

            val message = "You have ordered a $selectedSize pizza with $toppingsMessage."

            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            val intent= Intent(this,pizzasucess::class.java)
            intent.putExtra("message",selectedSize)
            intent.putExtra("toppings",toppingsMessage)

            startActivity(intent)

        }





    }
}