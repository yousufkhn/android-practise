package com.example.androidclassapp.snackbar

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidclassapp.R
import com.google.android.material.snackbar.Snackbar

class SnackbarHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snackbar_home)

        val snackbarButton = findViewById<Button>(R.id.snackbar_button)
        snackbarButton.setOnClickListener { view ->
            Snackbar.make(view,"This is a snackbar",Snackbar.LENGTH_LONG).setAction("undo"){
                Toast.makeText(this,"undo was clicked",Toast.LENGTH_LONG).show()
            }
                .show()
        }

    }
}