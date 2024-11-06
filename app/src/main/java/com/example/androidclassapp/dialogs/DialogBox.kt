package com.example.androidclassapp.dialogs

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class DialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box)

        val subscribeBtn = findViewById<Button>(R.id.subscribeBtn)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        subscribeBtn.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.custom_alert, null)
            val emailEditText = layout.findViewById<EditText>(R.id.emailBox)

            val alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("Subscribe")
            alertBuilder.setIcon(R.drawable.spinner)
            alertBuilder.setView(layout)

            alertBuilder.setPositiveButton("Subscribe", null)
            alertBuilder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            val dialog = alertBuilder.create()
            dialog.show()

            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val email = emailEditText.text.toString()

                if (email.isEmpty()) {

                    Toast.makeText(this, "Please enter an email address.", Toast.LENGTH_SHORT).show()
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show()
                } else {

                    Toast.makeText(this, "Subscribed with: $email", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        }

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            Toast.makeText(this, "Rating: $rating", Toast.LENGTH_SHORT).show()
        }
    }
}
