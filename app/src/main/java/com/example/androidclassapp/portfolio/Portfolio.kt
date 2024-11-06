package com.example.androidclassapp.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.androidclassapp.R

class Portfolio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_portfolio)

        val linkedinCard = findViewById<androidx.cardview.widget.CardView>(R.id.linkedinCard)

        linkedinCard.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/muhammadyousufkhan/"))
            startActivity(intent)
        }

        val leetcodeCard = findViewById<androidx.cardview.widget.CardView>(R.id.leetcodeCard)

        leetcodeCard.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://leetcode.com/kyousuf14/"))
            startActivity(intent)
        }

        val githubCard = findViewById<androidx.cardview.widget.CardView>(R.id.githubCard)

        githubCard.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/yousufkhn"))
            startActivity(intent)
        }

        val academicsCard = findViewById<androidx.cardview.widget.CardView>(R.id.academicsCard)

        academicsCard.setOnClickListener {
            val intent = Intent(this, Academics::class.java)
            startActivity(intent)
        }
    }
}