package com.example.androidclassapp.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class CalculatorApp : AppCompatActivity() {
    private lateinit var display: TextView
    private var firstValue = 0.0
    private var secondValue = 0.0
    private var operation: String? = null
    private var isOperationClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_app)

        // Initialize the display TextView
        display = findViewById(R.id.display)

        // Initialize the buttons
        val button0: Button = findViewById(R.id.button14)
        val button1: Button = findViewById(R.id.button9)
        val button2: Button = findViewById(R.id.button10)
        val button3: Button = findViewById(R.id.button11)
        val button4: Button = findViewById(R.id.button5)
        val button5: Button = findViewById(R.id.button6)
        val button6: Button = findViewById(R.id.button7)
        val button7: Button = findViewById(R.id.button)
        val button8: Button = findViewById(R.id.button2)
        val button9: Button = findViewById(R.id.button3)

        val buttonAdd: Button = findViewById(R.id.button16)
        val buttonSubtract: Button = findViewById(R.id.button12)
        val buttonMultiply: Button = findViewById(R.id.button8)
        val buttonDivide: Button = findViewById(R.id.button4)
        val buttonClear: Button = findViewById(R.id.button13)
        val buttonEquals: Button = findViewById(R.id.button15)

        // Set button click listeners
        button0.setOnClickListener { appendNumber("0") }
        button1.setOnClickListener { appendNumber("1") }
        button2.setOnClickListener { appendNumber("2") }
        button3.setOnClickListener { appendNumber("3") }
        button4.setOnClickListener { appendNumber("4") }
        button5.setOnClickListener { appendNumber("5") }
        button6.setOnClickListener { appendNumber("6") }
        button7.setOnClickListener { appendNumber("7") }
        button8.setOnClickListener { appendNumber("8") }
        button9.setOnClickListener { appendNumber("9") }

        buttonAdd.setOnClickListener { setOperation("+") }
        buttonSubtract.setOnClickListener { setOperation("-") }
        buttonMultiply.setOnClickListener { setOperation("*") }
        buttonDivide.setOnClickListener { setOperation("/") }

        buttonClear.setOnClickListener { clear() }
        buttonEquals.setOnClickListener { calculateResult() }
    }

    private fun appendNumber(number: String) {
        if (isOperationClicked) {
            display.text = number
            isOperationClicked = false
        } else {
            display.text = if (display.text == "0") number else "${display.text}$number"
        }
    }

    private fun setOperation(op: String) {
        try {
            firstValue = display.text.toString().toDouble()
            operation = op
            isOperationClicked = true
        } catch (e: NumberFormatException) {
            display.text = "Error"
        }
    }

    private fun calculateResult() {
        try {
            secondValue = display.text.toString().toDouble()
            val result = when (operation) {
                "+" -> firstValue + secondValue
                "-" -> firstValue - secondValue
                "*" -> firstValue * secondValue
                "/" -> if (secondValue != 0.0) firstValue / secondValue else "Error"
                else -> 0.0
            }
            display.text = if (result is String) result else result.toString()
            operation = null
            isOperationClicked = true
        } catch (e: NumberFormatException) {
            display.text = "Error"
        }
    }

    private fun clear() {
        display.text = "0"
        firstValue = 0.0
        secondValue = 0.0
        operation = null
        isOperationClicked = false
    }
}