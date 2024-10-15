package com.example.androidclassapp.spinnerapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class SpinnerApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_app)
        val destinationSpinner: Spinner = findViewById(R.id.spinner)
        val packageListView: ListView = findViewById(R.id.listView)
        val destinations = arrayOf("NewYork","Paris","Tokyo","Gaya")
        val packageForParis = arrayOf("Eiffel Tower","Louvre Museum","Arc de Triomphe")
        val packageForTokyo = arrayOf("Tokyo Skytree","Shibuya Crossing","Tokyo Tower")
        val packageForNewYork = arrayOf("Statue of Liberty","Empire State Building","Central Park")
        val packageForGaya = arrayOf("Gaya","Gaya","Gaya")

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, destinations)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        destinationSpinner.adapter = spinnerAdapter

        val initialAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, packageForParis)
        packageListView.adapter = initialAdapter

        destinationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val selectedPackages = when (position) {
                    0 -> packageForParis
                    1 -> packageForTokyo
                    2 -> packageForNewYork
                    3 -> packageForGaya
                    else -> packageForParis
                }

                val listAdapter = ArrayAdapter(this@SpinnerApp, android.R.layout.simple_list_item_1, selectedPackages)
                packageListView.adapter = listAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }


    }
}