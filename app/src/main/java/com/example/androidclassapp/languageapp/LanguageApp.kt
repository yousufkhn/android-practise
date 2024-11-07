package com.example.androidclassapp.languageapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class LanguageApp : AppCompatActivity() {

    val languages = arrayOf("English","Russian","Danish","French","Italian")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language_app)

        val changeLangBtn = findViewById<Button>(R.id.changeLangBtn)

        changeLangBtn.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.custom_alert, null)

            val alertBuilder = AlertDialog.Builder(this)

            val languageList = layout.findViewById<ListView>(R.id.languageList)

            alertBuilder.setView(layout)
            val dialog = alertBuilder.create()
            dialog.show()

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
            languageList.adapter = adapter

            languageList.setOnItemClickListener { _, _, position, _ ->
                val selectedLanguage = languages[position]
                Toast.makeText(this, "$selectedLanguage selected", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }





        }
    }


}